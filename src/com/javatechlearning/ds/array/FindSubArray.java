package com.javatechlearning.ds.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A={3,4,-7,3,1,3,1,-4,-2,2};
		int sum = 0 ;
		
		printallSubarrays(A);
		
		//findSubArray(A,sum);
		
	}
	
	
	private static<K,V> void insert(Map<K, List<V>> hashMap, K key, V value)
	{
		// if the key is seen for the first time, initialize the list
		if (!hashMap.containsKey(key)) {
			hashMap.put(key, new ArrayList<>());
		}

		hashMap.get(key).add(value);
	}

	// Function to print all sub-arrays with 0 sum present
	// in the given array
	public static void printallSubarrays(int[] A)
	{
		// create an empty Multi-map to store ending index of all
		// sub-arrays having same sum
		Map<Integer, List<Integer>> hashMap = new HashMap<>();

		// insert (0, -1) pair into the map to handle the case when
		// sub-array with 0 sum starts from index 0
		insert(hashMap, 0, -1);

		int sum = 0;

		// traverse the given array
		for (int i = 0; i < A.length; i++)
		{
			// sum of elements so far
			sum += A[i];

			// if sum is seen before, there exists at-least one 
			// sub-array with 0 sum
			if (hashMap.containsKey(sum))
			{
				List<Integer> list = hashMap.get(sum);

				// find all sub-arrays with same sum
				for (Integer value: list) {
					// logic here is lets suppose there already exist sum key as 7 having value 1 ( index) and we get a sum of 7 as key again 
					// so here we check that key already exist , means this new some calculated after the index of already calculated sum
					System.out.println("Subarray [" + (value + 1) + ".." +
												i + "]");
				}
			}

			// insert (sum so far, current index) pair into the Multi-map
			insert(hashMap, sum, i);
		}
	}

}

/*
 *  Given an array of integers , check if array contains sub-array having given sum
 *  
 *  example:
 *  
 *  input :
 *  
 *  {3,4,-7,3,1,3,1,-4,-2,2}
 *  
 *  sum : 0 
 *  
 *  output : 
 *  
 *  sub-array :
 *  
 *  {3,4,-7}
 *  {4,-7,3}
 *  {-7,3,1,3}
 *  {3,1,-4}
 *  ...
 * 
 *  [ 0=[-1,2],3=[0,3],4=[4,7],7=[1,5],8=[6],2=[8]   ]
 * 
 * 
 * 
 * 
 * 
 */
