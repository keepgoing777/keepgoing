package com.kh.step3;

public class TextThread implements Runnable {

	@Override
	public void run() {

		// 두번째 작업 - 띵~ 5번 출력 -> TextThread
		for (int i = 0; i < 5; i++) {
			System.out.println("띵~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}