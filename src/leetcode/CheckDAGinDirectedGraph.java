package leetcode;

import java.util.*;

public class CheckDAGinDirectedGraph {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		System.out.println(g.isDAG());
	}

	
}

class Graph {
	public Map<Integer, Node> nodes;
	
	public Graph() {
		nodes = new HashMap<>();
	}
	
	// a -> b
	public void addEdge(int a, int b) {
		if (!nodes.containsKey(a)) {
			nodes.put(a, new Node(a));
		}
		if (!nodes.containsKey(b)) {
			nodes.put(b, new Node(b));
		}
		
		nodes.get(a).children.add(nodes.get(b));
	}
	
	public boolean isDAG() {
		Set<Integer> visited = new HashSet<>();
		for (int e : nodes.keySet()) {
			if (isDAGhelper(e, new HashSet<Integer>(), visited)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isDAGhelper(int e, Set<Integer> stack, Set<Integer> visited) {
		if (stack.contains(e)) return true;
		if (visited.contains(e)) return false;
		
		stack.add(e); visited.add(e);
		for (Node n : nodes.get(e).children) {
			if (isDAGhelper(n.val, new HashSet<Integer>(stack), visited))
				return true;
		}
		
		return false;
	}
	
}

class Node {
	int val;
	List<Node> children;
	
	public Node(int val) {
		this.val = val;
		children = new ArrayList<>();
	}
	
}
