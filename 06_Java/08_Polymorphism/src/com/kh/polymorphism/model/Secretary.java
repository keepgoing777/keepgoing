package com.kh.polymorphism.model;

public class Secretary extends Employee {

	private String boss;

	public Secretary(String name, int salary, String boss) {
		super(name, salary);
		this.boss = boss;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	@Override
	public String toString() {
		return "Secretary [boss=" + boss + ", getBoss()=" + getBoss() + ", getName()=" + getName() + ", getSalary()="
				+ getSalary() + "]";
	}


	
	
	
	
}
