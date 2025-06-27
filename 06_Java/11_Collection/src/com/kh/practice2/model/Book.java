package com.kh.practice2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Data
public class Book {

	private String title;
	private boolean coupon; //boolean의 getter 형이 is임 
	private int accessAge;
	private int count; //각 책당 대여된 수 

	
	public Book(String title, boolean coupon, int accessAge) {
		this.title = title;
		this.coupon = coupon;
		this.accessAge = accessAge;
	} //맨 처음에 할당된 북 리스트때문에 클래스 생성을 아예 직접 함
	
} //Book 종료 

