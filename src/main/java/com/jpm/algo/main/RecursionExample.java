package com.jpm.algo.main;

public class RecursionExample {
	
	static int[] intArr = new int[10];

	public static void main(String[] args) {

		// 1. 문제 : 비트n의 모든 문자열을 작성하시오
		// 비트에는 0, 1만 들어갈 수 있다.
		Number[] numArr = new Number[10];
		for (int i = 0; i < 10; i++) {
			numArr[i] = new Number();
		}

		create(10, numArr);
		
		// 2. 문제 : 0..k-1 에서 도출된 길이 n의 모든 문자열을 생성하시오.
		// k는 문자의 개수
		// n의 문자열의 길이
		kary(10, 2); // 10자리 문자열을 만든다 (k개의 문자를 가지고) 2의 10승 총 1024개의 문자열이 출력됨.
		
		// 3. 문제 : 하노이의 탑
		// 세개의 막대와 막대에 꽂을 수 있느느 서로 다른 크기의 원반들로 구성
		// 한 막대에 위로 갈수록 더 작은 크기 순서로 꽂혀 원뿔 모양을 한 원반들에서 시작
		// 한기둥에 꽂힌 원판들을 그 순서대로 다른 기둥으로 옮기는 문제
		// * 만족시켜야할 조건
		// 한번에 한개의 원반만 이동
		// 어떤 원반도 더 작은 원반위에 위치할 수 없다.
		towerOfHanoi(5, "a", "b", "c");
	}

	public static void create(int n, Number[] numArr) {
		if (n == 0) {
			printNumber(numArr);
			return;
		}

		numArr[n - 1].setNumber(0);
		create(n - 1, numArr);

		numArr[n - 1].setNumber(1);
		create(n - 1, numArr);
	}

	public static void printNumber(Number[] numArr) {
		for (Number num : numArr) {
			System.out.print(num.getNumber());
		}
		System.out.println();
	}

	public static class Number {
		private int number;

		public void setNumber(int number) {
			this.number = number;
		}

		public int getNumber() {
			return this.number;
		}
	}
	
	public static void kary(int n, int k) {
		if (n < 1) {
			for(int i:intArr){
				System.out.print(i);
			}
			System.out.println();
			return;
		} 

		for (int j = 0; j < k; j++) {
			intArr[n - 1] = j;
			kary(n - 1, k);
		}
		
	}
	
	public static void towerOfHanoi(int n, String a, String b, String c) {
		
		// 1 가장 위에 있는 원반, n 가장 아래에 있는 원반
		// 1~n-1을 하나의 원반으로 묶어 생각하고, 이 메소드에서는 2개의 원반을 다른 막대로 이동한다고 생각
		// 1~n-1의 이동은 재귀로 넘겨 분할해서 작업
		
		// a는 시작하는 막대기
		// b는 이동해야할 막대기
		// c는 보조 막대기(a->b로 이동할때 사용하는 temp공간)

		// 종료조건
		if (n == 1) {
			System.out.println(" from peg " + a + " to peg " + b);
			return;
		}

		// 1~n-1층까지 a->c로 옮긴다
		towerOfHanoi(n - 1, a, c, b);

		// n번째 층을 a->b로 옮긴다
		towerOfHanoi(1, a, b, c);

		// 1~n-1층까지 c->b로 옮긴다
		towerOfHanoi(n - 1, c, b, a);
	}
}
