package com.green.nowon.mybatis.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.entity.ProductFileEntity;

@Mapper
public interface ProductFileMapper {

	void save(ProductFileEntity build);

	String findByPnoAndDefYn(long pno);


}
