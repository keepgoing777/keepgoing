package com.kh.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class A_String {
/*
 * String 클래스
 *  - 불변의 클래스 (객체 생성하면 변경 X) 
 *  - 변경이 적고 읽기가 많은 경우에 사용하는 것이 좋다.
 *  - new 없이도 객체를 생성할 수 있는 유일한 객체 
 * */
	public void method1() {
	  String str1 = "hello";
	  String str2 = "hello"; 
	  String str3 = new String("hello"); //객체 생성 시 주소 생성 됨
	  String str4 = new String("hello"); //객체 생성 시 주소 생성 됨 
	  
	  System.out.println("str1 == str2 : " + (str1 == str2)); //true
	  System.out.println("str3 == str4 : " + (str3 == str4)); //false
	  System.out.println("str1 == str3 : " + (str1 == str3)); //false
	  
	  System.out.println("str1.equals(str2) : " + (str1.equals(str2))); //true
	  System.out.println("str3.equals(str4) : " + (str3.equals(str4))); //true
	  System.out.println("str1.equals(str3) : " + (str1.equals(str3))); //true
	}	
	
	// String 클래스에서 제공하는 메서드
	public void method2() {
		String str = "Hello, Java!";
	  //1. charAt(int index) : char
	  //   전달받은 index 위치의 하나의 문자만 추출해서 리턴
	   char ch = str.charAt(3);
	   System.out.println("1. charAt : " + ch);
	   
	  //2. concat(String str) : String
	  //   전달받은 문자열과 원본 문자열을 하나로 합친 새로운 문자열 생성해서 리턴
	   String str2 = str.concat("!!!!!");
	   System.out.println("2. concat : " + str2);
	   
	  //3. substring(int beginIndex, int endIndex) : String
	  //   문자열의 beginIndex부터 endIndex -1 (endIndex 생략하면 끝까지)
	  //   의 문자열을 새로 생성해서 리턴
	    String str3 = str.substring(7);
	    String str4 = str.substring(0,5);
	    System.out.println("3. substring : " + str3);
	    System.out.println("3. substring (시작, 끝 지정) : " + str4);
	  
	  //4. indefOf(String str) int 
	  //   전달받은 str의 시작 인덱스를 리턴(포함되어 있지 않으면 -1)
	    int index = str.indexOf("!");
	    System.out.println("4. indexOf : " + index);
	    int index2 = str.indexOf("Java");
	    System.out.println("4. indexOf(문자열) : " + index2);
	    int index3 = str.indexOf("?");
	    System.out.println("4. indexOf(없는 문자) : " + index3);
	    
	  //5. replace(char oldChar, char newChar) : String 
	  //   문자열에서 old 문자를 new 문자로 변경된 새로운 문자열을 생성해서 리턴
	    String str5 = str.replace('l', 'c');
	    System.out.println("5. replace : " + str5);
	    
	  //6. toUpperCase() / toLowerCase() : String
	  //   문자열을 모두 대/소문자로 변경한 새로운 문자열을 생성해서 리턴
	    String str6 = str.toUpperCase();
	    String str7 = str.toLowerCase();
	    System.out.println("6. toUpperCase : " + str6);
	    System.out.println("6. toLowerCase : " + str7);

	  //7. trim() : String
	  //   문자열을 앞뒤(가운데는 공백제거 안됨) 공백을 제거한 새로운 문자열을 생성해서 리턴 
	    String str8 = "                Hello,       Java!      ";
        System.out.println("7. trim 전 : " + str8);
        
        String str9 = str8.trim();
        System.out.println("7. trim 후 : " + str9);
	   
      //8. toCharArray() : char[]
      //   문자열의 문자들을 문자 배열에 담아서 해당 배열의 주소값 리턴
        char[] arr = str.toCharArray();
	    System.out.println("8. toCharArr : " + arr); // 주소값 리턴
	    System.out.println(Arrays.toString(arr));
	 
	  //배열을 리스트(ArraList)로 변환 
	   List<Character> arrList = new ArrayList<>();
	   for(char word : arr) {
		  arrList.add(word);
	   }
	   System.out.println("8. arrList : " + arrList);
	
	  //9. static valueOf(문자 배열) : String
	  //   문자열로 변경해서 리턴
	   String str10 = String.valueOf(arr);
	   System.out.println("9. valueOf : " + str10);
	   
	   System.out.println(str);
	}
/*
 *StringBuiler & StringBuffer 
 * - 가변 클래스 : String 클래스와 달리 내부 문자열을 수정할 수 있다.
 * - 16개의 문자를 저장할 수 있는 버퍼가 미리 생성되고 문자가 저장됨에 따라 자동 증가 
 * - StringBuilder : 동기화 X -> 단일 스레드 환경 권장
 * - StringBuffer : 동기화 O -> 멀티 스레드 환경 권장 
 * */
	
	public void method3() {
		StringBuilder sb = new StringBuilder("Hello, ");
		System.out.println(sb);
	//1. append(String Str) : StringBuilder 
    //   기존 문자열 뒤에 문자열 추가 (concat 같은 역할)
		sb.append("Java");
		System.out.println(sb);
		
	//2. insert(int offset, String str) : StringBuilder
    //   문자열의 offset 위치부터 전달받은 문자열 추가 
		sb.insert(1, "eeeee");
		System.out.println(sb);
		
    //3. delete(int str, int end) : StringBuilder
    //   start에서 end -1 까지 인덱스에 해당하는 문자열 삭제 
	   sb.delete(1, 6);
	   System.out.println(sb);
	   
	//4.reverse() : StringBuilder
	//  문자열의 순서를 역으로 바꿈
	   sb.reverse();
	   System.out.println(sb);
		
	//메서드 체이닝 : 메서드 이어서 쓸 수 있다!    
    StringBuilder sb2 = new StringBuilder("Java Program");
    //IPA avaJ
    
    sb2.delete(5,12);
    sb2.append("API");
    sb2.reverse();
	System.out.println(sb2);
   }
/*
 * StringTokenizer 
 *  - java.util 패키지에서 제공하는 클래스
 *  - 객체 생성 시 생성자로 전달받은 문자열을 구분자로 이용하여 분리
 *  - 분리된 최소 단위를 토큰이라 부른다
 * */
	
	public void method4() {
	  String str = "Java,JDBC,Servlet,JSP,MyBatis,Spring";
	
	  //1. String 클래스의 split 메서드
	  //   split(String regex) : String[]
	  //   입력받은 구분자로 문자열을 분리해서 문자열의 배열로 담아서 리턴
	      String[] strArr = str.split(",");
	      for(String s : strArr) {
	    	  System.out.println("1.str.split : " + s);
	      }
	  //2. StringTokenizer 객체 이용(iterator이랑 유사)
	      StringTokenizer st = new StringTokenizer(str, ",");
	      
	      //hasMoreTokens : 남아 있는 토큰이 있는지 
	      System.out.println("토큰이 남아있나? : " + st.hasMoreTokens());
	      //nextToken : 토큰을 하나씩 꺼내옴 
	      System.out.println("바로 다음 토큰은? : " + st.nextToken());
	      System.out.println("과목 개수 : " + strArr.length);
	      while(st.hasMoreTokens()) {
	    	  System.out.println("2.nextToken반복문 : "+st.nextToken());
	      }
	}
	public static void main(String[] args) {
      A_String a = new A_String();
      // a.method1();
      //a.method2();
      //a.method3();
      a.method4();
      //a.method5();
	}

}//종료
