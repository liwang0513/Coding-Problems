package leetcode;

public class PrefixTree {
	Node root;
	
	public PrefixTree() {
		root = new Node('s');
	}
	

	public static void main(String[] args) {
		PrefixTree t = new PrefixTree();
		t.print(t.root, 0);
		t.insert("101");
		t.insert("111");
		t.insert("0101");
		t.insert("000");
		t.insert("0001");
		t.insert("10101");
		t.insert("100011");
		t.print(t.root, 0);
	}
	
	public void insert(String str) {
		if (str.length() == 0) return;
		
		Node p = root;
		
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (p.left != null && p.left.val == c) {
				p = p.left;
			} else if (p.right != null && p.right.val == c) {
				p = p.right;
			} else {
				if (c == '0') {
					p.left = new Node('0');
					p = p.left;
				} else {
					p.right = new Node('1');
					p = p.right;
				}
			}
			
			if (i == str.length()-1) p.terminate = true;
		}
		
	}
	
	public void print(Node root, int indent) {
		if (root == null) return;
		
		String prefix = "";
		for (int i=0; i<indent; i++) {
			prefix += " ";
		}
		System.out.println(prefix+root.val+root.terminate);
		
		indent += 2;
		if (root.left != null) print(root.left, indent);
		if (root.right != null) print(root.right, indent);
	}
	
	
	class Node {
		char val;
		Node left;
		Node right;
		boolean terminate = false;
		
		public Node(char val) {
			this.val = val;
		}
	}
}
