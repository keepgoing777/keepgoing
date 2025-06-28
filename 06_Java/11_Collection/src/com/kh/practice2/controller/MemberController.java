package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice2.model.Member;

public class MemberController {
	//전체 회원 목록
	private List<Member> members = new ArrayList<>();
	
	//현재 로그인된 회원(여러명이 힘들경우 이걸로)
	private Member member = null;

//회원가입 및 로그인 처리
public boolean registerAndLogin(String name, int age) {

	 
	//이름이랑 나이가 같은 경우 로그인 처리
	 for(Member member : members) {
		 if(member.getName().equals(name) && member.getAge() == age) {
			 this.member = member;
			 return true;
		 }
		//동일 이름 존재하면 가입 불가 처리
		if(member.getName().equals(name)) {
			return false;
		}
	 }
	 
	 // 회원가입 처리 
	 Member m = new Member();
	 m.setName(name);
	 m.setAge(age);
	 members.add(m);
	 // 로그인 처리
     this.member = m;
	 return true;
  }	

//로그아웃
public void logout() {
	member = null;
  }

//마이페이지
public Member getMember() {
	return member;
  }

//대여 후 멤버 정보 새로 저장
public void setMember(Member memeber) {
	for(int i = 0 ; i < members.size(); i++) {
		Member m = members.get(i);
		if(m.getName().equals(member.getName())) {
			members.set(i, member);
		}
	 }
  }

}//controller 종료
