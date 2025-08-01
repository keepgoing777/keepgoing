package com.kh.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	//제어 가능한 방화벽 만드는 과정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable()) //웹 보안 토큰 설정(비활성화)
				.authorizeHttpRequests(authorize ->
				authorize
				        .requestMatchers("/mypage").authenticated()
				        .requestMatchers("/admin").hasRole("ADMIN")
					   //.requestMatchers("/register").authenticated() 
						.anyRequest().permitAll() //url 제어 시작, 모든 요청 허용
				) 
				.formLogin(form -> form
						.loginPage("/login") ///login 페이지 폼으로 쓸거야 
						.defaultSuccessUrl("/mypage") //로그인 성공 시 mypage로 갈거야
				)
				.logout(logout ->logout
						.logoutUrl("/logout") //logout 페이지 폼으로 쓸거야
				        .logoutSuccessUrl("/") //logout 성공 시 메인으로 갈거야
				)
			    
				.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
