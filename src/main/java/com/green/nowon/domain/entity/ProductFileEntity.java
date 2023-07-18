package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder //빌더패턴 객체생성하기위한 표현 //파라미터가 존재하는 생성자가 필수
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductFileEntity {
	
	private long fno;
	private String orgName;
	private String newName;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	//fk
	private long pno;//FK product 테이블의 pk값만 저장
	private boolean defYn;
	//fk가 만들어져있는 테이블이 일대다 관계에서 '다' 테이블이다.
}
