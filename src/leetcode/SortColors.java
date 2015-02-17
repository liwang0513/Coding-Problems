package leetcode;

import java.util.Arrays;

public class SortColors {

	
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 0, 1, 0, 0};
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	static void sort(int[] nums) {
		// {1, 2, 1, 0, 1, 0, 0}
		// {0, 0, 0, 1, 1, 1, 2}
		
		if (nums.length == 0 || nums.length == 1) {
			return;
		}
		
		int left = -1;
		int right = nums.length;
		
		int p = 0;
		while (p < right) {
			if (nums[p] == 0) {
				swap(nums, p, ++left);
				p++;
			} else if (nums[p] == 2) {
				swap(nums, p, --right);
			} else {
				p++;
			}
		}
	}
	
	static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
