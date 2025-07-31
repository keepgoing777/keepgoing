package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.security.service.UserService;

@Controller
public class UserContoroller {
	
	@Autowired
	private UserService service;
}
