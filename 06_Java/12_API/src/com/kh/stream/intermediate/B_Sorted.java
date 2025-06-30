package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.model.Student;

/*
 * 정렬
 *  - 스트림은 최종 처리 되기 전에 중간 단계에서 요소들을 정렬해서 최종 처리 순서 변경
 *  - Stream<T>은 요소 객체가 Comparable 인터페이스를 구현해야 정렬
 * */
public class B_Sorted {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("오재덕", "이승민", "이환희",
				"박기민", "조규상", "이상엽", "성예찬");

		List<Student> students = Arrays.asList(
				new Student("오재덕", 20, "남자", 80, 90),
				new Student("이승민", 19, "남자", 75, 80),
				new Student("이환희", 18, "여자", 50, 100),
				new Student("박기민", 17, "남자", 70, 90),
				new Student("조규상", 18, "남자", 75, 85),
				new Student("이상엽", 20, "남자", 100, 60),
				new Student("성예찬", 19, "남자", 70, 95)
			);

	  names
	  .stream()
	  .sorted() //오름차순 정렬
	  .sorted(Comparator.reverseOrder()) //내림차순 정렬
	  .forEach(name -> System.out.print(name + " "));

	  students.stream()
	  .sorted()
	  .forEach(student -> System.out.println(student)); //student에 implements Comparable<Student>
	}

}
