package com.kh.practice2.view;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;

public class SnackView {

	Scanner sc = new Scanner(System.in);
	Snack snackData = new Snack(); // 자바스크립트에서도 객체로 값을 한꺼번에 담아서 보내요

	public void input() {
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		snackData.setKind(sc.nextLine());

		System.out.print("이름 : ");
		snackData.setName(sc.nextLine());

		System.out.print("맛 : ");
		snackData.setFlavor(sc.nextLine());

		System.out.print("개수 : ");
		snackData.setNumOf(Integer.parseInt(sc.nextLine()));

		System.out.print("가격 : ");
		snackData.setPrice(Integer.parseInt(sc.nextLine()));
	}

	public void result() {
		SnackController controller = new SnackController();
		System.out.println(controller.saveData(snackData));
		System.out.println(controller.confirmDate());


	
	}
	
	
}
