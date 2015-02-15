package leetcode;

public class FindSmallestInSortedRotatedArray {

	public static void main(String[] args) {
		
		try {
			System.out.println(1<<-1);
			System.out.println(Integer.toBinaryString(1>>1));
			return;
		} catch(Exception e) {
			throw e;
		} finally {
			System.out.println("hello");
		}
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
