package leetcode;

public class FindSmallestInSortedRotatedArray {

	public static void main(String[] args) {
		
	}
	
	static int find(int[] nums) {
		int left = 0, right = nums.length-1;
		
		while (left < right && nums[left] > nums[right]) {
			int mid = (left+right)/2;
			if (nums[mid] > nums[left]) left = mid+1;
			else right = mid;
		}
		
		return nums[left];
	}
}
