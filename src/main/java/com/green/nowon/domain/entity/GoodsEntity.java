package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import com.green.nowon.domain.dto.goods.GoodsListDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor //필드6개 모두를 초기화 역할을 하는 파라미터가 정의된 생성자
@NoArgsConstructor //인자없이 생성할 수 있는 생성자.//파라미터가 정의되지않은 생성자
@Getter
public class GoodsEntity {

	private long gno;//상품관리번호
	private String name;//상품명
	private String content; //내용
	private int price;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
	public GoodsListDTO toListDTO() {
		return new GoodsListDTO(this);
	}

}
