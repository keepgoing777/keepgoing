package com.kh.map.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class A_HashMap {

	public void method1() {
		HashMap<String, Integer> map = new HashMap();
		map.put("웨하스", 250);
		map.put("고래밥", 100);
		map.put("웨하스", 300); // key 중복시 덮어씀 (나중 입력값이 들어감)
		map.put("칸쵸", 100); // value 값 중복은 상관없음
		System.out.println(map);

		// keySet : 키만 가져오기
		Set<String> key = map.keySet();
		System.out.println(key);

		// values : 값만 가져오기
		Collection<Integer> values = map.values();
		System.out.println(values);

		// get : 특정 값만 가져오기 (set과 다르게 key값이 있기 때문에 가능)
		System.out.println(map.get("웨하스"));

		// entryset : map 컬렉션에 있는 entry객체를 set 컬렉션에 담아서 반환
		Set<Entry<String, Integer>> entry = map.entrySet();
		for (Entry<String, Integer> e : entry) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}

		for (String k : key) {
			System.out.println(k + " - " + map.get(k));
		}

	}

	public void method2() {
		Map<String, Snack> map = new HashMap<>();

		map.put("웨하스", new Snack("딸기", 255));
		map.put("웨하스", new Snack("치즈", 240));
		map.put("고래밥", new Snack("양념치킨", 175));
		map.put("자유시간", new Snack("아몬드", 212));
		map.put("칸쵸", new Snack("딸기 요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("후렌치파이", new Snack("딸기", 900));
		map.put("나쵸", new Snack("치즈", 486));

		// 과자의 개수는 몇개인가요?
		System.out.println("과자 개수 : " + map.size() + "개");
		// 웨하스의 맛과 칼로리는?
		Snack snack = map.get("웨하스");
		System.out.println("웨하스맛 : " + snack.getFlavor() + ", 칼로리 : " + snack.getCalorie());
		// 모든 과자의 칼로리 총합과 평균은?
		int sum = 0;
		int count = 0;
		System.out.println(map.values());
		for (Snack value : map.values()) {
			if (value.getFlavor().contains("딸기")) {
				sum += value.getCalorie();
				count++;
			}

		}
		System.out.println("딸기 과자들의 칼로리 합 : " + sum);
		System.out.println("딸기 과자들의 평균 : " + sum / count);
	}
	// 딸기 맛(딸기 요거트 포함)인 과자의 칼로리 총합과 평균은?

	public static void main(String[] args) {
		A_HashMap a = new A_HashMap();
		// a.method1();
		a.method2();
	}

}
