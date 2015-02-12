package leetcode;

public class BinaryTreeUpsideDown {

	public static void main(String[] args) {

	}
	
	static TreeNode upsideDown(TreeNode root) {
		return upsideDown(root, null);
	}
	
	static TreeNode upsideDown(TreeNode p, TreeNode parent) {
		if (p == null) return parent;
		
		TreeNode root = upsideDown(p.left, p);
		p.left = parent == null ? parent : parent.right;
		p.right = parent;
		
		return root;
	}
}
