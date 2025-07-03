package com.kh.step2;

import com.kh.step2.ComeThread;
import com.kh.step2.GoThread;

public class Application {

	public static void main(String[] args) {
		
		// 1. Thread 생성
		ComeThread come = new ComeThread();
		GoThread go = new GoThread();
		
		Thread t1 = new Thread(come, "ComeThread");
		Thread t2 = new Thread(go, "GoThread");
		
		// 2. start 호출
		t1.start();
		t2.start();
		
	}
}