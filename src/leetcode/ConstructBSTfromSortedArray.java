package leetcode;

public class ConstructBSTfromSortedArray {
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		convert(nums).print();
	}

	static TreeNode convert(int[] nums) {
		return convertHelper(nums, 0, nums.length-1);
	}
	
	static TreeNode convertHelper(int[] nums, int start, int end) {
		if (start > end) return null;
		if (start == end) return new TreeNode(nums[start]);
		
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(nums[mid]);
		TreeNode left = convertHelper(nums, start, mid-1);
		TreeNode right = convertHelper(nums, mid+1, end);
		
		root.left = left;
		root.right = right;
		
		return root;
	}
}
