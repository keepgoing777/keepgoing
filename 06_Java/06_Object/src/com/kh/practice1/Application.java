package com.kh.practice1;

import com.kh.practice1.model.UserInfo;

public class Application {

	public static void main(String[] args) {
		//메인 메서드에서 UserInfo 객체 생성
		UserInfo u = new UserInfo();
		
		//changeName()으로 이름 변경 후
		u.changeName("뭉뭉이");
		
		// printName()
		System.out.println(u.printName());

	}

}
