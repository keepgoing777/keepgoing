package com.kh.exception;

public class A_TryCatch {
/*
 * 컴파일 에러(compile-time error) : 컴파일 시에 발생하는 에러 (실행하기 전부터)
 * 런타임 에러(runtime error) : 실행 시에 발생하는 에러
 *  - 에러(error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류 (발생되더라도 수습될 수 있는 비교적 덜 심각함)
 *  - 예외(exception) : 프로그램 코드에 의해서 수습될 수 있는 약한 오류 
 *     에러는 메모리 부족(OutOfMemoryError)이나 스택오버플로우(StackOverFlowError)와
 *     같이 일단 발생하면 복구할 수 없는 심각한 오류 
 * 논리적 에러(logical error) : 실행은 되지만 의도와 다르게 동작
 * 
 * Object -> Throwable -> Exception
 *  --> IOException -> FileNotFoundException, SocketException
 *      RuntimeException -> ArithmeticException, IndexOutofBoundsException 
 *
 * how to catch? try ~ catch
 * 형태 : 
 * try {
 *    //예외가 발생 할 가능성이 있는 코드들 
 * } catch(예외클래스 예외변수명) {
 *    // try에서 예외가 발생하면 실행을 멈추고 catch로 들어와서 예외처리
 * } finally(부수적) {
 *    // 예외가 발생하거나 발생하지 않든 무조건 실행
 *    //close().. 주로 자원 반납
 * }
 * printStactTrace : 예외 발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력
 * (catch 문 안에 기재해서 확인 java.lang.Exception
	at com.kh.exception.A_TryCatch.main(A_TryCatch.java:34)
 * getMessage : 발생한 예외 클래스의 객체에 저장된 메시지 //null
 *
 * */
	public static void main(String[] args) {
		try {
          throw new Exception(); // 고의로 발생! 
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}


	
	
}
