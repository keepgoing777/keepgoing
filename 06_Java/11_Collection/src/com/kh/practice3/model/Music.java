package com.kh.practice3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Music implements Comparable<Music> {

	private String artist;
	private String song;
	
	@Override
	public int compareTo(Music o) {
		//return this.artist.compareTo(o.artist); //올림차순 (정배열)
		return o.artist.compareTo(this.artist); // 내림차순 (역배열, mc에서 reverse 안쓰고싶으면 반대로 비교하면됨)
	}

}