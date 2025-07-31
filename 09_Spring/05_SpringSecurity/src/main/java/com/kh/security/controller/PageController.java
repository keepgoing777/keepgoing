package com.kh.security.controller;

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
	
	
}
