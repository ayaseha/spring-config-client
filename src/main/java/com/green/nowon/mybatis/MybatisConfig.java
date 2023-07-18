package com.green.nowon.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor 
@Configuration
public class MybatisConfig {
	
	private final DataSource dataSource;
	private final ApplicationContext application;
	
	//SqlSessionFactory : In MyBatis-Spring, an SqlSessionFactoryBean is used to create an SqlSessionFactory
	@Bean
	SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		log.debug("jpa세팅시 만들어진 ds:"+dataSource);
		factoryBean.setDataSource(dataSource);
		
		//mapper.xml 사용시 위치설정 앤트패턴 문자열로 정의
		// src/main/resources -> classpath: ,   /**/ 하위모든폴더 ,  *-mapper.xml  :  *(0개또는 글자수상관없이 모두) -mapper.xml 로끝나는 파일 
		String locationPattern="classpath:/mapper/**/*-mapper.xml";
		//Resource... 이란 파라미터에서만 허용하는 배열문법  Resource... == Resource[]
		Resource[] mapperLocations=application.getResources(locationPattern);
		factoryBean.setMapperLocations(mapperLocations);
		
		factoryBean.setConfiguration(mybatisConfiguration());//마이바티스 구성
		
		return factoryBean.getObject();
	}
	
	//db: created_date -> java : createdDate
	@ConfigurationProperties(prefix = "mybatis.configuration")
	@Bean
	org.apache.ibatis.session.Configuration mybatisConfiguration() {
		return new org.apache.ibatis.session.Configuration();
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
}
