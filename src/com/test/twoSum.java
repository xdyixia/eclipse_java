//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

//time complexity O(n2)
//space complexity O(1)
//okay
package com.test;

import java.util.Scanner;

public class twoSum{
	public int[] sol(int[] nums, int target) {
		 for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++) {
	            if (nums[j] == target - nums[i]) {
	                return new int[] { i, j };
	            }
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
    }

	
     public static void main(String[] args) {	
    	 
    	System.out.println("输入数组长度n：");
     	Scanner in = new Scanner(System.in);
     	int n = in.nextInt();
     	
     	System.out.println("输入数组元素:");
     	int[] nums= new int[n];
     	for(int j = 0 ; j < n ; j++){
			nums[j] = in.nextInt();
		}  
     	
     	System.out.println("输入目标数target：");
     	int target = in.nextInt();
     	
     	twoSum ts = new twoSum();
     	int[] result = new int[2];
     	result = ts.sol(nums, target);
     	
     	for(int j = 0 ; j < 2 ; j++){
			System.out.println(result[j]);
		}
     	
    }
}
