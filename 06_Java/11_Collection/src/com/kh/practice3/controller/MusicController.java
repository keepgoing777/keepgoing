package com.kh.practice3.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice3.model.Music;

public class MusicController {

	private Scanner sc = new Scanner(System.in);
	private ArrayList<Music> list = new ArrayList<>();

	// 메서드 리턴타입, 파라미터 받는 부분 자유
	// 1. 특정 곡 추가
	public void addList() {
		System.out.println("가수명");
		String newartist = sc.nextLine();
		System.out.println("곡명");
		String newsong = sc.nextLine();

		// "추가 실패" -> 기존 똑같은 곡과 가수가 있을 시
		for (Music music : list) {
			if (music.getArtist().equals(newartist) && music.getSong().equals(newsong)) {
				System.out.println("추가 실패");
				return;
			}
		}
		// * 곡 추가 성공하면 "추가 성공"
		list.add(new Music(newartist, newsong));
		System.out.println("추가 성공");
		
  }// addList종료

	// 2. 전체 곡 목록 출력
	public void printAll() {
		for (Music music : list) {
			System.out.println(music);
		}

  }// printAll 종료

	// 3. 특정 곡 검색
	public void searchMusic() {
		System.out.println("특정 곡명 검색 : ");
		String ssong = sc.nextLine();
		
		for(Music music : list) {
			if(music.getSong().contains(ssong)) {
				System.out.println( ssong + "검색했습니다.");
				return;
			}
		}
		System.out.println("검색할 곡을 찾지 못했습니다.");
		
		/*
		 * ****** 특정 곡 검색(가수/곡) ******
		 * 키워드 곡명 :
		 * 
		 * 검색할 곡이 있다면 "(가수 - 곡)을 검색했습니다."
		 *          없다면 "검색할 곡을 찾지 못했습니다."
		 * */
		
 } //searchMusic 종료 

	// 4. 특정 곡 수정
	public void updateMusic() {

	}

	// 5. 특정 곡 삭제
	public void removeMusic() {
		System.out.println("삭제할 곡명: ");
		String rsong = sc.nextLine();
		
		for(Music music : list) {
	    if(music.getSong().contains(rsong)) {
	    	list.remove(indexOf(rsong));
	    	System.out.println(rsong + " 을 삭제했습니다.");
	    	return;
	      } 
		}
		  System.out.println("삭제할 곡이 없습니다.");
		/*
		 * ****** 특정 곡 삭제 ******
		 * 삭제할 곡명 : 
		 * 
		 * 삭제에 성공한다면 "(삭제한 가수 - 삭제한 곡)을 삭제했습니다."
		 *      실패한다면 "삭제할 곡이 없습니다."
		 * */
		
} // removeMusic 종료

	private Object indexOf(String rsong) {
		return null;
	}

}