package leetcode;

import java.util.*;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		int[] nums = {2, 1, 5, 6, 2, 3};
		System.out.println(maxArea(nums));
		
	}
	
	static int maxArea(int[] nums) {
		int max = 0;
		
		// mantain a stack store index;
		Stack<Integer> s = new Stack<>();
		
		for (int i=0; i<nums.length; i++) {
			if (s.isEmpty() || nums[i] > nums[s.peek()]) s.push(i);
			else {
				int rightIndex = s.peek();
				while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
					int leftIndex = s.pop();
					int area = (rightIndex-leftIndex+1)*nums[leftIndex];
					max = Math.max(max, area);
				}
				s.push(i);
			}
		}
		
		if (!s.isEmpty()) {
			int rightIndex = s.peek();
			while (!s.isEmpty()) {
				int leftIndex = s.pop();
				int area = (rightIndex-leftIndex+1)*nums[leftIndex];
				max = Math.max(max, area);
			}
		}
		
		return max;
	}
}
