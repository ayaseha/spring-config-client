package com.green.nowon.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.BoardDTO;
import com.green.nowon.domain.dto.BoardSaveDTO;
import com.green.nowon.domain.dto.BoardUpdateDTO;

@Mapper //spring mybatis에서 db에 CRUD(DML) 하기위한 객체 
public interface BoardMapper {
	//xml파일을 이용하는겨우 mapper.xml 에서 sql처리

	void save(BoardSaveDTO dto);

	List<BoardDTO> findAll();

	BoardDTO findByBno(long bno);

	void deleteByBno(long bno);

	void updateByBto(BoardUpdateDTO dto);

}
