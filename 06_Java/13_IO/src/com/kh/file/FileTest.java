package com.kh.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * File 클래스
 * - 파일과 디렉터리를 다루는데 사용하는 클래스
 * Path + Files
 * - 경로 조작도 유연하고 파일 I/O 수행하는데 강력하고 편리함
 * */
public class FileTest {

	public static void main(String[] args) {
		File file = new File("src/test.txt");
		Path path = Paths.get("src/test.txt");
		
		System.out.println("파일명 : " + file.getName());
		System.out.println("절대 경로 : " + file.getAbsolutePath());
		System.out.println("상대 경로 : " + file.getPath());
		System.out.println("파일 용량 : " + file.length());
		System.out.println("파일 존재 여부 : " + file.exists());
		System.out.println("디렉터리 여부 : " + file.isDirectory());
				
		try {
			System.out.println("path ----------------------------------");
			System.out.println("파일명 : " + path.getFileName());
			System.out.println("절대 경로 : " + path.toAbsolutePath());
			System.out.println("상대 경로 : " + path);
			System.out.println("파일 용량 : " + Files.size(path));
			System.out.println("파일 존재 여부 : " + Files.exists(path));
			System.out.println("디렉터리 여부 : " + Files.isDirectory(path));

			File newFile = new File("src/temp/test.txt");
			File tempDir = new File("src/temp");
			
			// 디렉터리가 존재하지 않다면 폴더부터 생성!
			if(!tempDir.isDirectory()) {
				tempDir.mkdir();
			}
				
			// 파일이 존재하지 않다면 생성!
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			
			// ----------------------------------------------
			Path newFile2 = Paths.get("src/temp2/test.txt");
			Path tempDir2 = newFile2.getParent();
			
			// 폴더가 존재하지 않다면 생성!
			if(!Files.isDirectory(tempDir2)) {
				Files.createDirectories(tempDir2);
			}
			
			// 파일이 존재하지 않다면 생성!
			if(!Files.exists(newFile2)) {
				Files.createFile(newFile2);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}