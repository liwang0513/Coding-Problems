package leetcode;

import java.util.*;

public class TreeNode {

	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int n) {
		data = n;
	}
	
	public void print() {
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(this);
		TreeNode rightMost = this;
		
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp.left != null) q.add(temp.left);
			if (temp.right != null) q.add(temp.right);
			System.out.println(temp.data+" ");
			if (temp == rightMost) {
				System.out.println();
				rightMost = temp.right == null ? temp.left : temp.right;
			}
		}
		
	}
}
