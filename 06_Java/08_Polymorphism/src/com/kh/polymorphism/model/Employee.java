package com.kh.polymorphism.model;

//부모 클래스, 공통
public class Employee {
	
    private String name;
    private int salary;
    
    
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", getName()=" + getName() + ", getSalary()="
				+ getSalary() + "]";
	}
	
	
    
    

}
