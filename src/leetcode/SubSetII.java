package leetcode;

import java.util.*;

public class SubSetII {

	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> result = generate(nums);
		for (List<Integer> e : result) {
			System.out.println(e);
		}
	}
	
	static List<List<Integer>> generate(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<List<Integer>> pre = new ArrayList<>();
		
		result.add(new ArrayList<Integer>());
		
		// sort the array
		Arrays.sort(nums);
		
		// for each element, add to the element in the pre list
		for (int i=0; i<nums.length; i++) {
			// if this is not dup num
			List<List<Integer>> temp = new ArrayList<>();
			if (i == 0 || nums[i] != nums[i-1]) {
				for (List<Integer> e : result) {
					List<Integer> t = new ArrayList<>(e);
					t.add(nums[i]);
					temp.add(t);
				}
			} else {
				// if this is dup, just add to pre list
				for (List<Integer> e : pre) {
					List<Integer> t = new ArrayList<>(e);
					t.add(nums[i]);
					temp.add(t);
				}
			}
			pre = temp;
			result.addAll(temp);
		}
		
		return result;
	}
}
