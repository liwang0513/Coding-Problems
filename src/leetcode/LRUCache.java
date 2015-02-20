package leetcode;

import java.util.*;

public class LRUCache {

	// 1. use hashtable to store all the key-value pair, so the access time is O(1)
	// 2. use doubled linked list to represent the cache: two pointers - head and tail
	// so that remove and insert operation are all O(1)
	
	int capacity;
	Map<Integer, Node> map;
	Node cache;
	Node tail;
	int size;
	
	
	public LRUCache(int n) {
		capacity = n;
		map = new HashMap<>();
		size = 0;
	}
	
	public int get(int key) {
		Node candidate = map.get(key);
		// put it into the head of cache
		if (candidate.pre != null) {
			candidate.pre.next = candidate.next;
			candidate.next = cache;
			cache = candidate;
		}
		return candidate.val;
	}
	
	public void insert(int key, int val) {
		map.put(key, new Node(val));
		Node newNode = map.get(key);
		
		// if cache has nothing, initiate
		if (cache == null) {
			cache = newNode;
			tail = newNode;
		} else {
			newNode.next = cache;
			cache = newNode;
			tail = tail.next;
		}
		size++;
		
		if (size > capacity) {
			tail = tail.pre;
			tail.next = tail.next.next;
		}
	}
	
	class Node {
		public int val;
		public Node next;
		public Node pre;
		
		public Node(int val) {
			this.val = val;
		}
	}
}
