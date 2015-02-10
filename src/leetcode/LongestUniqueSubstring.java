package leetcode;

import java.util.Arrays;

public class LongestUniqueSubstring {

	public static void main(String[] args) {
		System.out.println(findMaxLenWithTwoIteration("asdfabsergaegr"));
	}
	
	static int findMaxLenWithTwoIteration(String str) {
		
		int max = 0, left = 0;
		boolean[] exist = new boolean[256];
		
		for (int i=0; i<str.length(); i++) {
			while (exist[str.charAt(i)]) {
				exist[str.charAt(left)] = false;
				left++;
			}
			exist[str.charAt(i)] = true;
			max = Math.max(i-left+1, max);
		}
		
		return max;
	}
	
	static int findMaxLenWithOneIteration(String str) {
		
		int max = 0, left = 0;
		int[] map = new int[256];
		Arrays.fill(map, -1);
		
		for (int i=0; i<str.length(); i++) {
			if (map[str.charAt(i)] >= left) {
				left = map[str.charAt(i)];
			}
			map[str.charAt(i)] = i;
			max = Math.max(i-left, max);
		}
		
		return max;
	}
}
