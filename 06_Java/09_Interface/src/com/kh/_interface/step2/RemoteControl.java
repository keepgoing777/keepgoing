package com.kh._interface.step2;

public interface RemoteControl extends Volume, Searchable {
// 인터페이스끼리의 상속은 extends를 사용, 다중도 가능 
	void turnOn();
	void turnOff();
}
