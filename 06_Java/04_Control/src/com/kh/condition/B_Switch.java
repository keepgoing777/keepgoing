package com.kh.condition;

import java.util.Scanner;

public class B_Switch {
/*
 * Switch문
 * 
 * Switch(조건식) {
 *  case 값1 : 조건식의 결과가 값 1과 같은 경우 실행
 *  break;
 *  case 값2 : 조건식의 결과가 값 2와 같은 경우 실행
 *  break;
 *  default: 조건식의 결과가 일치하는 case문이 없을 때 실행
 * }
 *  - case문의 수는 제한이 없다
 *  - 조건식 결과는 정수, 문자, 문자열이어야 한다. 
 *  - 조건문을 빠져나가려면 break가 필요하다.
 *  - default 문은 생략 가능하다.
 * */	
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
       B_Switch b = new B_Switch();
     //b.method1();	
       b.method2();
	} 
	
	public void method1() {
   /*숫자를 입력받아 
	* 1일 경우 "빨간색입니다"
	* 2일 경우 "파란색입니다"
	* 3일 경우 "초록색입니다"
	* 잘못입력했을 경우 "잘못 입력했습니다 
   */
      System.out.print("숫자를 입력 > ");
      int num = sc.nextInt();
      switch(num){
          case 1: 
                System.out.println("빨간색입니다");
                break;
        
	      case 2: 
                 System.out.println("파란색입니다");
                 break; 
         
          case 3: 
                 System.out.println("초록색입니다");
                 break;
          default: System.out.println("잘못 입력하셨습니다");
         
      }
          
               
	}    
      public void method2() {
    /* 주민번호를 입력받아 남자인지 여자인지 출력 그 외에는 "사람이 아닙니다"
       주민번호 입력 : 000000-0000000
     */
    	System.out.print("주민등록번호 입력 > ");
  	     String no = sc.nextLine();
  	     
  	     System.out.println(no.charAt(7)); // 확인용
  	     char noChar = no.charAt(7);
  	     String noStr = no.substring(7,8); 
  	     
  	      System.out.println(noChar); //확인용
  	      System.out.println(noStr); //확인용
  	      
    	switch(Integer.parseInt(noStr)) {
    	case 1, 3 : 
    		System.out.println("남자"); break;
    	case 2, 4 : 
    		System.out.println("여자"); break;

        default : System.out.println("사람이 아닙니다");
        }
    	//noStr 변수를 사용할 경우 case "1", "2" 쌍따옴표들어감 String 타입
	    //noChar 변수를 사용할 경우 case '1', '2' char 타입 
        //Integer.parseInt : String 타입 숫자를 Int 타입으로 변환
	    }
    
    
}
