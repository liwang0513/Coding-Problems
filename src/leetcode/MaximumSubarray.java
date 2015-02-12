package leetcode;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = {2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		System.out.println(maxSub(nums));
		System.out.println(onePass(nums));
		System.out.println(maxProduct(nums));
	}
	
	static int maxSub(int[] nums) {
		return maxSubHelper(nums, 0, nums.length-1);
	}
	
	static int maxSubHelper(int[] nums, int start, int end) {
		if (start > end) return Integer.MIN_VALUE;
		
		int mid = (start+end) / 2;
		int left = maxSubHelper(nums, start, mid-1);
		int right = maxSubHelper(nums, mid+1, start);
		
		int sum = 0;
		int lSum = 0;
		for (int i=mid-1; i>= start; i--) {
			sum += nums[i];
			lSum = Math.max(sum, lSum);
		}
		
		sum = 0;
		int rSum = 0;
		for (int i=mid+1; i<= end; i++) {
			sum += nums[i];
			rSum = Math.max(sum, rSum);
		}
		
		return Math.max(lSum+nums[mid]+rSum, Math.max(left, right));
	}
	
	static int onePass(int[] nums) {
		assert nums.length > 0;
		
		int localMax = nums[0], globalMax = nums[0];
		
		for (int i=1; i<nums.length; i++) {
			localMax = Math.max(localMax+nums[i], nums[i]);
			globalMax = Math.max(localMax, globalMax);
		}
		
		return globalMax;
	}
	
	static int maxProduct(int[] nums) {
		assert nums.length > 0;
		
		int localMax = nums[0], localMin = nums[0], globalMax = nums[0];
		
		for (int i=1; i<nums.length; i++) {
			int max = localMax, min = localMin;
			localMax = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
			localMin = Math.min(Math.min(max*nums[i], min*nums[i]), nums[i]);
			
			globalMax = Math.max(globalMax, localMax);
		}
		
		return globalMax;
	}
}
