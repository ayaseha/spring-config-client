package com.green.nowon.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.product.ProductSaveDTO;
import com.green.nowon.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProductsController {
	
	
	private final ProductService service;
	
	@PostMapping("/products")
	public String save(ProductSaveDTO dto) {
		service.saveProcess(dto);
		return "redirect:/products";
	}
	
	//상품리스트페이지 
	@GetMapping("/products")
	public String list(Model model) {
		//service.listProcess(model);
		//return "product/list";
		//service.listJoinProcess(model);
		//return "product/list2";
		service.listJoinProcess3(model);
		return "product/list";
	}
	
	@GetMapping("/products/new")
	public String wirtePage() {
		return "product/write";
	}
	
	//비동기 요청처리입니다.
	@ResponseBody //리턴타입이 응답데이터라는 뜻 JSON으로 보냄.성공시 success함수에 파라미터로 전달
	@PostMapping("/products/temp-upload")
	public Map<String,String> tempUpload(MultipartFile tempFile, String tempKey) {
		//업로드된 S3의 경로,파일이름 등 
		return service.tempUploadProcess(tempFile);
	}
}
