package com.kh.practice2.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Data
public class Member {

	private String name;
	private int age;
	private int coupon;
	private ArrayList<Book> bookList = new ArrayList<>();

/*생성자로 NewMember(name, age) 회원목록에 추가할 때 필요 
   public Member(String name, int age) {
	this.name = name;
	this.age = age;
  }
*/
 
} //Member 종료
