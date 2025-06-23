package com.kh.practice2.model;

import java.util.Scanner;

/*public class SnackView{
Scanner sc = new Scanner(System.in);
String kind;
String name;
String flavor
int numOf;
int price;} 

public void input() {
Scanner sc = new Scanner(System.in);
System.out.println("스낵류를 입력하세요.");
System.out.print("종류 : ");
		kind = sc.nextLine();

String kind = sc.nextLine();
System.out.print("이름 : ");
		name = sc.nextLine();

String name = sc.nextLine();
System.out.print("맛 : ");
		flavor = sc.nextLine();

String flavor = sc.nextLine();
System.out.print("개수 : ");
		numOf = Integer.parseInt(sc.nextLine());

int numOf = Integer.parseInt(sc.nextLine());
System.out.print("가격 : ");
		price = Integer.parseInt(sc.nextLine());

	public void result() {
		SnackController controller = new SnackController();
		System.out.println(controller.saveData(kind, name, flavor, numOf, price));
		System.out.println(controller.confirmData());
*/


public class Snack {
	
	private String kind;
	private String name;
	private String flavor;
	private int numOf;
	private int price;
	
	//기본 생성자
    public Snack(){}
	
    //매개변수 있는 생성자
	public Snack (String kind, String name, String flavor, int numOf, int price){}

	

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOf() {
		return numOf;
	}

	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Snack [kind=" + kind + ", name=" + name + ", flavor=" + flavor + ", numOf=" + numOf + ", price=" + price
				+ "]";
	};
	
	
	
	
	
}

