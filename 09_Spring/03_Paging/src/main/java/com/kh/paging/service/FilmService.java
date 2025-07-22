package com.kh.paging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.mapper.FilmMapper;
import com.kh.paging.vo.Film;

@Service
public class FilmService implements FilmMapper{
 
 @Autowired
 private FilmMapper mapper;

 @Override
 public List<Film> showFilm(PagingDTO paging){
   /*
    * 만약에 limit가 10인경우 
    * page = 1 -> offset = 0
    * page = 2 -> offset = 10
    * page = 3 -> offset = 20
    *
    * offset = limit * (page - 1)
    * */
	 paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
	 return mapper.showFilm(paging);
 }

}
