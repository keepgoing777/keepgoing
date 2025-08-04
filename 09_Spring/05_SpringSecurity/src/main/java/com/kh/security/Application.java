package com.kh.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kh.security.mapper")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

/* Security 작업 순서 (Session)
 * 1. pom.xml dependency 추가
 * 2. config 작성 - 상황따라 권한 부여 및 페이지 설정 (기존 sercurity 화면 외 작성된 jsp 적용)
 * 3. vo 작성 - implement details
 * 4. mapper.xml - 로그인 id만 필요
 * 5. mapper.java 작성
 * 5. service.java 작성 - passwordencoder 
 * 
 */