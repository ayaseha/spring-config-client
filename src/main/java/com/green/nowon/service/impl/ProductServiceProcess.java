package com.green.nowon.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.aws.AwsS3BucketUtil;
import com.green.nowon.domain.dto.product.ProductSaveDTO;
import com.green.nowon.domain.entity.ProductEntity;
import com.green.nowon.domain.entity.ProductFileEntity;
import com.green.nowon.domain.entity.ProductListDTO;
import com.green.nowon.mybatis.mapper.ProductFileMapper;
import com.green.nowon.mybatis.mapper.ProductMapper;
import com.green.nowon.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceProcess implements ProductService {
	
	//DAO : aws-s3에 접근하는 객체
	private final AwsS3BucketUtil dao;
	
	private final ProductMapper mapper;
	
	private final ProductFileMapper fileMapper;
	
	@Value("${cloud.aws.s3.use-url}")
	private String imgUrl;
	
	@Override
	public Map<String, String> tempUploadProcess(MultipartFile tempFile) {
		//1. MultipartFile 데이터를 S3에 업로드
		
		//2. 업로드된 경로를 페이지(ajax의 success function의 result)로 리턴 
		return dao.tempUpload(tempFile);
	}

	@Override
	public void saveProcess(ProductSaveDTO dto) {
		// 상품데이터 저장
		ProductEntity entity=dto.toProductEntity();
		mapper.save(entity);
		
		// 여러개 파일저장, temp->이동
		List<String> orgNames=dto.getImgs().stream()
					.filter(org->!org.trim().equals(""))
					.collect(Collectors.toList());
		
		List<String> newNames=dao.formtempToProduct(dto.getTempKey());
		
		long pno=entity.getPno();//fk
		for(int i=0; i<orgNames.size(); i++) {
			Boolean defYn=false;
			
			if(i==0)defYn=true;
			String orgName=orgNames.get(i);//원본파일명
			String newName=newNames.get(i);//새로운이름:업로드된 이름
			
			fileMapper.save(ProductFileEntity.builder()
					.orgName(orgName).newName(newName).pno(pno).defYn(defYn)
					.build());
		}
		
	}

	@Override
	public void listProcess(Model model) {
		//1.product 2. product_file 테이블에 접근
		// List<ProductEntity> -> List<ProductListDTO>
		
		model.addAttribute("list",mapper.findByAll().stream()//stream이 순차적으로 시퀀스나열해서 확인
				.map(ProductListDTO::new)//map에서 listdto클래스로 새것을 만들어서
				.map(dto->{
					long pno=dto.getPno();
					String newName=fileMapper.findByPnoAndDefYn(pno);
					return dto.defUrl(imgUrl+newName);
				})
				.collect(Collectors.toList()));
		
	}
	
	//join 쿼리 실행 후 resultMap에 매핑방법
	@Override
	public void listJoinProcess(Model model) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		mapper.findByAllJoinFile().forEach(System.out::println);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		model.addAttribute("list",mapper.findByAllJoinFile());
		
	}
	//join 쿼리 실행 후 resultMap에 매핑방법 -> DTO로 처리
	@Override
	public void listJoinProcess3(Model model) {
		model.addAttribute("list", mapper.findByAllJoinFile().stream()
															.map(ProductListDTO::new)
															.collect(Collectors.toList()));
						
		
	}

}
