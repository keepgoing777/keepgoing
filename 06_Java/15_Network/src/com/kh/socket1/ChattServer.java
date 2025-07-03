package com.kh.socket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattServer {

	// 클라이언트가 보낸 메세지를 받아서 콘솔창에 받은 메세지 출력
	public static void main(String[] args) {

		try {
			// 1. ServerSocket 생성
			ServerSocket server = new ServerSocket(60000);
			System.out.println("서버 준비..");
			
			// 2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket 하나 리턴
			Socket socket = server.accept();
			System.out.println("클라이언트 접속..");
			
			// 3. 소켓으로부터 스트림 리턴
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println("클라이언트가 보낸 메세지 : " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}