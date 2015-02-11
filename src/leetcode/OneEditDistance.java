package leetcode;

import java.util.Arrays;

public class OneEditDistance {

	public static void main(String[] args) {
		System.out.println(oneEditDistance("acc", "ab"));
		System.out.println(countEditDistance("acc", "ab"));
		System.out.println(longestCommonSequence("accb", "acb"));
	}
	
	static boolean oneEditDistance(String str1, String str2) {
		
		// assume m <= n
		int m = str1.length();
		int n = str2.length();
		
		if (m > n) return oneEditDistance(str2, str1);
		if (n - m >= 2) return false;
		
		int i=0; int shift = n-m;
		
		// case 1: "aaa" "aaa"
		while (i < m) {
			if (str1.charAt(i) != str2.charAt(i)) break;
			i++;
		}
		// case 2: "aaa" "aaab"
		if (i == m) return m < n;
		
		// case 3: "aaa" "aaba"
		while (i < m) {
			if (str1.charAt(i) != str2.charAt(i+shift)) return false;
			i++;
		}
		
		return true;
	}
	
	static int countEditDistance(String str1, String str2) {
		
		// "abe" "aed"
		int m = str1.length();
		int n = str2.length();
		
		if (m == 0 || n == 0) return Math.abs(m-n);
		
		int[][] map = new int[m+1][n+1];
		
		for (int i=0; i<m+1; i++) {
			map[i][0] = i;
		}
		for (int i=0; i<n+1; i++) {
			map[0][i] = i;
		}
		
		for (int i=1; i<m+1; i++) {
			for (int j=1; j<n+1; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					map[i][j] = map[i-1][j-1];
				} else {
					// insertion
					int insert = map[i-1][j]+1;
					// deletion
					int delete = map[i][j-1]+1;
					// replace
					int replace = map[i-1][j-1]+1;
					
					map[i][j] = Math.min(insert, Math.min(delete, replace));
				}
			}
		}
		
		return map[m][n];
	}
	
	static String longestCommonSequence(String str1, String str2) {
		
		int m = str1.length();
		int n = str2.length();
		
		if (m == 0 || n == 0) return "";
		
		String[][] map = new String[m+1][n+1];
		for (String[] line : map) {
			Arrays.fill(line, "");
		}
		
		for (int i=1; i<m+1; i++) {
			for (int j=1; j<n+1; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					map[i][j] = map[i-1][j-1]+String.valueOf(str1.charAt(i-1));
				} else {
					map[i][j] = map[i-1][j].length() > map[i][j-1].length() ? map[i-1][j] : map[i][j-1];
				}
			}
		}
		
		return map[m][n];
	}
}
