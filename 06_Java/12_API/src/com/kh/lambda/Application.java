package com.kh.lambda;
/*
 * 람다식(Lambda Expression) => 자바스크림트의 화살표 함수!
 *  - 자바에서 함수적 프로그래밍을 위해서 자바 8부터 람다식 지원
 *  - 람다식은 매개변수를 가지는 함수와 같은 코드 블록이지만 런타임 시 인터페이스 익명 구현 객체 생성
 *  - 람다식을 사용하면 코드가 간결해지고, 컬렉션 요소들을 필터링하거나 매핑해서 원하는 결과를 쉽게 가져올 수 있음
 * 
 * */
public class Application {

	public static void main(String[] args) {
      int a = 10;
      int b = 2;	
      
      Application app = new Application();
      System.out.println(app.plus(a, b));
      System.out.println(app.minus(a, b));
      System.out.println(app.multiple(a, b));
      System.out.println(app.divide(a, b));

      //람다식으로 바꿔보기!
      MathInterface plusLambda = (int x, int y) -> {
    	return x + y;
      };
      
      MathInterface minusLambda = (int x, int y) -> x - y; //한줄 { }생략 가능
      MathInterface multipleLambda = (int x, int y) -> x * y;
      MathInterface divideLambda = (int x, int y) -> x / y;

      System.out.println(plusLambda.calc(a,b));
      System.out.println(minusLambda.calc(a,b));
      System.out.println(multipleLambda.calc(a,b));
      System.out.println(divideLambda.calc(a,b));

      
	}

	public int plus (int a, int b) {
		return a + b;
	}
	
	public int minus (int a, int b) {
		return a - b;
	}
	
	public int multiple (int a, int b) {
		return a * b;
	}
	
	public int divide (int a, int b) {
		return a / b;
	}
	
}
