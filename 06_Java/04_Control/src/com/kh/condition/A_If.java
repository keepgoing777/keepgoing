package com.kh.condition;

import java.net.MulticastSocket;
import java.util.Scanner;

public class A_If {

    Scanner sc = new Scanner(System.in);	
    /*
     *if 문
     *
     * if(조건식) {
     *    조건식이 참(true)일 때 실행
     * } else {
     *    조건식이 거짓(false)일 때 실행
     * }
     *  - 보통 조건식에는 비교 연산자, 논리 연산자를 주로 사용 (결과가 boolean값으로 나와서)
     */
    
    public void method1() {
    	// 입력받은 성적이 60점 이상이면 "합격입니다" 출력
    	System.out.print("성적을 입력해 주세요 > ");
    	int score = sc.nextInt();
       // if(score >= 60){ System.out.println("합격입니다");} : 한줄일때만 중괄호 생략가능
          if(score >= 60) System.out.println("합격입니다");
          else System.out.println("불합격입니다");  
          
        //삼항 연산자
          System.out.println(score >= 60? "합격입니다" : "불합격입니다");        
          
    }
    
    public void method2() {
    	//본인의 이름을 입력했을 때 본인이면 "본인이다" 아니면 "본인이 아니다" 출력
    	System.out.print("이름을 입력해주세요 > ");
        String name = sc.nextLine();
        
        System.out.println("name : " + System.identityHashCode(name)); //189568618 저장주소 
        System.out.println("김은진 : " + System.identityHashCode("김은진")); //122883338 저장주소
        
        //문자열 비교는 equals 사용! 
        if(name.equals("김은진")) {
        	System.out.println("본인이다");
        }else {
        	System.out.println("본인이 아니다");
        }
    }
    
    /*
     * if- else if-else 문
     * 
     * if(조건식1) {조건식1이 참(true)일 때 실행
     * } else if (조건식2) {
     *   조건식1이 거짓(false)고 조건식2가 참(true)일 때 실행
     * } else {
     *   조건식1, 조건식2 모두 거짓(false)일 때 실행
     * }
     * 
     * else if는 수가 제한이 없다!
     * 
     * */
    
      public void method3() {
     /* 사용자에게 점수(0~100)를 입력받아서 점수별로 등급 출력 
    	A등급 90점 이상
    	B등급 90점 미만 80점 이상
    	C등급 80점 미만 70점 이상
    	D등급 70점 미만 60점 이상
    	F등급 60점 미만
    	*/  
    	 
    	System.out.println("점수를 입력해주세요");
    	int score = sc.nextInt();
    	char grade = '\u0000';
    	
    	if(score < 0 || score >100) {
    		System.out.println("잘못 입력하셨습니다");
    		return;
    	}
    	if (score>=90) grade = 'A'; 
    	else if (score>=80) grade = 'B'; 
    	else if (score>=70) grade = 'C'; 
    	else if (score>=60) grade = 'D'; 
    	else grade='F';
        System.out.println(grade + "등급");    	  	   	  
      }
      
      public void method4() {
      //세 정수를 입력 했을 때 짝수만 출력
      //num 1 입력 = 3
      //num 2 입력 = 4
      //num 3 입력 = 8 
      //4, 8 출력
    	  
      System.out.println("첫번째, 두번째, 세번째 정수를 입력해주세요");
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      int num3 = sc.nextInt();
      
      
      if (num1%2==0) System.out.println(num1);
      if (num2%2==0) System.out.println(num2);
      if (num3%2==0) System.out.println(num3);
        
      }

     
	public static void main(String[] args) {
      A_If a = new A_If();
    //a.method1();
    //a.method2();
    //a.method3();
      a.method4();
	}

}
