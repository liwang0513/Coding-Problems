package leetcode;


public class RemoveDuplicate {

	public static void main(String[] args) {
		System.out.println(remove(new int[]{1,1,1,2,2,3}));
	}
	
	static int remove(int[] nums) {
		if (nums.length == 0) return 0;
		
		// create two pointer, one to track, one to store
		int cur = 0;
		int left = -1;
		int count = 0;
		
		while (cur < nums.length) {
			// if same as pre
			if (cur > 0 && nums[cur] == nums[cur-1]) {
				if (count == 2) {
					count = 0;
					while (cur < nums.length && nums[cur+1] == nums[cur]) cur++;
				}
				// else  put it in the array
				else {
					nums[++left] = nums[cur];
					count++;
				}
			}
			// diffrent
			else {
				count = 1;
				nums[++left] = nums[cur];
			}
			cur++;
		}
		
		return left+1;
	}
}
