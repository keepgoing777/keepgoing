package com.kh.step2;

/*
 * 스레드 생성하는 방법 2
 * 
 * 1. Runnable 인터페이스 구현
 * 2. run() 메서드 오버라이딩
 * 3. Thread 객체 생성 시 생성자의 Runnable 인터페이스를 구현한 객체를
 *    파라미터값으로 전달 후 start() 메서드 호출
 * */
public class ComeThread implements Runnable {

	@Override
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