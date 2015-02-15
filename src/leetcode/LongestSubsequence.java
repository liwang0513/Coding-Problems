package leetcode;

import java.util.*;

public class LongestSubsequence {
	

	public static void main(String[] args) {
		//System.out.println(find("asdfgwadsfdasfgxvbasdfadsdsafasdfadsfdasf"));
		System.out.println();
	}
	
	static int find(String str) {
		int[] dp = new int[str.length()];
		Arrays.fill(dp, 1);	
		int max = 0;
		
		for (int i=0; i<dp.length; i++) {
			for (int j=0; j<i; j++) {
				if (str.charAt(j) < str.charAt(i)) 
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		for (int i=0; i<dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
}
