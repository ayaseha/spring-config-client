package com.green.nowon.domain.dto.goods;

import com.green.nowon.domain.entity.GoodsEntity;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class GoodsSaveDTO {
	
	private String name;
	private int price;
	private String content;
	
	//편의 메서드
	public GoodsEntity toEntity() {
		return GoodsEntity.builder() //innerClass인 GoodsEntityBuilder 객체생성
				.name(name).price(price).content(content) //name, price,content를 set한 GoodsEntityBuilder 객체
				.build();//build를 통해 바깥쪽 클래스 객체를 생성
		//return new GoodsEntity(); 와 동일하다
	}
}
