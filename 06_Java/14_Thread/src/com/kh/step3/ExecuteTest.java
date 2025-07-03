package com.kh.step3;

import java.awt.Toolkit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * ExecutorService - 스레드를 관리하는 도구
 * */
public class ExecuteTest {

	public static void main(String[] args) {

		// 1. ExecutorService 생성 - 스레드 풀을 만든다! 
		ExecutorService execute = Executors.newFixedThreadPool(2);
		
		// 2. 작업 제출
		execute.submit(() -> {
			// 첫번째 작업 - 경고음 5번 울리기 -> BeepThread
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		execute.submit(() -> {
			// 두번째 작업 - 띵~ 5번 출력 -> TextThread
			for (int i = 0; i < 5; i++) {
				System.out.println("띵~");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		// 3. ExecutorService 종료 요청
		execute.shutdown();
		
	}

}