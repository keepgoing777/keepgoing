package com.kh.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/ajax1")
	public String ajax1() {
		return "01_count";
	}
	
	@GetMapping("/ajax2")
	public String ajax2() {
		return "02_encoding";
	}
}
