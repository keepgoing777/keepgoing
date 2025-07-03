package com.kh.step1;

public class GoThread extends Thread {

	public GoThread(String name) {
		super(name);
	}

	public void run() {

		for (int i = 0; i < 100; i++) {
			try {
				// 지정된 시간동안 스레드를 멈추는 역할
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();
			System.out.println("CurrentThread : " + name + ", " + i);
		}

	}
}