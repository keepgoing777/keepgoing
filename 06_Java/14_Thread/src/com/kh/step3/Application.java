package com.kh.step3;

import java.awt.Toolkit;

public class Application {

	public static void main(String[] args) {

		Thread beep = new Thread(new BeepThread());
		Thread text = new Thread(new TextThread());
		
		beep.start();
		text.start();
		
		
	}

}