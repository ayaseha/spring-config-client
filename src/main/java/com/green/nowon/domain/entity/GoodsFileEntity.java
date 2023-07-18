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
public class GoodsFileEntity {
	
	private long fno;
	private String url; //파일경로
	private String name; //파일이름
	private long size;//파일크기 byte기준
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	//fk
	private long gno;//FK Goods 테이블의 pk값만 저장
	//fk가 만들어져있는 테이블이 일대다 관계에서 '다' 테이블이다.
}
