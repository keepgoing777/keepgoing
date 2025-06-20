package com.kh.practice.controller;

import java.util.Arrays;

import com.kh.practice.model.RockPaperScissor;

public class RockPaperScissorController {

	RockPaperScissor rpsModel = new RockPaperScissor();

	private int computer;

	// 컴퓨터 랜덤값 추출 - 가위바위보
	public String randomComputer() {
		computer = (int) (Math.random() * 3);
		return rpsModel.getRps()[computer];
	}

	// 사용자가 입력한 값으로 인덱스 찾기
	public int userIndex(String input) {
		return Arrays.asList(rpsModel.getRps()).indexOf(input);
	}

	// 비긴경우
	public void rpsDraw() {
		rpsModel.setDraw(rpsModel.getDraw() + 1);
	}

	// 이긴경우
	public void rpsWin() {
		rpsModel.setWin(rpsModel.getWin() + 1);
	}

	// 진경우
	public void rpsLose() {
		rpsModel.setLose(rpsModel.getLose() + 1);
	}

	// 결과 정보 확인
	public String rpsResult() {
		return "비긴 횟수 : " + rpsModel.getDraw() + ", 진 횟수 : " + rpsModel.getLose() + ", 이긴 횟수 : " + rpsModel.getWin();
	}

	// 가위바위보 게임 rpsGame
	public int rpsGame(String input) {
		int result;
		int inputResult = userIndex(input);
		if (inputResult == computer) {
			result = 1;
			rpsDraw();
		} else if (inputResult == 0 && computer == 2 || inputResult == 1 && computer == 0
				|| inputResult == 2 && computer == 1) {
			result = 2;
			rpsWin();
		} else {
			result = 3;
			rpsLose();
		}
		return result;
	}

	public int computer() {
		return computer;
	}

}
