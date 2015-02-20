package leetcode;

import java.util.*;

public class Palantir {
//	Write a function that is given an array of integers. It should return true 
//	if and only if there are two distinct indices i and j into the array such 
//	that the difference between arr[i] and arr[j] is at most l and the 
//	difference between i and j is at most k.
	
	
	public static void main(String[] args) {
		
	}
	
	static boolean findClosest(int[] nums, int k, int L) {
		// 1. use hashtable to store latest k elements
		// 2. when add a element, if there is an element in hashtable
		// that between (nums[i]-L, nums[i]+L), we divide it by L
		// thus the new value would between (nums[i]/L-1, nums[i]/L+1);
		assert(L > 0);
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i=0; i<nums.length; i++) {
			if (i >= k) map.remove(nums[i-k]/L);
			
			int key = nums[i]/L;
			if (map.containsKey(key) || 
					map.containsKey(key-1) && nums[i]-map.get(key-1) <= L ||
					map.containsKey(key+1) && map.get(key+1)-nums[i] <= L) return true;
		}
		
		return false;
	}
}
