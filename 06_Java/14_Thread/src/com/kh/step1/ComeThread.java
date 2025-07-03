package com.kh.step1;

public class ComeThread extends Thread {

	public ComeThread(String name) {
		super(name);
	}
	
	// 스레드가 작동하는 부분
	public void run() {
		
		for(int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();
			System.out.println("CurrentThread : " + name + ", " + i);
		}
		
		
	}
}