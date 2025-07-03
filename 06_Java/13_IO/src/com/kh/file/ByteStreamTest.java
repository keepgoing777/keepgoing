package com.kh.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * IO (Input / Output)
 * - 입력과 출력
 * - 두 대상 간의 데이터를 주고 받는 것
 * 
 * 스트림(stream)
 * - 데이터를 운반하는 연결 통로
 * - 연속적인 데이터 흐름을 물(stream)에 비유
 * - 하나의 스트림으로 입출력을 동시에 할 수 없음 (단방향 통신)
 * - 입출력을 동시에 수행하려면 2개의 스트림 필요
 * 
 * */
public class ByteStreamTest {
	
	/*
	 * 바이트 기반 스트림
	 * - 데이터를 바이트(byte) 단위로 주고 받는다
	 * - 그림, 멀티미디어 등 바이너리 데이터를 읽고 출력할 때 사용
	 * - InputStream, OutputStream : 바이트 기반 입출력 스트림 최상위 클래스
	 * 
	 * 보조 스트림
	 * - 스트림의 기능을 향상시키거나 새로운 기능을 추가하기 위해 사용
	 * - 독립적으로 입출력을 수행할 수 없음
	 * */

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		// 성능이 높은 Buffer 사용
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			// 1. 먼저 기반 스트림을 생성한다.
			// FileInputStream, FileOutputStream : 파일에 입출력을 하기 위한 스트림
			fis = new FileInputStream("src/duck.jpg");
			fos = new FileOutputStream("src/output.jpg");
			
			// 2. 기반 스트림을 이용해서 보조 스트림을 생성한다.
			// DataInputStream, DataOutputStream : 기본형 타입으로 읽고 쓰는 보조 스트림
			//dis = new DataInputStream(fis);
			//dos = new DataOutputStream(fos);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			// 3. 데이터 읽어서 출력
			// dis.read : 1바이트씩 데이터 읽어서 int 반환 (0~255)
			// dos.write : 1바이트씩 출력 스트림 그대로 쓴다
			/*
			int data = 0;
			while((data = dis.read()) != -1) {
				dos.write(data);
			}*/
			
			// 8KB(8192바이트) / 16KB(16384바이트)가 가장 보편적
			byte[] buffer = new byte[8192];
			int data = 0;
			while((data = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, data);
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 자원반납
			try {
				bis.close();
				bos.close();
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}