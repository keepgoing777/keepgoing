package com.kh.practice2.controller;

import com.kh.practice2.model.Snack;

public class SnackController {

	
	private Snack s = new Snack();
	
	public String saveData(Snack snackData) {
		s.setKind(snackData.getKind());
		s.setName(snackData.getName());
		s.setFlavor(snackData.getFlavor());
		s.setNumOf(snackData.getNumOf());
		s.setPrice(snackData.getPrice());
		return "저장 완료되었습니다.";
	}
	
 	public String confirmDate() {
 		return s.getKind()+"("+ s.getName() +"-"+ s.getFlavor() +") "+ s.getNumOf() +"개 "+ s.getPrice()+"원";}
 	
 	
}
