package com.kh.practice.model;
/*
 * 실제 운영 환경 DB에서는 부서 정보 테이블로 관리 
 * 테이블에서 조회해서 사용하는 방식이 일반적!
 * 현재 테이블 연결 안되고 있고 자바에서 enum을 배우기 위해 활용
 *
 * enum : 클래스처럼 보이는 상수
 *  - 변수 지정 가능, 생성자 활용 가능, 메서드(static으로 선언)도 가능 
 * 
 * */
public enum DeptType {
	
	DEV(1, "개발팀"), 
	DESIGN(2, "디자인팀"),
	PLAN(3, "기획팀"),
	MARKETING(4, "마케팅팀"), 
	FINANCE(5, "재무팀");
	
	private final int deptNo;
	private final String deptName;
	
	DeptType(int deptNo, String deptName){
		this.deptNo = deptNo;
		this.deptName = deptName;
	}
	

	public static int findDeptNo(String deptName) {
		for(DeptType type : values()) {
			if(type.deptName.equals(deptName)) {
				return type.deptNo;
			}
		}
		return 0;
	}
	
     public static String findDeptName(int deptNo) {
    	 for(DeptType type : values()) {
    		 if(type.deptNo == deptNo) {
    			 return type.deptName;
    		 }
    	 }
    	 return null;
     }
	
	
}
