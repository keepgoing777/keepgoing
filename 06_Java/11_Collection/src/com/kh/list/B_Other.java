package com.kh.list;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class B_Other {
/*
 * Vector - 동기화된(synchronized) 메서드로 구성(개념은 스레드에서~)
 * */
	public void method1() {
		Vector<Integer> v = new Vector<>();
		v.add(0);
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(6);
		v.add(7);
		v.add(8);
		v.add(9);
		v.add(10);
		
		System.out.println(v);
		//size : 실제 배열 데이터 수 11
		System.out.println("size : "+ v.size());
		//capacity : 내부 배열 크기 20 (v.add(10); 넣자마자 10에서 20으로 변경
		System.out.println("capaciry : " + v.capacity());
		
		v.trimToSize(); // capacity 사이즈를 size에 맞게 줄임
		
		System.out.println("size : "+ v.size());
		//capacity : 내부 배열 크기 20 (v.add(10); 넣자마자 20에서 11로 변경
		System.out.println("capaciry : " + v.capacity());
		
	}
	
	// 스택(Stack) : 마지막에 저장한것을 제일 먼저 꺼내는 LIFO(Last In First Out)
	// 스택이나 힙 메모리 같이 차곡차곡 쌓이고 꺼낼때도 맨 위를 꺼냄
	public void method2() {
		Stack<Integer> s = new Stack<>();
		s.push(0); //push : 데이터 추가 
		s.push(1); 
		s.push(2); 
		s.push(3); 
		s.pop(); // pop : 마지막에 추가된 데이터 삭제
		s.push(4);
		s.pop();
		s.push(5);
		s.push(6);
		s.push(7);
		s.pop();
		System.out.println((s)); // 0 1 2 5 6
	
	}
	
    //큐(Queue) : 처음에 저장한 것을 제일 먼저 꺼내는 FIFO(First In First Out)
	//통로 형태로 순서대로 쌓이고 순서대로 꺼내옴 
	public void method3() {
     	//Queue q = new Queue(); 인터페이스라 객체 생성 못함
		Queue<Integer> q = new LinkedList<>();
		q.offer(0); //offer : 데이터 추가 
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.poll(); // poll : 가장 먼저 추가된 데이터 삭제 offer(0)
		q.offer(4);
		q.remove(); // remove : 데이터 삭제 
		q.offer(5);
		q.offer(6);
		q.offer(7);
		q.remove(); // remove : 데이터 삭제
		System.out.println(q);
		
	}
	
	//Deque - 양방향, Stack/Queue 둘다 사용 가능
	public void method4() {
		Deque<Integer> d = new LinkedList<>();
		
		//데이터 추가
		d.offerLast(1);
		d.offerLast(2);
		d.offerLast(3);
		
		//Stack - 데이터 삭제 시 마지막 데이터를 삭제 3 삭제
		d.pollLast();
	 	
		//Queue - 첫번째 데이터부터 삭제 1 삭제 
		d.pollFirst();
		d.offerFirst(0);
		
		
		System.out.println(d); // 0, 2 
	}
	
	
	public static void main(String[] args) {
       B_Other b = new B_Other();
       //b.method1();
       //b.method2();
       //b.method3();
         b.method4();
	}

}
