package leetcode;

public class FindStartOfCircleInList {

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = list.next;
		
		System.out.println(find(list));
	}
	
	static ListNode find(ListNode list) {
		ListNode dummy = new ListNode(0);
		dummy.next = list;
		ListNode p = dummy;
		
		ListNode one = p.next, two = p.next.next;

		while (one != two) {
			one = one.next;
			two = two.next.next;
		}
		
		two = p;
		while (one != two) {
			one = one.next;
			two = two.next;
		}
		
		return one;
	}
}
