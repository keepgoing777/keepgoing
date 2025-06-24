package com.kh._abstract.step1;

public class Football extends Sports {

	public Football(int numOfPlayer) {
		super(numOfPlayer);
	}

	@Override
	public void rule() {System.out.println("Football의 선수 수는" + this.numOfPlayer + "명, 손이 아닌 발로 공을 차야 한다");
	}
	
	

}
