package com.kh.practice2;

/*
 * VIEW : HTML CSS JavaScript
 * 첫 프로젝트 : JST
 * 두번째 프로젝트 : REACT 
 * POJO(Plan Old Java Object) 
*/
import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;

public class Application {

	public static void main(String[] args) {
	//Snack view = new SnackView();
	//view.input();
	//view.result();
		Scanner sc = new Scanner(System.in);
		Snack snackData = new Snack(); // 자바스크립트에서도 객체로 값을 한꺼번에 담아서 보내요
	 
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
		
		SnackController controller = new SnackController();
	      
		System.out.println(controller.saveData(snackData));
		System.out.println(controller.confirmDate());

		// public void result(){	
		// System.out.println(controller.saveData(kind, name, flavor, numOf, price));
		// System.out.println(controller.confirmDate());
	    // }
		
	}

}
