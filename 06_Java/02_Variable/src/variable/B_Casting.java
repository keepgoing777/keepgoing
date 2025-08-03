package variable;

public class B_Casting {

	public static void main(String[] args) {
      B_Casting casting = new B_Casting();
      casting.autoCasting();
      casting.casting();
	}
    
	/*
	 * 자동 형 변환(묵시적 형 변환)
	 *  - 자동으로 형 변환이 이루어지기 때문에 따로 형 변환 하지 않아도 된다.
	 * */
	
	public void autoCasting() {
		//정수
		byte b = 10; //1byte
		short s = b; //2byte
		int i = s; //4byte
		long l = i; //8byte
		
		//실수
		float f = 1; //4byte
		double d = f; //8byte
		
		d = i; //int(정수)값이 -> double(실수)값에 담아짐
		f = l; //long(8, 정수) -> float(4, 실수)에 담아짐 
		// 표현 가능한 수의 범위가 더 크기때문에 실수에 정수가 담아짐 
		
		int result = b + s ; //byte, short 타입의 데이터는 연산시 무조건 int
		System.out.println(result);
		
		double result2 = 10 + 3.3;
		System.out.println(result2);
   
		
}	
	/*
	 * 강제 형 변환(명시적 형 변환)
	 *  - 범위가 큰 크기의 자료형의 데이터를 작은 크기의 자료형으로 변환하려고 할 때
	 *  - 강제 형 변환의 경우 데이터 손실이 발생할 수 있다.
	 * (자료형)값;
	 *  
	 * */
	public void casting() {
		double d = 4.12345678901234567890;
		System.out.println(d); //15자리까지 표현가능
		
		float f = (float) d; // 6자리까지 표현가능
	    System.out.println(f);
	    
	    int i = (int)f;
	    System.out.println(i);
	    
	    int number = 129;
        byte bNumber = (byte) number;
	    System.out.println(bNumber);
	    // char <-> int : 각 문자들마다 고유한 숫자가 지정되어 있기 때문에 (아스키코드, 유니코드)
	    // 쌍방향으로 형 변환 가능	    
	    // char : 음수값 저장 불가, 값의 범위는 0~65535, 2byte

	    int num = 'A';
	    System.out.println(num);
	}

	
}
