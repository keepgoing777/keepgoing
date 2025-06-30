package com.kh.practice3.compare;

import java.util.Comparator;

import com.kh.practice3.model.Music;

public class SongAscending implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		return o1.getSong().compareTo(o2.getSong());
	}
	

}
