package leetcode;

public class ListNode {
	
	public int data;
	public ListNode next;
	public ListNode random;

	public ListNode(int data) {
		this.data = data;
	}
	
	public String toString() {
		return String.valueOf(data);
	}
	
	public void print() {
		ListNode p = this;
		while (p != null) {
			System.out.print(p + " ");
			p = p.next;
		}
	}
}
