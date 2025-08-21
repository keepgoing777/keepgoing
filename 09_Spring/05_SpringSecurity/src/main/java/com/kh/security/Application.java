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
 *   (pageContorller 수정 - getPrinclpal)
 * 3. vo 작성 - implement details
 * 4. mapper.xml - 로그인 id만 필요
 * 5. mapper.java 작성
 * 6. service.java 작성 - passwordencoder / role 부여 
 * 7. controller.java 작성 
*/

/* Security 작업 순서 (토큰 방법)
 * 1. config 수정 (httpBasic, sessionManagement)
 * 2. pom.xml dependency 추가
 * 3. JwtAuthenticationfilter class 생성 - @component, 메서드 선언(토큰 가져오기)
 * 4. config에 @Autowired filter, addFilterBefore 추가 
 * 5. TokenProvider class 생성 - 토큰 생성 및 유저정보가져오기 (vo에 @builder 추가)
 * 6. Jwt 클래스에 TokenProvider @autowired 및 user 정보에 validate된 정보 가져오기
 * 7. usercontroller login PostMapping(service.login 가져오기 및 tokenprovider 관련정리 / service login 메서드 수정 
 * 8. login.jsp 수정(로그인 토큰 생성)-> index.jsp 수정 (화면 ajax-check, logout jquery- 토큰 삭제)
 * 9. 관리자/마이페이지(403error) AwtAuthentication.java 수정 
 *
 * */
 