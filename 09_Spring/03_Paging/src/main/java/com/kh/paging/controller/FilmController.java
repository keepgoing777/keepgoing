package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.service.FilmService;
import com.kh.paging.vo.Film;

@Controller
public class FilmController {

	@Autowired 
	private FilmService service;
	
	//localhost:8080/list (get 방식)
	@GetMapping("/list")
	public String list(Model model, PagingDTO paging) {
		
		PagingDTO dto = new PagingDTO();
		List<Film> list = service.showFilm(dto);
		System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total()));
		// paging.getEndPage() 확인
	    return "list";
	}
	
}
