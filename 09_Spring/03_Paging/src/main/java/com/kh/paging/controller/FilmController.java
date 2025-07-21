package com.kh.paging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.paging.service.FilmService;

@Controller

public class FilmController {

	@Autowired 
	private FilmService service;
}
