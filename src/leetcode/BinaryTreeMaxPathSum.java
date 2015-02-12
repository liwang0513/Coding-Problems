package leetcode;

public class BinaryTreeMaxPathSum {

	static int max;
	
	static int maxPathSum(TreeNode root) {
		maxPathSumHelper(root);
		return max;
	}
	
	static int maxPathSumHelper(TreeNode root) {
		if (root == null) return 0;
		
		int left = maxPathSumHelper(root.left);
		int right = maxPathSumHelper(root.right);
		
		max = Math.max(max, root.data+left+right);
		
		int branch = Math.max(left, right)+root.data;
		
		return branch <= 0 ? 0 : branch;	
	}
}
