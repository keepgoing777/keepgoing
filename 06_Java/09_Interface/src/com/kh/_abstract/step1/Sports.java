package com.kh._abstract.step1;

//추상 클래스 (추상 클래스에서는 무조건 추상 메서드여야 함)
public abstract class Sports {

	protected int numOfPlayer;
	
    public abstract void rule();
    //추상 메서드! 즉, 미완성된 메서드! 구현 부가X -> 자식 클레스에서 구현하도록 강제성 부여 
		
	public Sports(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
		
	public int getNumOfPlayer() {
		return numOfPlayer;
	}


	public void setNumOfPlayer(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}




	@Override
	public String toString() {
		return "Sports [numOfPlayer=" + numOfPlayer + "]";
	}	
	
}
