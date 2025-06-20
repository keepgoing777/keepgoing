package com.kh.practice1.model;

public class UserInfo {

  public int userNo;
  public String id;
  public String password;
  public String email;
  public String name;
  public String phone;
  public String addr;
 
 
  public UserInfo() {}
  public String printName() { 
	  return this.name;
  }
  public void changeName(String name) {
	  this.name = name;
  }

}
	
	
	

