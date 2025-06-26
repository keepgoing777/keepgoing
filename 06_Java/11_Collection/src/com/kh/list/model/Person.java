package com.kh.list.model;
//프로젝트에서 오른쪽마우스> properties > java build path > Libraries > Classpath >add External nom

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //Getter, Setter, ToString, EqualsAnd HashCode 포함 

//implements Comparable<Person> 기재, Person add unimplemented methods 추가 
public class Person implements Comparable<Person>{
	
   private String name;
   private String addr;
   private int age;
/*
 * compareTo : 반환된 값을 가지고 정렬기준 잡아주는 메서드
 *  - 자기자신과 파라미터값으로 전달된 객체가 같은 타입인지 객체인지 비교
 *  - 비교해서 같으면 0, 자기 자신보다 크다면 양의 정수(1), 작다면 음의 정수(-1) 반환
 * */   
   
 //나이 순서대로 정렬 시 사용  
 /*  @Override
   public int compareTo(Person o) {
	return this.age == o.age ? 0 : this.age > o.age ? 1: -1;
   }
 */  
   
 //이름 순서대로 정렬 시 사용
   @Override
   public int compareTo(Person o) {
	return this.name.compareTo(o.name); 
   }
   
  
}
