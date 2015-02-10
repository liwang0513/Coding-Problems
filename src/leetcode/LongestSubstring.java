package leetcode;

public class LongestSubstring {
	
	public static void main(String[] args) {
		System.out.println(longestSubstring("afasdfasdg", 3));
	}
	
	
	// find the longest substring with no more than N different characters
	static int longestSubstring(String str, int k) {
		char[] chars = str.toCharArray();
		
		int max = 0, left = 0, count = 0;
		int[] map = new int[256];
		
		for (int i=0; i<chars.length; i++) {
			if (map[chars[i]] == 0) count++;
			map[chars[i]]++;
			while (count > k) {
				map[chars[left]]--;
				if (map[chars[left]] == 0) count--;
				left++;
			}
			max = Math.max(i-left+1, max);
		}
		
		return max;
	}
}
