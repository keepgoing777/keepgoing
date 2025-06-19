package com.kh.step1.model;

public class Tv {

	/*
	 * 1. 추상화 
	 *  - 공통적인 특성만 뽑아내어 단순화
	 *  - 개발하는데 중요한 것만 뽑고 불필요한 정보는 숨긴다 
	 * 
	 * TV라는 객체의 설계도 클래스 공간이라고 보면됨
	 * 
	 * 속성(property) 
	 * - 멤버변수(member variable), 필드(field), 특성(attribute) */
	
	public boolean power; // 전원 상태(on/off)
	public int channel; // 채널

	// 기능(function)
	// - 메서드(method), 함수(function)
	public void power() {
		power = !power;
	}

	public void channelUp() {
		channel++;
	}

	public void channelDown() {
		channel--;
	}
}
