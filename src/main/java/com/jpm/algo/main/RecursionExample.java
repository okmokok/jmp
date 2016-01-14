package com.jpm.algo.main;

public class RecursionExample {
	
	static int[] intArr = new int[10];

	public static void main(String[] args) {

		// 1. ���� : ��Ʈn�� ��� ���ڿ��� �ۼ��Ͻÿ�
		// ��Ʈ���� 0, 1�� �� �� �ִ�.
		Number[] numArr = new Number[10];
		for (int i = 0; i < 10; i++) {
			numArr[i] = new Number();
		}

		create(10, numArr);
		
		// 2. ���� : 0..k-1 ���� ����� ���� n�� ��� ���ڿ��� �����Ͻÿ�.
		// k�� ������ ����
		// n�� ���ڿ��� ����
		kary(10, 2); // 10�ڸ� ���ڿ��� ����� (k���� ���ڸ� ������) 2�� 10�� �� 1024���� ���ڿ��� ��µ�.
		
		// 3. ���� : �ϳ����� ž
		// ������ ����� ���뿡 ���� �� �ִ��� ���� �ٸ� ũ���� ���ݵ�� ����
		// �� ���뿡 ���� ������ �� ���� ũ�� ������ ���� ���� ����� �� ���ݵ鿡�� ����
		// �ѱ�տ� ���� ���ǵ��� �� ������� �ٸ� ������� �ű�� ����
		// * �������Ѿ��� ����
		// �ѹ��� �Ѱ��� ���ݸ� �̵�
		// � ���ݵ� �� ���� �������� ��ġ�� �� ����.
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
		
		// 1 ���� ���� �ִ� ����, n ���� �Ʒ��� �ִ� ����
		// 1~n-1�� �ϳ��� �������� ���� �����ϰ�, �� �޼ҵ忡���� 2���� ������ �ٸ� ����� �̵��Ѵٰ� ����
		// 1~n-1�� �̵��� ��ͷ� �Ѱ� �����ؼ� �۾�
		
		// a�� �����ϴ� �����
		// b�� �̵��ؾ��� �����
		// c�� ���� �����(a->b�� �̵��Ҷ� ����ϴ� temp����)

		// ��������
		if (n == 1) {
			System.out.println(" from peg " + a + " to peg " + b);
			return;
		}

		// 1~n-1������ a->c�� �ű��
		towerOfHanoi(n - 1, a, c, b);

		// n��° ���� a->b�� �ű��
		towerOfHanoi(1, a, b, c);

		// 1~n-1������ c->b�� �ű��
		towerOfHanoi(n - 1, c, b, a);
	}
}
