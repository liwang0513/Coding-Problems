package leetcode;

public class LargestSubstringPalindrome {
	
	public static void main(String[] args) {
		System.out.println(maxPalindrome2("aba"));
	}
	
	static String maxPalindrome(String str) {
		if (str.length() == 0) return "";
		
		boolean[][] map = new boolean[str.length()][str.length()];
		int max = 1;
		String result = str.substring(0, 1);
		
		// initiate the map
		for (int i=0; i<str.length(); i++) {
			map[i][i] = true;
		}
		for (int i=0; i<str.length()-1; i++) {
			map[i][i+1] = str.charAt(i) == str.charAt(i+1);
			if (map[i][i+1]) {
				max = 2;
				result = str.substring(i, i+2);
			}
		}
		
		for (int len=3; len<=str.length(); len++) {
			for (int i=0; i<str.length()-len+1; i++) {
				int left = i;
				int right = i+len-1;
				map[left][right] = str.charAt(left) == str.charAt(right) && map[left+1][right-1];
				if (map[left][right] && len > max) {
					max = len;
					result = str.substring(left, right+1);
				}
			}
		}
		
		return result;
	}
	
	static String maxPalindrome2(String str) {
		
		if (str.length() == 0) return "";
		
		int len = str.length();
		int max = 1;
		String result = str.substring(0,1);
		
		// odd palindrome
		for (int i=0; i<2*len-1; i=i+2) {
			int left = i/2-1, right = i/2+1;
			while (left >= 0 && right < len) {
				if (str.charAt(left) == str.charAt(right)) {
					if (right-left+1 > max) {
						max = right-left+1;
						result = str.substring(left, right+1);
					}
				} else {
					break;
				}
				left--;
				right++;
			}
		}
		
		// even palindrome
		for (int i=1; i<2*len-1; i=i+2) {
			int left = i/2, right = i/2+1;
			while (left >= 0 && right < len) {
				if (str.charAt(left) == str.charAt(right)) {
					if (right-left+1 > max) {
						max = right-left+1;
						result = str.substring(left, right+1);
					}
				} else {
					break;
				}
				left--;
				right++;
			}
		}
		
		return result;
	}
}
