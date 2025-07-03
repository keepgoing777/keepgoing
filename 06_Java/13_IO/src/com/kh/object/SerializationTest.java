package com.kh.object;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class SerializationTest {

	String fileName = "src/person.obj";

	public static void main(String[] args) {
		SerializationTest s = new SerializationTest();
		// s.fileSave();
		//s.fileRead();
		s.objectsSave();
		s.objectsRead();
	}

	public void fileSave() {

		// 1. 스트림 생성
		// FileOutputStream : 파일 출력에 사용되는 기본 바이트 스트림 클래스
		// ObjectOutputStream : 객체 단위로 출력 시에 사용되는 보조 바이트 스트림 클래스
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			// 2. 파일에 저장할 객체 생성
			Person p = new Person("셀레나 고메즈", "selenagomez");

			// 3. 파일에 데이터(객체) 저장
			oos.writeObject(p);

			System.out.println("person.obj 파일에 정보 저장!");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 역직렬화(deserialization) : 저장된 내용이나 전송받은 내용을 다시 복원
	public void fileRead() {
		// 1. 스트림 생성
		// FileInputStream : 파일 출력에 사용되는 기본 바이트 스트림 클래스
		// ObjectInputStream : 객체 단위로 출력 시에 사용되는 보조 바이트 스트림 클래스
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			// 2. 보조 스트림에 담겨진 객체 가져오기
			Person person = (Person) ois.readObject();
			System.out.println(person);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 여러 객체 저장 -> fileSave 참고
	public void objectsSave() {
		List<Person> list = Arrays.asList(new Person("카일리 제너", "kyliejenner"), new Person("드웨인 존슨", "therock"),
				new Person("아리아나 그란데", "arianagrande"));
		
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			// 첫번째 방식 - 리스트 통째로 직렬화
			//oos.writeObject(list);

			for(Person p : list) {
				oos.writeObject(p);
			}
			
			System.out.println("person.obj 파일에 정보 저장!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일에 저장된 데이터 읽기 -> fileRead 참고
	public void objectsRead() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			// 2. 보조 스트림에 담겨진 객체 가져오기
			/* 첫번째 방식으로 했을 때
			List<Person> list = (List<Person>) ois.readObject();
			for(Person person : list) {
				System.out.println(person);
			}*/
			while(true) {
				System.out.println(ois.readObject());
			}
		} catch(EOFException e) { 
			// EOF - End Of File : 파일 끝에 도달
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}