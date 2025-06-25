package com.kh.practice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * NoArgsConstructor : 기본 생성자 (lombok 에서 제공하는)
 * AllArgsConstructor : 모든 필드를 매개 변수로 받는 생성자 
 * Getter / Setter : 모든 필드의 Getter / Setter 메서드
 * ToString : toString 메서드
 * Data : Getter, Setter, ToString, EqualsAndHashcode, RequiredArgsConstructor 포함
 * */
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
@ToString
public class UserInfo  {
	
	private int userNo;
	private String id;
	private String password;
	private String email;
	private String name;
	private String phone;
	private String addr;
	private String gender;
	private LocalDate birthDate;
	// 임시적으로 부서 넣어둠 (원칙상 안됨) 
	private int deptNo;
	private Department department;

	
}
