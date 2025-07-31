package com.kh.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

@Mapper
public interface MemberMapper {
    void register(Member vo);
	Member login(Member vo);
	List<Member> allMember();
	void update(Member vo);
	List<Member> search(SearchDTO dto);
	void delete(String id);
	void selectDelete(List<String> idList);
}
