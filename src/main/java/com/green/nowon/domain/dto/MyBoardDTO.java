package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter//thymeleaf에서 EL
@Setter
public class MyBoardDTO {
	private long bno;//auto_increment
	private String title;
	private String content;
	private String writer;
	private int readCount;//default 0
	private LocalDateTime createdDate;	//current_timestamp()
	private LocalDateTime updatedDate;	//current_timestamp()
	
	//편의메서드
	public MyBoardDTO bno(long bno) {
		this.bno=bno;
		return this;//현재셋팅된 자시자신 MyBoardDTO
	}

}
