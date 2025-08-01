package com.kh.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.security.model.vo.User;

@Mapper
public interface UserMapper {
	void register(User vo);
   //List<User> selectAll();
   //int total(String keyword); pagingDTO 사용, 키워드 검색 추가
	User login(String id);
  //User select(); 
  //void update();
  //void delete();
}
