package leetcode;

public class CheckBinaryTreeBalance {

	static boolean isBalance(TreeNode root) {
		return maxDepth(root) != -1;
	}
	
	static int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int left = maxDepth(root.left);
		if (left == -1) return -1;
		int right = maxDepth(root.right);
		if (right == -1) return -1;
		
		return (Math.abs(right-left) <= 1) ? Math.max(right, left) : -1;
	}
}
