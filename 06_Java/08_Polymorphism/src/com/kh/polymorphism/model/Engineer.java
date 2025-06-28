package com.kh.polymorphism.model;

public class Engineer extends Employee {
// 부모 : Employee 상속받음
	private String tech;
	private int bonus;
	
	public Engineer(String name, int salary, String tech, int bonus) {
		super(name, salary);
		this.tech = tech;
		this.bonus = bonus;
	}

	public Engineer() {
		super();
	}


	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Engineer [tech=" + tech + ", bonus=" + bonus + ", getBonus()=" + getBonus() + ", getName()=" + getName()
				+ ", getSalary()=" + getSalary() + "]";
	}

}

