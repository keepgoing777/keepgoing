package com.kh.stream.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kh.stream.model.Student;

/*
 * 수집
 * - 최종 처리 기능으로 필터링 또는 매핑한 요소들을 
 *       새로운 컬렉션으로 담아서 리턴하는 collect() 제공
 * */
public class C_Collect {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("오재덕", 20, "남자", 80, 90),
				new Student("이승민", 19, "남자", 75, 80), new Student("이환희", 18, "여자", 50, 100),
				new Student("박기민", 17, "남자", 70, 90), new Student("조규상", 18, "남자", 75, 85),
				new Student("이상엽", 20, "남자", 100, 60), new Student("성예찬", 19, "남자", 70, 95));
		
		// List 컬렉션으로 수집 -> 영어 점수가 90점 이상인 사람들만
		ArrayList<Student> list = students.stream()
							.filter(student -> student.getEnglish() >= 90)
							//.collect(Collectors.toList());
							.collect(Collectors.toCollection(() -> new ArrayList<>()));
		System.out.println(list);
		
		// Set 컬렉션으로 수집 -> 고등학생인 사람들만
		HashSet<Student> set = students.stream()
							.filter(student -> student.getAge() < 20)
							//.collect(Collectors.toSet());
							.collect(Collectors.toCollection(() -> new HashSet<>()));
		System.out.println(set);
		
		// Map 컬렉션으로 수집 -> 키 : 이름, 값 : 나이
		Map<String, Integer> map = students.stream()
									.collect(Collectors.toMap(student -> student.getName(), 
																student -> student.getAge()));
		System.out.println(map);
	
	}

}