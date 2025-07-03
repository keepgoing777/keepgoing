package com.kh.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 네트워크(Network)
 * - 여러 대의 컴퓨터를 통신 회선으로 연결한 것
 * 
 * 서버(Server)와 클라이언트(Client)
 * - 서비스를 제공하는 쪽이 서버, 제공받는 쪽이 클라이언트
 * - 클라이언트가 요청(Request)하는 내용을 서버에서 처리하고 응답(Response)을 클라이언트로 보낸다
 * 
 * IP 주소
 * - 네트워크 상에서 컴퓨터를 식별하는 번호
 * - xxx.xxx.xxx.xxx와 같은 형식으로 표현 (xxx는 부호 없이 0 ~ 255 사이의 정수)
 * - DNS(Domain Name System)을 통해 해당 도메인의 IP 주소를 알아낼 수 있다.
 *  
 * 포트(Port)
 * - IP 주소는 네트워크 상에서 컴퓨터를 찾을 때만 사용하고
 *   컴퓨터 내에서 실행하는 프로그램을 선택하기 위해 포트(Port) 사용
 * - 클라이언트는 서버 연결 요청 시 IP 주소와 포트 번호를 알고 있어야 한다
 * - 포트는 0~65535까지의 범위를 갖는다 
 * 
 *  
 * */

public class InetAddressTest {

	public static void main(String[] args) {
		// InetAddress : IP 주소를 다루기 위한 클래스
		try {
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("localhost의 호스트 이름 : " + ip.getHostName()); 
			System.out.println("localhost의 IP 주소 : " + ip.getHostAddress());
			
			ip = InetAddress.getByName("google.com");
			System.out.println("구글의 호스트 이름 : " + ip.getHostName()); 
			System.out.println("구글의 IP 주소 : " + ip.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}