package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kh.stream.model.Student;

/*
 * 필터링
 *  - 중간 처리 기능으로 요소를 걸러내는 역할 * 
 * */
public class A_Filtering {
	
	List<String> names = Arrays.asList("오재덕", "이승민", "이환희",
			"오재덕", "이승민", "이환희",
			"박기민", "조규상", "이상엽", "성예찬");

	List<Student> students = Arrays.asList(
			new Student("오재덕", 20, "남자", 80, 90),
			new Student("이승민", 19, "남자", 75, 80),
			new Student("이환희", 18, "여자", 50, 100),
			new Student("박기민", 17, "남자", 70, 90),
			new Student("조규상", 18, "남자", 75, 85),
			new Student("이상엽", 20, "남자", 100, 60),
			new Student("성예찬", 19, "남자", 70, 95),
			new Student("박기민", 17, "남자", 70, 90),
			new Student("조규상", 18, "남자", 75, 85),
			new Student("이상엽", 20, "남자", 100, 60),
			new Student("성예찬", 19, "남자", 70, 95)
		);

	//distinct : 중복 제거
	public void method1() {
		
		Stream<String> stream = names.stream();
		stream
		.distinct()
		.forEach(name -> System.out.print(name + " "));
		
		students.stream()
		.distinct()
		.forEach(student -> System.out.print(student));
	
		
	}
	
	public void method2() {
		names.stream()
		.filter(name -> name.startsWith("이"))
		.distinct()
		.forEach(name -> System.out.print(name+ " "));
		System.out.println("------------------");
		
	//students 활용, 나이가 19살 이상인 사람만 출력
		
		students.stream()
		.distinct()
		.filter(student -> student.getAge() >= 19)
		.forEach(student -> System.out.println(student));
		System.out.println("------------------");
		
    // 수학 점수, 영어 점수 둘다 70점 이상인 사람만 출력
		students.stream()
		.distinct()
		.filter(student -> student.getMath() >= 70 && student.getEnglish() >= 70)
		.forEach(student -> System.out.println(student));
		
	}
	public static void main(String[] args) {
       A_Filtering a = new A_Filtering();
     //a.method1();
       a.method2();
	}

}
