package leetcode;

import java.util.*;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		
	}
	
	static ListNode merge(ListNode list1, ListNode list2) {
		
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		
		ListNode p1 = list1;
		ListNode p2 = list2;
		
		while (p1 != null && p2 != null) {
			if (p1.data > p2.data) {
				p.next = p2;
				p2 = p2.next;
			} else {
				p.next = p1;
				p1 = p1.next;
			}
			p = p.next;
		}
		
		p.next = p1 == null ? p2 : p1;
		
		return dummy.next;
	}
}
