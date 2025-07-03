package com.kh.step4;

import javax.swing.JOptionPane;

public class InputThread extends Thread {
	
	Application process;
	public InputThread(Application process) {
		this.process = process;
	}

	public void run() {
		// 데이터 입력
		String input = JOptionPane.showInputDialog("카운트가 종료되기 전 숫자를 입력해주세요");
		System.out.println("입력하신 숫자는 " + input + "입니다.");
		process.check = true; // 입력했으니까
	}
}