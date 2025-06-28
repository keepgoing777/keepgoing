package com.kh.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class E_SubClass extends E_SuperClass {

	 
	 //오버라이딩 시 throws 작성 안해도 됨
	 //@Override
	 //public void method() {}
		
	 //부모 클래스의 메서드와 같은 Exception throws 가능
	 //public void method() throws IOException{}
		 
	 //부모 클래스의 메서드와 다른 Exception throws 불가능
   	 //public void method() throws ClassNotFoundException{} 
	
	 //부모 클래스의 메서드보다 더 상위 타입의 Exception throws 불가능
	 //public void method() throws Exception{}
	
	//부모 클래스의 메서드보다 더 하위 타입의 Exception throws 가능 
	//IOException > FileNotFoundException 
 	public void method() throws FileNotFoundException{} 
	 
}
