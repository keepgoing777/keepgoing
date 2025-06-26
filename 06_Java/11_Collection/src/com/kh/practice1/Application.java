package com.kh.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Application {
	//1등 당첨기준이 로또 번호 6개 
	//랜덤 둘다 (하나는 한번, 나는 무한)
	//정렬이 딱 맞으면 equals로 비교 가능 (1등 당첨 확인) 
    //2등 - 보너스 번호 일치 + 5개 같은경우
	//3등 - 5개 같은경우
	//4등 - 4개 같은경우
	//5등 - 1개 같은경우
	//index 0 일때 2등 1일때 3등 2일때 4등 3일때 5등 
	// 로또 1등 될때까지 2,3,4,5등은 몇번이 되었을까?

	
	public static void main(String[] args) {
				
		int[] result = new int[4];
		
	     //HashSet이 알아서 중복 제거해줌
		 Set<Integer> lotto = new HashSet<>();
		 while(lotto.size() < 7) {
		  lotto.add((int)(Math.random() * 45) + 1);
		 } //7개로 변경(2등)
	     List<Integer> lottoList = new ArrayList<>(lotto); //set -> list
	     List<Integer> realLotto = lottoList.subList(0,6); // subList로 6자리짤라오기
	     int bonus = lottoList.get(6);

		int count = 0;
	    //if(!myLotto.contains(number))로 중복 확인하면서 6개 숫자 추출
		while(true){
			count++;
			List<Integer> myLotto = new ArrayList<>();
		  while(myLotto.size()<6) {
			int number = (int) (Math.random() * 45) + 1;
			if(!myLotto.contains(number)) {
				myLotto.add(number);
			}
		  }
			Collections.sort(realLotto);
			Collections.sort(myLotto);
			
			System.out.println("내 번호" + myLotto);
			System.out.println("로또번호" + realLotto);
			
	    int check = 0;
	    for(Integer number : realLotto) {
	    	if(myLotto.contains(number)) 
	    		check++;
	    	}
					
		if(realLotto.equals(myLotto)) {
			System.out.println("1등 당첨! 까지 걸린 횟수 : " + count);
			for(int i = 0 ; i < result.length; i++) {
				System.out.print((i+2)+"등 당첨횟수 : " + result[i] + "회");}
		     break;
			}else if(check == 5 && myLotto.contains(bonus)){
				System.out.println("2등 당첨! 보너스 번호 : " + bonus + ", 횟수 : " + count );// 2등 당첨 : 5개가 같고 보너스 번호가 맞고 
			     result[0]++;
			} else if (check == 5) {
				System.out.println("3등 당첨! 횟수 : " + count);
				 result[1]++;
			} else if (check == 4 ) {
				System.out.println("4등 당첨! 횟수 : " + count);
				 result[2]++;
			} else if (check == 3 ) {
				System.out.println("5등 당첨! 횟수 : " + count);
				 result[3]++;
			}
		}
	}		
}			
	

/*		        Random random = new Random();
		        
		        // 첫 번째 랜덤 6개 숫자 생성 및 저장 (출력 없음)
		        Set<Integer> firstNumbers = generateRandomNumbers(random);
		        List<Integer> firstResult = new ArrayList<>(firstNumbers);
		        Collections.sort(firstResult);
		        
		        // 시도 횟수 카운트
		        int count = 0;
		        
		        // 두 번째 랜덤 숫자들과 비교 반복
		        while (true) {
		            count++;
		            Set<Integer> secondNumbers = generateRandomNumbers(random);
		            List<Integer> secondResult = new ArrayList<>(secondNumbers);
		            Collections.sort(secondResult);
		            
		            System.out.println("시도 " + count + "회: " + secondResult);

		            // 두 세트가 같은지 비교
		            if (firstNumbers.equals(secondNumbers)) {
		                System.out.println("축하합니다! 총 시도 횟수: " + count + "회");
		                System.out.println("일치한 숫자: " + firstResult);
		                break;
		            }
		 
		        }

		    }
		    
	 // 중복 없는 랜덤 6개 숫자 생성 메서드
	 public static Set<Integer> generateRandomNumbers(Random random) {
		          Set<Integer> numbers = new HashSet<>();
		          
		        while (numbers.size() < 6) {
		            int randomNumber = random.nextInt(45) + 1;
		            numbers.add(randomNumber);
		        }
		        
		        return numbers;
		    }
*/		

	 

	 

