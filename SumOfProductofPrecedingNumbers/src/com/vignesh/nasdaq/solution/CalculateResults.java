package com.vignesh.nasdaq.solution;

import java.math.BigInteger;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculateResults {
	
	public static ArrayList<Long> resultList = new ArrayList<Long>();
	

	public static long sumOfProducts(long lastNumber , long totalPrecedingNumbers) {
		long sumValue = 0;
		for(long number = 1 ; number <=lastNumber ; number++) {
			long productValue = (number==1) ? 0 : 1; //Since there are no preceding values to 1 
			
			long precedingNumber=(number-totalPrecedingNumbers)<=0?1:(number-totalPrecedingNumbers);
			
			for(; precedingNumber <number ; precedingNumber++) {
				 productValue *= precedingNumber;
			}
			sumValue += productValue;
		}
		return sumValue; 
	}
	
	
	public static BigInteger sumOfProductsBiggerNumbers(long lastNumber , long totalPrecedingNumbers) {
		BigInteger sumValue = BigInteger.valueOf(0);
		long timeBeforeExecution = new Date().getTime();
		
		for(long number = 1 ; number <=lastNumber ; number++)
		{
			BigInteger productValue = (number == 1) ? BigInteger.valueOf(0) : BigInteger.valueOf(1);
			
			long precedingNumber = (number-totalPrecedingNumbers) <=0 ? 1 : (number-totalPrecedingNumbers);
			for(; precedingNumber <number ; precedingNumber++) {
				productValue = productValue.multiply(BigInteger.valueOf(precedingNumber));
			}
			sumValue = sumValue.add(productValue) ;
		}
		long timeAfterExecution = new Date().getTime();
		System.out.println("Total time taken to execute without using threads- " + (timeAfterExecution - timeBeforeExecution));
		return sumValue; 
	}

	
	public static BigInteger sumOfProductsBiggerNumbersUsingThread(long lastNumber , long totalPrecedingNumbers) {
		ArrayList<Long> inputSeries = new ArrayList<Long>();
		BigInteger result = BigInteger.valueOf(0);
		long timeBeforeExecution = new Date().getTime();

		ExecutorService executor = Executors.newFixedThreadPool(50);
		List< Future<BigInteger>> futures = new ArrayList<>();

		for(long number = 1 ; number <= lastNumber ; number++) {
			inputSeries.add(number);
		}
		
		for(long number = 1 ; number <= lastNumber ; number++)
		{
			long finalNumber = number;
			futures.add(executor.submit(() -> {
				BigInteger productValue = (finalNumber == 1) ? BigInteger.valueOf(0) : BigInteger.valueOf(1);
				long precedingNumber = (finalNumber-totalPrecedingNumbers) <=0 ? 1 : (finalNumber - totalPrecedingNumbers);
	        	for(; precedingNumber < finalNumber; precedingNumber++) {
					productValue = productValue.multiply(BigInteger.valueOf(precedingNumber));
				}
	        	return productValue;
	        }));
		}
		
		for(Future<BigInteger> future : futures) {
		    try {
		    	result = result.add(future.get());
		    }catch(Exception e){
		    }
		}
		executor.shutdown();
		long timeAfterExecution = new Date().getTime();
		System.out.println("Total time taken to execute withowhileut using threads- " + (timeAfterExecution - timeBeforeExecution));

		return result;
	}	


}
