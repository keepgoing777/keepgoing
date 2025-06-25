package com.kh.practice2.exception;

public class DuplicateIdException extends Exception {
 
	public DuplicateIdException() {
		this("중복된 사람이 있어서 에러 발생");
	}
	
	public DuplicateIdException(String message) {
		super(message);
	}
}
