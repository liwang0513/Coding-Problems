package leetcode;

import java.util.*;

public class MinimumDepth {

	static int minDFS(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null) return minDFS(root.right)+1;
		if (root.right == null) return minDFS(root.left)+1;
		
		return Math.min(minDFS(root.left), minDFS(root.right))+1;
	}
	
	static int minBFS(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int depth = 1;
		TreeNode rightMost = root;
		
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left == null && node.right == null) break;
			if (node.left != null) q.add(node.left);
			if (node.right != null) q.add(node.right);
			if (node == rightMost) {
				rightMost = node.right != null ? node.right : node.left;
				depth++;
			}
		}
		
		return depth;
	}
}
