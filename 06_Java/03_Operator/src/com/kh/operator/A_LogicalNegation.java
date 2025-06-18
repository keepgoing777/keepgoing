package com.kh.operator;

public class A_LogicalNegation {

	public static void main(String[] args) {
        /*
         * 논리 부정 연산자
         * 
         * !논리값(true, false)
         *  - 논리값을 반대로 바꾸는 연산자 (true->false, false->true)
         * */
		boolean isTrue = true;
		boolean isFalse = false;
		
		System.out.println(!isTrue); //false
		System.out.println(!isFalse);  //true
		
		isTrue = !isFalse;
		
		System.out.println(!!!isTrue); //false
		
	}

}
