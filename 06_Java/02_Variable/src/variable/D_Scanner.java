package variable;

import java.util.Scanner;

public class D_Scanner {
    /*
    * Scanner 
    *  - 화면(콘솔)에서 데이터를 "입력"받는 클래스
    *  1. import java.util.Scanner; 추가 (오류 떴을 때 1번째꺼 누르면됨)
    *  2. Scanner 객체 생성
    *     Scanner sc = new Scanner(System.in);
    *  3. Scanner 메서드 사용
    *   - 입력값이 문자열일 때 : sc.next() 공백 있을 경우 공백 이전까지 sc.nextLine() 공백 포함 엔터 전까지
    *   - 입력값이 정수일 때 : sc.nextInt()
    *   - 입력값이 실수일 때 : sc.nextFloat(), sc.nextDouble()
    *  sc.nextLine()만 사용하는것을 권장 (enter 처리)  
    */
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 이름은 무엇입니까? > ");
	    String name = sc.next();
	    sc.nextLine();
	    System.out.print("당신의 나이는 몇살입니까? > ");
	    int age = sc.nextInt();
	    sc.nextLine(); //enter처리 일부러 하는 행위
	    // 다른방법 int age = Integer.parseInt(sc.nextLine()); string을 int로 전환
	    System.out.print("당신의 집은 어디십니까? > ");
	    String addr = sc.nextLine(); 
	    System.out.print("당신의 키는 몇입니까? (소수점 첫째자리까) > ");
	    float height = sc.nextFloat();
	    sc.nextLine();
	    // 다른 방법 double height = Double.parseDouble(sc.nextLine()); 
	    // float 대신 double 사용 시 sc.nextLine(); enter처리 추가 필요
	    System.out.print("당신의 성별은 무엇입니까? (남/여) > ");
	    String gender = sc.nextLine();
	    // 다른 답변 char gender = sc.nextLine().charAt(0);
	    // 다른 답변 String input = sc.nextLine(); char gender = input.charAt(0);
	    System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age
	    		+ "살이고, 사는 곳은" + addr + "이고, 키는" + height + "cm이고, 성별은 "
	    		 + gender+ "자야");
	    

	    System.out.printf("이름은 %s이고, 나이는 %d살이고, 사는 곳은 %s이고, 키는 %.1fcm이고, 성별은 %s자야", 
		          name, age, addr, height, gender);
	    	    
	}

}


