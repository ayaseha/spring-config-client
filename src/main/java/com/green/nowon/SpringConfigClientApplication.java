package com.green.nowon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringConfigClientApplication {
	
	static {
		System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}
	/*
	 * 
	 * 
	application.properties파일에 설정하면
	spring.mvc.hiddenmethod.filter.enabled=true
	
	만약에 빈으로 설정한다면 아래와같이
	@Bean
	HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
	*/

}
