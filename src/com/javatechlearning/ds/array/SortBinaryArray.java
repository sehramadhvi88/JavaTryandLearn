package com.javatechlearning.ds.array;

import java.util.Arrays;

public class SortBinaryArray {

	public static void main(String[] args) {
		
		int[] a = {0,0,1,0,1,1,0,1,0,0};
		
		//sortByCouting(a);
		//System.out.println(Arrays.toString(a));
		sortByPuttingZeroToNext(a);
		System.out.println(Arrays.toString(a));
		
	}

	private static void sortByPuttingZeroToNext(int[] A) {
		// TODO Auto-generated method stub
		// k stores index of next available position
				int k = 0;

				// do for each element
				for (int i = 0; i < A.length; i++)
				{
					// if current element is zero, put 0 at next free
					// position in the array
					if (A[i] == 0) {
						A[k] = 0;
						k++;
					}
				}
				
				// fill all remaining indices by 1
				for (int i = k; i < A.length; i++) {
					A[k++] = 1;
				}
	}

	private static void sortByCouting(int[] a) {
		// TODO Auto-generated method stub
		int zeroCount = 0;
		
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				zeroCount++;
			}
		}
		
		int k=0;
		while(zeroCount !=0) {
			a[k]=0;
			k++;
			zeroCount--;
		}
		
		while(k<a.length) {
			a[k]=1;
			k++;
		}
		
	}
	
	
	
	
}

/*
 * Given a binary array , sort it in a linear time and constant space.
 * 
 * example: 
 * input : {1,0,1,0,1,0,0,1}
 * outout : {0,0,0,0,1,1,1,1}
 * 
 */

