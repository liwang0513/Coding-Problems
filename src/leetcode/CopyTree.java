package leetcode;

public class CopyTree {

	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode root = ConstructBSTfromSortedArray.convert(nums);
		
		root.print();
		copy(root, null).print();
	}
	
	static TreeNode copy(TreeNode p1, TreeNode p2) {
		if (p1 == null) return null;
		
		p2 = new TreeNode(p1.data);
		TreeNode left = copy(p1.left, p2.left);
		
		TreeNode right = copy(p1.right, p2.right);
		p2.right = right;
		p2.left = left;
		
		return p2;
	}
}
