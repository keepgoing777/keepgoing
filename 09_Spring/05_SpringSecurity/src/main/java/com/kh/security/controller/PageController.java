package com.kh.security.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/index")
	public void index() {}
	
	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/register")
	public void register() {}
	
	@GetMapping("/mypage")
	public void mypage() {}
	
	@GetMapping("/admin")
	public void admin() {
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = (User) auth.getPrincipal();
	System.out.println(user);
   }
	
}
