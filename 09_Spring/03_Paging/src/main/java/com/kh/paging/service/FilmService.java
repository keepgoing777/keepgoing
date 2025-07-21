package com.kh.paging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.paging.mapper.FilmMapper;
import com.kh.paging.vo.Film;

@Service
public class FilmService {
 
 @Autowired
 private FilmMapper mapper;

 public List<Film> showFilm(){
	 return mapper.showFilm();
 }

}
