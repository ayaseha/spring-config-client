package com.green.nowon.domain.dto.goods;

import java.time.LocalDateTime;
import java.util.List;

import com.green.nowon.domain.entity.GoodsEntity;
import com.green.nowon.domain.entity.GoodsFileEntity;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class GoodsListDTO {
	
	private long gno;//상품관리번호
	private String name;//상품명
	//private String content; //내용
	private int price;
	//private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
	//상품정보의 이미지
	List<GoodsFileEntity> imgs;
	//편의메서드
	public GoodsListDTO imgs(List<GoodsFileEntity> imgs) {
		this.imgs=imgs;
		return this;
	}
	
	public GoodsListDTO(GoodsEntity e) {
		this.gno = e.getGno();
		this.name = e.getName();
		this.price = e.getPrice();
		this.updatedDate = e.getUpdatedDate();
	}
	
	

}
