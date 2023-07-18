package com.green.nowon.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Aspect
@Component
public class LoggerAspect {
	
	@Around("execution(* com.green.nowon.controller.*.*(..)) or "
			+ "execution(* com.green.nowon.service.impl.*.*(..)) or "
			+ "execution(* com.green.nowon.mybatis.mapper.*.*(..))")
	public Object logPrint(ProceedingJoinPoint jp) throws Throwable {
		String type="";
		String name=jp.getSignature().getDeclaringTypeName();
		if(name.indexOf("Controller")>-1) {
			type="1. Controller \t";
		}else if(name.indexOf("Service")>-1) {
			type="2. Service \t";
		}else if(name.indexOf("Mapper")>-1) {
			type="3. DAO \t";
		}
		log.debug("<---------- : "+type+name+"."+jp.getSignature().getName()+"() START: ---------->");
		Object object =jp.proceed();
		//log.debug("<---------- : "+type+name+"."+jp.getSignature().getName()+"() END: ---------->");
		
		return object;
	}

}
