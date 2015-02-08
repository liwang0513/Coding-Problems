package interviews;

import java.util.Arrays;

public class FIndMedianInFixSizeArray {
	
	public static void main(String[] args) {
		int[] nums = {2, 4, 1, 9, 7, 3, 6, 5, 8, 10};
		//System.out.println(findMid(nums));
		System.out.println(findMid(nums));
	}
	
	public static double findMid(int[] nums) {
		int len = nums.length;
		if (len % 2 == 0) {
			return (findKLargest(nums, len/2)+findKLargest(nums, len/2+1))/2.0;
		} else {
			return findKLargest(nums, 5);
		}
	}
	
	public static int findKLargest(int[] nums, int k) {
		return findKLargest(nums, 0, nums.length-1, k);
	}
	
	public static int findKLargest(int[] nums, int start, int end, int k) {
		if (k > end-start+1) throw new IllegalArgumentException("k is larger than array capacity.");
		
		int index = partition(nums, start, end);
		int rank = index-start+1;
		
		if (rank == k) return nums[index];
		else if (rank < k) {
			return findKLargest(nums, index+1, end, k-rank);
		} else {
			return findKLargest(nums, start, index-1, k);
		}
		
		
	}
	
	private static int partition(int[] nums, int start, int end) {
		
		int left = start;
		int right = end;
		int pivot = nums[right];
		
		while (left < right) {
			while (nums[left] < pivot) {
				left++;
			}
			while (nums[right] > pivot) {
				right--;
			}
			if (left < right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}
		}
		
		nums[left] = pivot;
		
		return left;
	}
}
