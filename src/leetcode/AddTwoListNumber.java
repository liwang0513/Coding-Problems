package leetcode;

public class AddTwoListNumber {

	public static void main(String[] args) {
		// 2 -> 4 -> 3
		ListNode list1 = new ListNode(2);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(5);
		
		// 5 -> 6 -> 4
		ListNode list2 = new ListNode(5);
		list2.next = new ListNode(6);
		list2.next.next = new ListNode(5);
		
		add(list1, list2).print();
	}
	
	static ListNode add(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
		
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		int one = 0;
		
		while (list1 != null || list2 != null) {
			int left = list1 == null ? 0 : list1.data;
			int right = list2 == null ? 0 : list2.data;
			int sum = right+left+one;
			p.next = new ListNode(sum%10);
			one = sum >= 10 ? 1 : 0;
			p = p.next; list1 = list1.next; list2 = list2.next;
		}
		
		if (one == 1) {
			p.next = new ListNode(1);
		}
		
		return dummy.next;
	}
}
