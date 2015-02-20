package leetcode;

public class MaxSubSum {

	public static void main(String[] args) {
		int[] nums = {2, -8, 3, -2, 4, -10};
		System.out.println(max(nums));
	}
	
	// 1. corner case : no element, invalid
	// 2. two variables : one is global max, the other is local max
	// scan the array if current sum is positive, compare with global max, else discard
	
	static String max(int[] nums) {
		if (nums.length == 0) throw new IllegalArgumentException("No element in the array");
		
		int localmax = nums[0];
		int max = nums[0];
		
		int left = 0;
		String result = "0 0";
		for (int i=1; i<nums.length; i++) {
			
			if (localmax+nums[i] < nums[i]) {
				left = i;
				localmax = nums[i];
			} else {
				localmax += nums[i];
			}
			
			if (max < localmax) {
				max = localmax;
				result = left+" "+i;
			}
		}
		
		return result;
	}
}
