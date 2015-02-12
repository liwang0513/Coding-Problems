package leetcode;

public class ValidBST {

	static Integer pre = null;
	
	static boolean isBST(TreeNode root) {
		if (root == null) return true;
		
		boolean left = isBST(root.left);
		if (left) {
			if (pre != null && root.data <= pre) return false;
			pre = root.data;
			return isBST(root.right);
		}
		
		return false;
	}
}
