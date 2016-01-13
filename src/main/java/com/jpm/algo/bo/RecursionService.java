package com.jpm.algo.bo;

import org.springframework.stereotype.Service;

@Service("recursionService")
public class RecursionService {

	public void printBinaryString(int n , Integer[] bArray) {
		if (n < 1) {
			for (Integer i : bArray) {
				System.out.println(i);
			}
			System.out.println("===================");
		} else {
			bArray[n - 1] = 0;
			
			printBinaryString(n - 1 , bArray);
			
			bArray[n - 1] = 1;
			
			printBinaryString(n - 1 , bArray);
		}
	}

}
