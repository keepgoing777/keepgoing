package com.kh.stream.model;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student> {
	
 private String name;
 private int age; 
 private String gender;
 private int math;
 private int english;
 
 @Override
 public int compareTo(Student o) {
	return this.age - o.age; //나이 기준으로
 }
 
}
