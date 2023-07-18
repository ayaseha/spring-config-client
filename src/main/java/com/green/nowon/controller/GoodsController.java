package com.green.nowon.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.goods.GoodsSaveDTO;
import com.green.nowon.service.GoodsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GoodsController {
	
	private final GoodsService service; //DI
	
	@GetMapping("/goods")
	public String list(Model model) {
		service.getlistProcess(model);
		return "goods/list";
	}
	
	@GetMapping("/goods/new")
	public String write() {
		return "goods/write";
	}
	
	@PostMapping("/goods")
	public String save(MultipartFile img, GoodsSaveDTO dto) throws IOException, Exception {
//		System.out.println(dto);
//		System.out.println(img.getContentType()); //
//		System.out.println(img.getName()); //form input name
//		System.out.println(img.getOriginalFilename());
//		System.out.println(img.getSize());
		
		service.saveProcess(img,dto);
		
		return "redirect:/goods";
	}
}
