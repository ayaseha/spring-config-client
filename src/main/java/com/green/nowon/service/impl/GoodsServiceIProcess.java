package com.green.nowon.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.aws.S3BucketService;
import com.green.nowon.domain.dto.goods.GoodsListDTO;
import com.green.nowon.domain.dto.goods.GoodsSaveDTO;
import com.green.nowon.domain.entity.GoodsEntity;
import com.green.nowon.domain.entity.GoodsFileEntity;
import com.green.nowon.mybatis.mapper.GoodsFileMapper;
import com.green.nowon.mybatis.mapper.GoodsMapper;
import com.green.nowon.service.GoodsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GoodsServiceIProcess implements GoodsService {

	// DAO : mapper, repository --> interface 로 구성
	private final GoodsMapper mapper;// DI 외부에서 주입: 내부코드에서 결정하지않아요 (IoC)
	
	private final GoodsFileMapper fileMapper;
	
	private final S3BucketService service;

	@Override
	public void saveProcess(MultipartFile img, GoodsSaveDTO dto) throws Exception, IOException {
		service.upload(img);
		/*
		// 1.상품정보 저장 DB goods테이블에 저장
		GoodsEntity goods=dto.toEntity();
		System.out.println("insert 실행 전:"+goods);
		mapper.save(goods);
		System.out.println("insert 실행 후: "+goods); //pk컬럼값이 매핑된 결과를 볼 수 있다.
		
		// 2.서버에 업로드
		//*
		long size = img.getSize();
		String url="/images/upload/goods/";
		String name = img.getOriginalFilename();
//		String fileFolder= "E:/ncs2023/spring/spring-config-client/bin/main/static/images/upload/goods/";// 업로드되는 서버의 주소
//		File dest=new File(fileFolder+name);
		
		ClassPathResource cpr=new ClassPathResource("/static"+url);
		System.out.println("업로드폴더:"+cpr.getPath().toString());
		File dest=new File(cpr.getFile(), name);
		img.transferTo(dest);
		System.out.println(">>>>>>:파일업로드완료!");
		//*
		
		// 3.파일정보 저장 DB goods_file 테이블에 저장
		//* 
		fileMapper.save(GoodsFileEntity.builder()
				.size(size).url(url).name(name).gno(goods.getGno())
				.build());
				*/
	}

	@Override
	public void getlistProcess(Model model) {
		// DB에서 상품정보 읽어오고 파일도 있으면 같이 읽어와야함
		List<GoodsListDTO> list=mapper.findAll().stream().map(GoodsListDTO::new)
				.map((t)->t.imgs(fileMapper.findByGno(t.getGno())))
				.collect(Collectors.toList());
		
		//list.forEach(System.out::println);
		//list.forEach((t)->{System.out.println(t);});
		/*
		list.forEach(new Consumer<GoodsListDTO>() {
			@Override
			public void accept(GoodsListDTO t) {
				System.out.println(t);
			}
		});
		
		model.addAttribute("list", list);
		
		//람다식(Lambda) : 추상메서드가 하나만 존재하는 인터페이스 중 Function ()->{} 메서드안에서 오버라이드할 바디만. 나머지는 다 생략
		/*
		List<GoodsListDTO> list=mapper.findAll()//List<GoodsEntity>를 가져옴
				.stream() //Stream<GoodsEntity>로 변한상태
				//.map((e)->{return new GoodsListDTO(e);})
				//.map((e)->new GoodsListDTO(e))
				.map(GoodsListDTO::new)
				.collect(Collectors.toList());
		
		List<GoodsListDTO> list2=mapper.findAll().stream().map(GoodsListDTO::new).collect(Collectors.toList());
		//*/
		
		/*
		List<GoodsEntity> result=mapper.findAll();
		List<GoodsListDTO> list=new ArrayList<>();
		for(GoodsEntity ent:result) {
			GoodsListDTO dto=new GoodsListDTO(ent);
			list.add(dto);
		}
		*/
		
		
	}

}
