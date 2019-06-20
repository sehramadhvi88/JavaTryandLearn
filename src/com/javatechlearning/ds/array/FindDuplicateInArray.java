package com.javatechlearning.ds.array;

import java.util.stream.IntStream;

public class FindDuplicateInArray {

	public static void main(String[] args) {
		
		int a[]= {1,2,3,4,4};
		
		int val = findDuplicate(a);
		
		System.out.println("Duplicate value:"+val);
		
		int b[]= {1,2,3,4,2};
		
		val = findDuplicateUsingSum(b);
		
		System.out.println("Duplicate value:"+val);
		
	}

	// solution 1 , using hashing
	private static int findDuplicate(int[] a) {
		// TODO Auto-generated method stub
		
		boolean visitedElement[]= new boolean[a.length+1]; // create a bool array of size n+1 ( becoz we have array of size n , with elements from 1 to n-1 )
		// initially this array has all  values as false 
		
		
		for(int i=0;i<a.length;i++) {
			
			if(visitedElement[a[i]]) {
				return a[i];
			}
			visitedElement[a[i]]=true;
			/*
			 * 	boolean array of size n+1 (5+1) - becoz we have elements from 1 to n-1 , if size is 5 then elemts are in range of 1 to 4 
			 *    0,1,2,3,4,5  - index [ we took extra 1 plus becoz for 0 index we dont have value ]
			 *   [f,f,f,f,f,f]
			 *      t,t,t,t
			 */
			
			
		}
		
		return -1;
	}
	
	private static int findDuplicateUsingSum(int[] a) {
		
		int sum_expected = a.length*(a.length-1)/2;
		int sum_actual = IntStream.of(a).sum();
		
		return sum_actual-sum_expected;
	}
	
}

/*
 * Find a duplicate number in a array of integers of size n , containing elements between 1 to n-1 
 * 
 * example :
 * 
 * Input : {1,2,3,4,4}
 * 
 * output : duplicate element : 4 
 * 
 * Input : {1,2,3,4,2}
 * 
 * output : duplicate element : 4 
 * 
 */

