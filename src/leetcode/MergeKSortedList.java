package leetcode;

import java.util.*;

public class MergeKSortedList {

	public static void main(String[] args) {
		
	}
	
	static ListNode merge(List<ListNode> lists) {
		ListNode result = new ListNode(0);
		ListNode p = result;
		
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.data-l2.data;
			}
		};
		
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
		for (ListNode e : lists) {
			if (e != null) heap.add(e);
		}
		
		while (!heap.isEmpty()) {
			ListNode node = heap.poll();
			p.next = node;
			p = p.next;
			
			if (node.next != null) {
				heap.add(node.next);
			}
		}
		
		return result.next;
	}
	
	static ListNode recursive(List<ListNode> lists, int start, int end) {
		if (lists.isEmpty()) return null;
		if (start == end) return lists.get(start);
		
		ListNode left = recursive(lists, start, (start+end)/2);
		ListNode right = recursive(lists, (start+end)/2+1, end);
		
		return null;// merge2sortedList(left, right);
	}
}
