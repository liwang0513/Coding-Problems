package leetcode;

import java.util.*;

public class WordLadder {
	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		Set<String> set = new HashSet<>();
		set.add("hot");set.add("dot");set.add("dog");set.add("lot");set.add("log");
		System.out.println(w.findLadders("hit", "cog", set));
	}
	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        if (dict.isEmpty()) return result;
        
        dict.add(start);
        dict.add(end);
        
        Map<String, Set<String>> map = convert(dict);
        
        
        result = bfs(start, end, map, new HashSet<String>());	
        
        
        // we use BFS found the min level
        
        // we start use DFS to find all possible path
      
        return result;
    }
    
    public Map<String, Set<String>> convert(Set<String> dict) {
    	Map<String, Set<String>> map = new HashMap<>();
    	
    	for (String e : dict) {
    		Set<String> temp = new HashSet<>();
    		for (int i=0; i<e.length(); i++) {
    			for (char c='a'; c<='z'; c++) {
    				if (e.charAt(i) != c) {
    					char[] letters = e.toCharArray();
    					letters[i] = c;
    					String newWord = new String(letters);
    					
    					if (dict.contains(newWord)) temp.add(newWord);
    				}
    			}
    		}
    		map.put(e, temp);
    	}
    	
    	return map;
    }
    
    public List<List<String>> bfs(String start, String end, Map<String, Set<String>> map, Set<String> visited) {
        LinkedList<Node> wordQueue = new LinkedList<Node>();
        int len = 1;
 
        Node root = new Node(start);
        wordQueue.add(root);
        visited.add(start);
        
        List<List<String>> result = new ArrayList<>();
        
        boolean found = false;
 
        while(!wordQueue.isEmpty() && !found){
        	//System.out.println(wordQueue);
            int size = wordQueue.size();
            List<String> newVisited = new ArrayList<String>();
            
            for (int n=0; n<size; n++) {
                Node cur = wordQueue.pop();
            
                if (cur.val.equals(end)) {
                	found = true;
                	addToList(cur, result);
                }
                Set<String> candidates = map.get(cur.val);
                for (String e : candidates) {
                	if (!visited.contains(e)) {
                		Node newNode = new Node(e);
                		wordQueue.add(newNode);
                		newNode.parent = cur;
                		newVisited.add(e);
                	}
                }
            }
            visited.addAll(newVisited);
            len++;
        }
        
        return result;
    }
    
    public void addToList(Node node, List<List<String>> result) {
    	List<String> temp = new ArrayList<>();
    	
    	while (node != null) {
    		temp.add(0, node.val);
    		node = node.parent;
    	}
    	
    	result.add(temp);
    }
    
    class Node {
    	public String val;
    	public Node parent;
    	
    	public Node(String val) {
    		this.val = val;
    	}
    	
    	public String toString() {
    		return val;
    	}
    }
}
