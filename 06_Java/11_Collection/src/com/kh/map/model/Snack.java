package com.kh.map.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Data
/*
 * Map
 *  - key - value 쌍으로 저장
 *  - 순서 없음
 *  - 중복 : 키(key) X , 값(value) O
 *  
 * HashMap
 *  - Map 인터페이스를 구현한 대표적인 컬렉션 클래스
 * 
 * */
public class Snack {
	private String flavor;
	private int calorie;

}
