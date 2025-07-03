package com.kh.file;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomIcecreamSelect {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("윤의진");
		list.add("김주현");
		list.add("박지연");
		list.add("강성모");
		list.add("간성훈");
		list.add("최다인");
		list.add("전영현");
		list.add("오재덕");
		list.add("이승민");
		list.add("이환희");
		list.add("박기민");
		list.add("조규상");
		list.add("성예찬");
		list.add("문채은");
		list.add("김미경");
		
		System.out.println(list);
		
		while(list.size() > 0) {
			
			Random random = new Random();
			int select = random.nextInt(list.size());
		
			System.out.println(list.remove(select));
			
		}
		
	}

}