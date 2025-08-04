package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	//제어 가능한 방화벽 만드는 과정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable()) //웹 보안 토큰 설정(비활성화)
				.httpBasic(basic -> basic.disable()) // HTTP Basic 인증 방식 비활성화 -> JWT 토큰방식 이용
				.sessionManagement(session -> 
				 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //세션 설정 -> STATELESS 무상태 방식 설정
				.authorizeHttpRequests(authorize ->
				 authorize
				        .requestMatchers("/mypage").authenticated()
				        .requestMatchers("/admin").hasRole("ADMIN")
					   //.requestMatchers("/register").authenticated() 
						.anyRequest().permitAll() //url 제어 시작, 모든 요청 허용
				) 
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)			    
				.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
