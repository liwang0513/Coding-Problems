package leetcode;

public class SearchForInsearPos {

	public static void main(String[] args) {
		System.out.println(findPos(new int[]{1,3,5,6}, 0));
	}
	
	static int findPos(int[] nums, int target) {
		if (nums.length == 0) return 0;
		
		int left = 0;
		int right = nums.length-1;
		
		while (left < right) {
			int mid = (left+right)/2;
			if (nums[mid] >= target) right = mid-1;
			else left = mid+1;
		}
		
		return nums[left] >= target ? left : left+1;
	}
}
