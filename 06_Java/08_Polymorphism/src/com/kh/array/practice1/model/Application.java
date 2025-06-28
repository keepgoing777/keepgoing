package com.kh.array.practice1.model;

import java.util.Arrays;

import com.kh.array.practice1.model.Student;

public class Application {

	public static void main(String[] args) {
	//객체 배열

	Student[] arr = new Student[5];
	
	arr[0] = new Student("이승민", "HTML", 100);
	arr[1] = new Student("오재덕", "CSS", 95);
	arr[2] = new Student("전영현", "JavaScript", 87);
	arr[3] = new Student("김주현", "Database", 93);
	arr[4] = new Student("윤의진", "Java", 85);
	
	System.out.println(Arrays.toString(arr));
	for(int i = 0 ; i <arr.length ; i++) {
		System.out.println(arr[i]); // (student)랑 같은 값 
		
		
	}
	
	for(Student student : arr) {
		System.out.println(student.getName());
		System.out.println(student.getSubject());
		System.out.println(student.getScore());
	}
	}

}
