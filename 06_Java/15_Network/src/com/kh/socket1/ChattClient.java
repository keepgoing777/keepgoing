package com.kh.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattClient {
	
	public static void main(String[] args) {

		try {
			InetAddress ip = InetAddress.getLocalHost();
			
			// 1. 소켓 생성 - 서버 IP 주소, 포트번호
			Socket socket = new Socket(ip.getHostAddress(), 60000);
			System.out.println("클라이언트 소켓 생성..");
			
			// 2. 스트림 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			String line = "";
			while((line = br.readLine())!=null) {
				pw.println(line);
			}
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}