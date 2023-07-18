package com.green.nowon.mybatis.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.green.nowon.domain.dto.MyBoardDTO;

@Mapper
public interface MyBoardMapper {
	
	List<MyBoardDTO> findAll(@Param("limit") int limit,@Param("offset") int offset);
	
	MyBoardDTO findByBno(long bno);//where절에 pk컬럼(bno)의 값이 일치하는겨우이므로 단일행 결과가 나와요  

	int save(MyBoardDTO dto);

	int deleteByBno(long bno);

	int updateByBno(MyBoardDTO bno);

	void addCount(long bno);

	@Select("select count(*) from my_board")
	int countAll();

}
