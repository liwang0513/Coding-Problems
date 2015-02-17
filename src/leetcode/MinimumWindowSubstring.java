package leetcode;

import java.util.*;

public class MinimumWindowSubstring {

	
	public static void main(String[] args) {
		String str = "ADOBECODEBANC";
		String pattern = "ABC";
		System.out.println(find(str, pattern));
	}
	
	static String find(String s, String p) {
		// create a hashmap to store the pattern
		Map<Character, Integer> map = new HashMap<>();
		for (int i=0; i<p.length(); i++) {
			map.put(p.charAt(i), 1);
		}
		
		// some variables
		int min = Integer.MAX_VALUE;
		String result = "";
		
		// count the valid character
		int count = 0;
		
		// record the left pointer
		int left = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			// if useless letter, ignore it
			if (!map.containsKey(c)) continue;
			// else remove it in the map
			map.put(c, map.get(c)-1);
			
			// check if the letter is valid
			if (map.get(c) >= 0) count++;
			
			if (count == p.length()) {
				// start trim
				while (true) {
					char m = s.charAt(left);
					
					if (!map.containsKey(m)) {
						left++;
					} else {
						map.put(m, map.get(m)+1);
						if (map.get(m) > 0) {
							break;
						}
						left++;
					}
				}
				
				// we found a valid letter
				if (i-left+1 < min) {
					min = i-left+1;
					result = s.substring(left, i+1);
				}
				
				count--;
				left++;
			}
		}
		
		return result;
	}
}
