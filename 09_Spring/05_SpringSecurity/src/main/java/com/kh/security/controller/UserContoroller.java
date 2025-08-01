package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.model.vo.User;
import com.kh.security.service.UserService;

@Controller
public class UserContoroller {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String register(User vo) {
		System.out.println(vo);
		userService.register(vo);
		return "redirect:/login";
	}
	

		
	
}
