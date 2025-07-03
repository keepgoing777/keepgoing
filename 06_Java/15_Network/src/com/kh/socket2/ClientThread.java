package com.kh.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientThread extends Thread {

	Socket socket;
	BufferedReader br;
	
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	
	public ClientThread(Socket socket) {
		this.socket = socket;
		
		try {
			// 클라이언트에서 서버로 - 스트림
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 서버에서 클라이언트로 - 스트림
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			list.add(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendAll(String message) {
		for(PrintWriter pw : list) {
			pw.println(message);
			pw.flush();
		}
	}
	
	public void run() {
		try {
			String login = socket.getInetAddress() + "님이 접속하셨습니다..";
			System.out.println(login);
			sendAll(login);

			while (br != null) {
				String line = "[" + socket.getInetAddress() + "] 가 보낸 메세지 : " + br.readLine();
				System.out.println(line); // 서버에 출력
				sendAll(line); // 클라이언트한테 보냄
			}
		} catch (IOException e) {
			System.out.println(socket.getInetAddress() + "님이 나가셨습니다..");
		}
		
	}
	
}