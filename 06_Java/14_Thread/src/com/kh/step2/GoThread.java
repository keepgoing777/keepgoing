package com.kh.step2;


public class GoThread implements Runnable {

	@Override
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