package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.Employee;
import com.kh.polymorphism.model.Engineer;

public class EmployeeController {
	
	  public Employee findEmployee(Employee[] emp) {
		   for(Employee employee : emp) {
			 if(employee.getName().equals("최다인")) {
				 return employee; 
			   }
	      	 }
		  return null; // public 뒤 생성자 타입과 리턴값 타입을 맞춰야 함
		  		  
	  }
	  
	  
	  public int getAnnualSalary (Employee findEmployee) {
		   if(findEmployee == null) return -1;
		   
		   if(findEmployee instanceof Engineer) {
			   Engineer engineer = (Engineer)findEmployee;
			   return engineer.getSalary()*12 + engineer.getBonus(); 
		      } 
			   return findEmployee.getSalary()*12;
		     }
	    
	 
	  public int totalSalary(Employee[] emp) {
		   int sum = 0;
		   for (Employee employee : emp) {
			   sum += employee.getSalary();  
		    }   
		   return sum;
	  } 
	  
}



