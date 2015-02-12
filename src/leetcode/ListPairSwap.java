package leetcode;

public class ListPairSwap {

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.print();
		swapPair(list).print();
	}
	
	static ListNode swapPair(ListNode list) {
		ListNode dummy = new ListNode(0);
		dummy.next = list;
		ListNode p = dummy;
		
		while (p.next != null && p.next.next != null) {
			ListNode first = p.next;
			ListNode second = p.next.next;
			ListNode tail = second.next;
			
			p.next = second;
			second.next = first;
			first.next = tail;
			p = first;
		}
		
		return dummy.next;
	}
}
