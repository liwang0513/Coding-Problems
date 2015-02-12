package leetcode;

public class ConstructBSTfromSortedList {
	
	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		ListNode p = list;
		for (int i=1; i<15; i++) {
			p.next = new ListNode(i+1);
			p = p.next;
		}
		
		convert(list).print();
	}

	static ListNode cur = null;
	
	static TreeNode convert(ListNode list) {
		if (list == null) return null;
		
		ListNode p = list;
		int count = 0;
		while (p != null) {
			count++;
			p = p.next;
		}
		
		cur  = list;
		
		return convertHelper(0, count-1);
	}
	
	static TreeNode convertHelper(int start, int end) {
		if (start > end) return null;
		
		int mid = (start+end)/2;
		TreeNode left = convertHelper(start, mid-1);

		TreeNode root = new TreeNode(cur.data);
		root.left = left;
		cur = cur.next;
		
		TreeNode right = convertHelper(mid+1, end);
		root.right = right;
		
		return root;
	}
}
