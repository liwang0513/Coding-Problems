package leetcode;

import java.util.*;

public class NextPermutation {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(next(new int[]{1, 1, 5})));
	}
	
	static int[] next(int[] nums) {
		List<Integer> list = new ArrayList<>();
		
		int index = nums.length-1;
		while (index > 0 && nums[index-1] > nums[index]) {
			list.add(nums[index]);
			index--;
		}
		
		
		if (index == 0) {
			list.add(nums[0]);
			Collections.sort(list);
			for (int i=0; i<nums.length; i++) {
				nums[i] = list.get(i);
			}
			return nums;
		}
		
		list.add(nums[index-1]);
		nums[index-1] = nums[index];
		Collections.sort(list);
		for (int i=0; i<list.size(); i++) {
			nums[index++] = list.get(i);
		}
		return nums;
	}
}
