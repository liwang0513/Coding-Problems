package leetcode;

public class CopyWithRandomPointer {

	static ListNode copy(ListNode list) {
		ListNode p = list;
		
		while (p != null) {
			ListNode newNode = new ListNode(p.data);
			newNode.next = p.next;
			p.next = newNode;
			p = p.next.next;
		}
		
		p = list;
		while (p != null) {
			p.next.random = p.random == null ? null : p.random.next;
			p = p.next.next;
		}
		
		p = list;
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		
		while (p != null) {
			temp.next = p.next;
			p.next = p.next.next;
			
			temp = temp.next;
			p = p.next;
		}
		
		return dummy.next;
	}
}
