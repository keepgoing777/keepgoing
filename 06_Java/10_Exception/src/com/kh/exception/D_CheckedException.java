package com.kh.exception;
/*
 * CheckedException
 *  - Exception 상속하고 있는 예외들 CheckedException 
 *  - 컴파일 시 예외처리 코드가 있는지 검사하는 예외
 *  - 예외처리 (try~catch, throws) 가 되어있지 않으면 컴파일 에러 발생
 *  - 소스코드 수정으로도 해결안됨
 *  - 주로 외부에 매개체와 입출력이 일어날 때 발생
 * */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class D_CheckedException {

	public static void main(String[] args) {
        try { // I/O에서 공부할 내용(파일 입출력)
			FileInputStream fis = new FileInputStream("a.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
