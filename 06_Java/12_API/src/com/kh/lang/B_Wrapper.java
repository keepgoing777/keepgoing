package com.kh.lang;

public class B_Wrapper {

	public static void main(String[] args) {
      //int -> Integer 
	  int iNum1 = 3;
	  //Deprecated : 기능은 있지만 비권장 
	  Integer int1 = new Integer(iNum1); //Boxing 했다! : 기본 자료형 -> Wrapper 클래스로 변경했다! 
	  int1 = 3;                          //UnBoxing 했다! : Wrapper 클래스 -> 기본 자료형으로 변경했다!
	
	  //double -> Double
	  double dNum2 = 3.14;
	  Double double2 = new Double(dNum2);
	  
	  //char -> Character
	  char ch3 = 'a';
	  Character ch4 = new Character(ch3);
	  
	  //String과 Wrapper 클래스 간의 변경
	  //1. 문자열을 기본 자료형으로 변경 : parseXXX()
	  int iNum = Integer.parseInt("20");
	  double dNum = Double.parseDouble("34.96");
	  
	  //2. 기본 자료형을 문자열로 변경 - String 의 valueOf
	  String str1 = String.valueOf(iNum);
	  String str2 = String.valueOf(dNum);
	  System.out.println(iNum + dNum); //54.96
	  System.out.println(str1 + str2); //2034.96
	  
	  //Wrapper 클래스에서 제공하는 valueOf().toString()
	  String str3 = Integer.valueOf(iNum).toString();
	  String str4 = Double.valueOf(dNum).toString();
       System.out.println(str3 + str4 ); //2034.96
	}

}
