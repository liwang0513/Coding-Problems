package leetcode;

import java.util.Arrays;

public class RotateArrayInPlace {
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		
		rotate(array, 3);
		System.out.println(Arrays.toString(array));
	}
	
	static void rotate(int[] nums, int k) {
		rotate(nums, 0, nums.length-1);
		rotate(nums, 0, k-1);
		rotate(nums, k, nums.length-1);
	}
	
	static void rotate(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
}
