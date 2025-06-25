package com.kh.list.model;
//프로젝트에서 오른쪽마우스> properties > java build path > Libraries > Classpath >add External nom

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Person {
	
   private String name;
   private String addr;
   private int age;
}
