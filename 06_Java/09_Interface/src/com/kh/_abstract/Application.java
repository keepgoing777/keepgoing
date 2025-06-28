package com.kh._abstract;

import com.kh._abstract.step1.BasketBall;
import com.kh._abstract.step1.Football;
import com.kh._abstract.step1.Sports;
import com.kh._abstract.step2.BulgogiPizza;
import com.kh._abstract.step2.PineapplePizza;
import com.kh._abstract.step2.Pizza;
import com.kh._abstract.step2.PotatoPizza;

public class Application {
/*
 * 추상 클래스(Abstract Class)
 *  - 미완성 클래스로 추상 매서드를 포함한 클래스
 *  - 미완성 클래스이기때문에 new 연산자를 통해서 객체 생성 X
 *  - 일반적인 필드, 메서드 포함(변수+메서드+추상메서드)
 *  - 객체 생성할 수 없지만 참조형 변수 타입으로 사용 가능
 *  - 상속 관계로 다형성 적용 가능
 *  
 *  추상매서드(Abstract Method)
 *   - 미완성 메서드로 중괄호({})가 구현되지 않는 메서드
 *   - 추상 클래스를 상속받는 자식 클래스에서 "반드시" 오버라이딩(재정의)
 *   - 오버라이딩(재정의)해주지 않으면 컴파일 에러
 *   - 자식 클래스에 강제성 부여
 * */
	public static void main(String[] args) {
      //Sport s = new Sport(5); 
	  //추상클래스에서 객체 생성 X 3
		
       //Sports b = new BasketBall(9);
	   //Sports f = new Football(11);
		
		//b.rule();
	   //f.rule();	
       //다형성으로 인해 부모 타입으로 가능!
		
		BulgogiPizza Bul = new BulgogiPizza(10000, "피자헛");
		PotatoPizza Pot = new PotatoPizza(15000, "도미노");
		PineapplePizza Pine = new PineapplePizza(18000, "파파존스");
		
		Pizza [] pizza = {Bul, Pot, Pine};
			
		 for(Pizza p : pizza) {
			 System.out.println();
			 p.rule();
		     p.info();
		  }
		 
		 
/*브랜드, 가격 자유롭게, 세가지 피자 다 사용
해당 브랜드의 파인애플 피자 가격은 ~원입니다 
피자 반죽과 함께 도우를 빚는다. 
토핑은 파인애플를 포함한다 
피자를 180도에서 10분간 구운다.
피자를 8등분 한다.
피자를 포장한다. 

*/

   }
}
	
