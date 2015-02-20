package leetcode;

public class MorrisTreeTraversal {

	public static void main(String[] args) {
		
	}
	
	static void morris(TreeNode root) {
		TreeNode cur = root;
		TreeNode pre = null;
		
		// 1. detect set the previous node link to current node
		
		while (cur != null) {
			if (cur.left == null) {
				// we should print
				System.out.println(cur.data);
				cur = cur.right;
			} else {
				pre = cur.left;
				
				// find the pre node
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				
				if (pre.right == null) {
					//set the link
					pre.right = cur;
					cur = cur.left;
				} else {
					//delete the link
					pre.right = null;
					System.out.println(cur.data);
					cur = cur.right;
				}
			}
			
		}
		
	}
}
