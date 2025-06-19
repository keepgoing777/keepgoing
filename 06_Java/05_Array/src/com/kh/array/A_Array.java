package com.kh.array;

public class A_Array {

	public static void main(String[] args) {
		A_Array a = new A_Array();
		//a.method1();
		a.method2();
		  
	  
/*
 * 배열 : 하나의 공간에 "여러개의 값"(같은 자료형의 값)을 담음
 * 
 * 배열의 선언
 * 자료형[] 배열명;
 * 자려형 배열명[];
 *  - 배열을 선언한다고 해서 값을 저장할 공간이 생성되는 것이 아니라 배열을 다루는데 필요한 변수가 생성
 *  
 * 배열의 초기화
 * 배열명 = new 자료형[배열크기];
 *  - 생성된 배열에 처음으로 값을 저장
 *  
 *  배열의 선언과 초기화 동시 진행
 *  자료형[] 배열명 = new 자료형[배열크기];
 * 
 * */
	}
	
	public void method1() {
		int[] nums = new int[5]; // 배열 크기 지정하지 않으면 에러!
		System.out.println(nums);
		
		// 배열 생성하고 해당값들은 초기화하지 않은 상태 => 기본값이 들어감 
		// 정수형: 0, 실수형: 0.0 문자형:\u0000, 논리형: false, 참조형:null
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
		 
	    nums[0] = 100;
	    nums[1] = 50;
	    nums[2] = 43;
	    nums[3] = 76;
	    nums[4] = 89;

	    	
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
		System.out.println(nums[5]);
	}

	// 배열 선언과 동시에 값들 초기화
	public void method2() {
	  int[] nums = {100, 50, 43, 76, 89};
	  
	  for(int i = 0 ; i < nums.length ; i++) {
		  System.out.println(nums[i]);
	  }
		
	}
	
	
}
