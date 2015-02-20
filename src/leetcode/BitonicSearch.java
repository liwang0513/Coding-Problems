package leetcode;

public class BitonicSearch {

	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 6, 9, 14, 11};
		//System.out.println(findMax(nums));
		
		System.out.println(find(nums, 1));
		
	}
	
	static int findMax(int[] nums) {
		if (nums.length == 0) throw new IllegalArgumentException("Empty Array!");
		
		int left = 0;
		int right = nums.length-1;
		
		while (left < right) {
			int mid = (left+right)/2;
			
			// case 1: if mid > left and mid > right, then we find
			int pre = mid == left ? Integer.MIN_VALUE : nums[mid-1];
			int next = nums[mid+1];
			
			if (nums[mid] > pre && nums[mid] > next) return nums[mid];
			else if (nums[mid] > pre && nums[mid] < next) left = mid+1;
			else right = mid-1;
		}
		
		return nums[left];
	}
	
	static int find(int[] nums, int n) {
		
		int left = 0;
		int right = nums.length-1;
		
		while (left < right) {
			int mid = (left+right)/2;
			
			int pre = mid == left ? Integer.MIN_VALUE : nums[mid-1];
			int next = nums[mid+1];
			
			System.out.println(nums[mid]);
			
			if (nums[mid] == n) return mid;
			else if (nums[mid] < n) {
				if (nums[mid] > pre && nums[mid] > next) {
					return -1;
				} else if (nums[mid] > pre && nums[mid] < next) {
					left = mid+1;
				} else {
					right = mid-1;
				}
			} else {
				return Math.max(binaryASD(nums, left, mid, n), binaryDESC(nums, mid, right, n));
			}
		}
		
		return nums[left];
	}
	
	static int binaryASD(int[] nums, int left, int right, int n) {
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (nums[mid] == n) return mid;
			else if (nums[mid] < n) left = mid+1;
			else right = mid-1;
		}
		
		return -1;
	}
	
	static int binaryDESC(int[] nums, int left, int right, int n) {
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (nums[mid] == n) return mid;
			else if (nums[mid] > n) left = mid+1;
			else right = mid-1;
		}
		
		return -1;
	}
}
