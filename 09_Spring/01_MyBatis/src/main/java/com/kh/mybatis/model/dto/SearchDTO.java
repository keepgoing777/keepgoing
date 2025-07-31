package com.kh.mybatis.model.dto;

import lombok.Getter;
import lombok.Setter;

// DTO(Date Transfer Object) : 데이터 전송 객체

@Getter @Setter 
public class SearchDTO {
  
    //검색조건과 검색어를 하나의 객체로 묶어주는 SearchDTO : 화면의 검색 폼 데이터 그대로 받음
	private String select;
	private String keyword;
	
}
