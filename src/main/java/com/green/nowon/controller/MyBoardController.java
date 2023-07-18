package com.green.nowon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.nowon.domain.dto.MyBoardDTO;
import com.green.nowon.service.MyBoardService;
import com.green.nowon.service.impl.MyBoardServicePorcess;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor// final 필드를 파라미터변수로 사용하여 만들어지는 생성자
@Controller
public class MyBoardController {
	
	//interface<-class 패턴
	private final MyBoardService service; //Constructor DI
	

	@GetMapping("/my-board")////return "myboard/list";//templates경로
	public String pageAndList(
			//url ? page=1 :page라는 이름의 파라미터가 비었을떄 defaultValue 적용
			@RequestParam(defaultValue = "1") int page,
			Model model) {
		System.out.println("page:"+page);
		return service.listAll(page, model);
	}
	
	//글쓰기 페이지 이동
	@GetMapping("/my-board/new")
	public String writePage() {
		return "myboard/write";
	}
	

	@PostMapping("/my-board")
	public String saveAndList(MyBoardDTO dto) {
		
		return service.saveAndRedirect(dto);
	}
	
	//상세페이지
	//@RequestMapping(method = RequestMethod.GET, value = "/my-board/{bno}")
	@GetMapping("/my-board/{bno}")
	public String detailPageAndData(
			@PathVariable long bno,
			Model model,
			HttpServletRequest request,
			HttpServletResponse response ) {
		return service.readByBno(bno, model, request, response);
	}
	
	//@RequestMapping(method = RequestMethod.DELETE, value = "/my-board/{bno}")
	@DeleteMapping("/my-board/{bno}")
	public String delete(@PathVariable long bno) {
		return service.deleteProcess(bno);
	}
	
	
	@PutMapping("/my-board/{bno}")
	public String update(@PathVariable long bno, MyBoardDTO dto) {
		return service.updateProcess(bno, dto);
	}

	
}
