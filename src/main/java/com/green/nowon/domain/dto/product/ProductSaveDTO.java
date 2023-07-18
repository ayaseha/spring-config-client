package com.green.nowon.domain.dto.product;

import java.util.List;

import com.green.nowon.domain.entity.ProductEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ProductSaveDTO {
	
	private String title;
	private int price;
	private String content;
	
	private List<String> imgs;
	private List<String> tempKey;
	
	public ProductEntity toProductEntity() {
		return ProductEntity.builder()
							.title(title).price(price).content(content)	
							.build();
	}
	
}
