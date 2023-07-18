package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ProductListDTO {

	private long pno;//상품관리번호
	private String title;//상품명
	private int price;
	private LocalDateTime updatedDate;
	
	//list페이지에서 추가로 def이미지 1장
	private String defUrl;
	//defUrl 세팅해주는 편의메서드
	public ProductListDTO defUrl(String defUrl) {
		this.defUrl=defUrl;
		return this;
	}
	
	
	//Entity클래스에서 일부만 추출해서 생성
	public ProductListDTO(ProductEntity e) {
		this.pno = e.getPno();
		this.title = e.getTitle();
		this.price = e.getPrice();
		this.updatedDate = e.getUpdatedDate();
		String path="//s3.ap-northeast-2.amazonaws.com/web.fileupload.bucket/product/images/";
		defUrl=path+e.getFiles().get(0).getNewName();
	}
	


}
