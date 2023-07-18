package com.green.nowon.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

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
public class ProductEntity {
	//상품정보
	private long pno;//상품관리번호
	private String title;//상품명
	private String content; //내용
	private int price;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
	//상품:파일정보 1:N
	//상품정보 1개당 파일이 여러개 존재함
	List<ProductFileEntity> files;
	

}
