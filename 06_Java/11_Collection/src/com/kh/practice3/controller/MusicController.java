package com.kh.practice3.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.practice3.compare.SongAscending;
import com.kh.practice3.model.Music;

public class MusicController {

	private Scanner sc = new Scanner(System.in);
	private ArrayList<Music> list = new ArrayList<>();

	// 메서드 리턴타입, 파라미터 받는 부분 자유
	// 1. 특정 곡 추가
	public boolean addList(String artist, String song) {		

	    for(Music music : list) {
	    	if(music.getSong().equals(song) && music.getArtist().equals(artist)) {
	    		return false;
	    	}
	     }
	     if(artist.trim().equals("") || song.trim().equals("")) {
	        	return false;
	     }
		return list.add(new Music(artist, song));
	    
		
  }// addList종료

	// 2. 전체 곡 목록 출력
	public ArrayList<Music> printAll() {
		return list; //list를 리턴하고 list의 생성자명 가지고 옴
  }// printAll 종료

	// 3. 특정 곡 검색
	public ArrayList<Music> searchMusic(String keyword) {
		
		ArrayList<Music> reuslt = new ArrayList<>();
	
		for(Music music : list) {
			if(music.getSong().toLowerCase().contains(keyword.toLowerCase()) || 
				music.getArtist().toLowerCase().contains(keyword.toLowerCase())) { //비교할때 서로 소문자로 비교하고 포함되어있으면 반환
			//if(music.getSong().contains(keyword)) { //키워드 포함
			//if(keyword.equals(music.getSong())) : 완전 일치
		    //if(keyword.equalsIgnoreCase(music.getSong())) :  소문자/대문자 무시
				reuslt.add(music);
			}
		}
		return reuslt;
		
  } //searchMusic 종료 			

//곡 검색 시 중복된 경우

	public ArrayList<Music> checkMusic(String song) {
		ArrayList<Music> result = new ArrayList<>();
		for(Music music : list) {
			if(music.getSong().equals(song)) {
				result.add(music);
			}
		}
		return result;
	}	
	
// 4. 특정 곡 수정 -> 1개인 경우와 여러개인 경우로 나눠지는 상황

	public Music updateMusic(String searchSong, String searchArtist, Music update) {
		
		for(Music music : list) {
			boolean checkSong = music.getSong().equals(searchSong);
			boolean checkArtist = music.getArtist().equals(searchArtist);
			
			if(searchArtist==null && checkSong || checkSong && checkArtist) {
				//기존 리스트에서 수정할 값이 있는 경우 - 수정못하게
				if(music.getSong().equals(update.getSong()) && 
					music.getArtist().equals(update.getArtist())){
					return null;
				}	
				return list.set(list.indexOf(music), update); 
			}
	    }
		return null;
		
	}//updateMusic 종료 

	// 5. 특정 곡 삭제
/*	public boolean removeMusic(String song) {
		for(Music music : list) {
			if(music.getSong().equals(song)) {
				  return list.remove(music); //boolean 타입
				}
		}
		return false;
*/		
		public Music removeMusic(String song, String artist) {
			for(Music music : list) {
				if(artist==null && music.getSong().equals(song) 
						|| music.getSong().equals(song) && music.getArtist().equals(artist)) {
					  return list.remove(list.indexOf(music)); //Music 타입
					}
			}
			return null;	

				
} // removeMusic 종료


//7. 가수명 내림차순
		public ArrayList<Music> descArtist(){
			ArrayList<Music> clone = (ArrayList<Music>) list.clone();
			Collections.sort(clone);
			// Collections.reverse(clone);
			return clone;
		}
  //곡명 오름차순
		public ArrayList<Music> ascSong(){
			ArrayList<Music> clone = (ArrayList<Music>) list.clone();
			Collections.sort(clone, new SongAscending());
			return clone;
		}
}