package com.vignesh.nasdaq.main;

import java.util.Scanner;

import com.vignesh.nasdaq.solution.CalculateResults;

public class NasdaqApplication {
	
	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System. in);

		System.out.println("Enter the value of n :");
		long n = scanner.nextLong();
		System.out.println("Enter the value of C :");
		long c = scanner.nextLong();
		
		
		if(Math.pow(n-1, c)<Long.MAX_VALUE) {
			System.out.println("The result is : "+CalculateResults.sumOfProductsBiggerNumbersUsingThread(n, c));
		}else {
			if(c < 100 ) {
				System.out.println("The result is : "+CalculateResults.sumOfProductsBiggerNumbers(n, c));
			}else {
				//System.out.println("The result is : "+CalculateResults.sumOfProductsBiggerNumbers(n, c));
				System.out.println("The result is : "+CalculateResults.sumOfProductsBiggerNumbersUsingThread(n, c));
			}
		}
	}
	

}
