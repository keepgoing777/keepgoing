package com.kh.step2;

import com.kh.step2.model.Card;

public class Application {

	public static void main(String[] args) {
		
		//클래스 변수는 객체 생성 없이 호출 가능!
		System.out.println(Card.height);
		System.out.println(Card.width);
	  //System.out.println(Card.number); // 에러
		
		//객체 생성 시 
		Card card1 = new Card();
		card1.kind = "Heart";
		card1.number = 7;
		System.out.println(card1.kind);
		System.out.println(card1.number);
		
		Card card2 = new Card();
		card2.kind = "Spade";
		card2.number = 2; 
		
		// 클래스 변수는 모든 객체가 하나의 저장공간을 공유하므로 항상 공통된 값을 갖는다.
	    Card.height = 50; // 이게 더 명확하고 클래스 이름으로 직접 접근하는게 확실!
	    card2.width = 20; // 30에서 20으로 card2만 바꿨을 때도 card1.width까지 20으로 바뀜
	                      //인스턴스 변수를 바꾸는것처럼 보이지만, 실제는 클래스 변수 값을 바꿈 
	    
	    System.out.println("첫번째 카드는 " + card1.kind + " " + card1.number + "이며, 크기는 " + card1.width + " X " + card1.height + "입니다");
	    System.out.println("두번째 카드는 " + card2.kind + " " + card2.number + "이며, 크기는 " + card2.width + " X " + card2.height + "입니다");
	

	}

}
