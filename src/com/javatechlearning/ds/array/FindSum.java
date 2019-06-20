package com.javatechlearning.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FindSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[]= {8,7,2,5,3,1};
		int sum = 10;
		
		
		findPair(A, sum);
		findPairBySorting(A,sum);
		findPairByUsingMap(A,sum);
		
	}

	
	// solution 1 , since its running to loops it takes O(n^2) time
	static void findPair(int[] A,int sum) {
		
		for(int i=0;i<A.length-1;i++) {
			for(int j=i+1;j<A.length;j++) {
				if((A[i]+A[j]) == sum) {
					System.out.println("Pair found at:"+i+" and "+j);
				}
			}
		}
	}
	
	// solution 2 , by sorting the array we just need to iterate array only once from low to high
	// time taken is O(nlongn)
	static void findPairBySorting(int[] A,int sum) {
		
		// sort array in asc order
		Arrays.sort(A);
		// {1,2,3,5,7,8}
		
		//two end points of array
		int low=0;
		int high = A.length-1;
		
		while(low < high) {
			
			if(A[low]+A[high] == sum) {
				System.out.println("Pair found at:"+low+" and "+high);
				return;
			}
			
			if(A[low]+A[high] < sum) {
				low++;
			}else if(A[low]+A[high] > sum){
				high--;
			}
			
		}
	}
	
	// solution 3 ,store value and index in a map , check if there is another key exist as (sum-a[i])
	// O(n)
	static void findPairByUsingMap(int[] A,int sum) {
		
		Map<Integer,Integer> map = new HashMap<>();
		
		
		for(int i=0;i<A.length;i++) {
			
			if(map.containsKey(sum-A[i])) {
				System.out.println("Pair found at:"+map.get(sum-A[i])+" and "+i);
			}
			
			map.put(A[i],i);
		}
		
				
		System.out.println(map);
		
	}
	
}


/*
 * Problem : Find pair with given sum in an array
 * 
 * Given an unsorted array of integers , find a pair given the sum in it . 
 * 
 * example :
 * 
 * Input 
 * arr : [8,7,2,5,3,1]
 * sum : 10 
 * 
 * output :
 * 
 * pair 1 at index : 0 and 2 ( 8,2)
 * pair 2 at index : 1 and 4 ( 7,3) 
 * 
 */