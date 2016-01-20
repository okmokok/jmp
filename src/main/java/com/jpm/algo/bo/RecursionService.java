package com.jpm.algo.bo;

import org.springframework.stereotype.Service;

@Service("recursionService")
public class RecursionService {

	public void printBinaryString(int n , Integer[] bArray) {
		if (n < 1) {
			for (Integer i : bArray) {
				System.out.println(i);
			}
			System.out.println("!!!!!===================");
		} else {
			bArray[n - 1] = 0;
			
			printBinaryString(n - 1 , bArray);
			
			bArray[n - 1] = 1;
			
			printBinaryString(n - 1 , bArray);
		}
	}
	
	public void printCharacter(int n , int k , int[] ch) {
		if (n < 1) {
			for (int i : ch) {
				System.out.println(i);
			}
			
			System.out.println("-----------------");
		} else {
			for (int j = 0; j < k ; j++) {
				ch[n-1] = j;
				printCharacter(n-1 , k , ch);
			}
		}
	}

}
