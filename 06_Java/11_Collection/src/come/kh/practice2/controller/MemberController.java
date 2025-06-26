package come.kh.practice2.controller;

import java.util.ArrayList;
import java.util.List;

import come.kh.practice2.model.Member;

public class MemberController {
	//전체 회원 목록
	private List<Member> members = new ArrayList<>();
	
	//현재 로그인된 회원(여러명이 힘들경우 이걸로)
	private Member member = null;

//회원가입 및 로그인 처리
public boolean registerAndLogin(String name, int age) {
	//동일 이름 존재하면 가입 불가 처리
	//이름이랑 나이가 같은 경우 로그인 처리
	//기존에 해당하는 이름이 없다면 가입 후 로그인 처리
	return false;
}	

//로그아웃
public void logout() {
	return null;
}

//마이페이지
public void getMember() {
	return null;
}
}
