package com.kh.step6;

// 은행 계좌 처리, 재고 관리, 표 예매 시스템
public class MovieProcess {

	public static void main(String[] args) {
		
		MovieUser user = new MovieUser();
		
		Thread t1 = new Thread(user, "전영현");
		Thread t2 = new Thread(user, "조규상");
		Thread t3 = new Thread(user, "성예찬");
		
		t1.start();
		t2.start();
		t3.start();
	}

}