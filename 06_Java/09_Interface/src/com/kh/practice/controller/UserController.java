package com.kh.practice.controller;

import com.kh.practice.model.Department;
import com.kh.practice.model.DeptType;
import com.kh.practice.model.UserInfo;

import java.time.LocalDate;

public class UserController {
	
	private UserInfo u = new UserInfo();
	
	private int count = 0;
	private int deptCode = 0;
	private UserInfo[] userList = {new UserInfo(), new UserInfo(), new UserInfo()};
	
// 로그인 -> 유저 정보 클라이언트(화면)! 
//UserInfo getUser() + addUser() 이 합쳐짐 
	public UserInfo login(String id, String password) {
		for(UserInfo u : userList) {
			if(id.equals(u.getId()) && password.equals(u.getPassword())) {
				return u;
			}
		}
		return null;
	}
	
	
	//오버로딩! 기본정보
	public void addUser(int userNo, String id, String password, String email, String name) {
	    userList[count].setUserNo(userNo);
		userList[count].setId(id);
		userList[count].setPassword(password);
		userList[count].setEmail(email);
		userList[count].setName(name);
		count++;
	   }
    //추가 정보
	public void addUser(String phone, String addr, String gender, LocalDate birthDate, int deptNo) {
		userList[count].setPhone(phone);
		userList[count].setAddr(addr);
		userList[count].setGender(gender);
		userList[count].setBirthDate(birthDate);
		//기존에 있는 부서면 (해당유저들) 해당부서 정보 그대로 추가 
		userList[count].setDeptNo(deptNo); // depttype을 만들고 난 후 추가 (하단 주석처리)
	
		Department dept = new Department(deptNo, DeptType.findDeptName(deptNo));
		userList[count].setDepartment(dept);
		 

		/*for(UserInfo u : userList) {
			Department dept = u.getDepartment();
			if(dept!=null && dept.getDeptName().equals(department.getDeptName())) {
			 userList[count].setDepartment(dept);
			 return;
			}
		}*/
	    //기존에 없어서 추가된 것들
		/*department.setDeptNo(DeptType.findDeptNo(department.getDeptName()));
		userList[count].setDepartment(department);*/
	  }
	
	//수정하는 메서드 3개인 경우 (선언된 메서드명은 같지만 모두 다른 타입이라 사용가능)
/*	public void updateUser(String phone) {
		userList[count].setPhone(phone);
	   }	
    public void updateUser(LocalDate birthDate) {
    	userList[count].setBirthDate(birthDate);
	   }
    public void updateUser(Department department) {
    	userList[count].setDepartment(department);
	   }
	    
	 //로그인
	public boolean login(String id, String password) {
	  return id.equals(u.getId()) && password.equals(u.getPassword());	
	   }
*/
	//메서드 1개인 경우
	public void updateUser(UserInfo u) {
		for(UserInfo info : userList) {
			if(u.getUserNo() == info.getUserNo()) {
				info = u;
			}
		}
	}
	  
	    
}

