package com.kh.step3;

import java.awt.Toolkit;

public class BeepThread implements Runnable {

	@Override
	public void run() {

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

	}

}