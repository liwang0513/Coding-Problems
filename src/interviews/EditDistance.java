package interviews;

import java.util.Arrays;

public class EditDistance {
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		System.out.println(ed.distance("trials", "Zeil"));
		
	}
	
	public int distance(String str1, String str2) {
		int[][] dp = new int[str2.length()+1][str1.length()+1];
		
		for (int i=0; i<str1.length()+1; i++) {
			dp[0][i] = i;
		}
		
		for (int i=0; i<str2.length()+1; i++) {
			dp[i][0] = i;
		}
		
		for (int row=1; row<str2.length()+1; row++) {
			for (int col=1; col<str1.length()+1; col++) {
				if (str2.charAt(row-1) == str1.charAt(col-1)) {
					dp[row][col] = dp[row-1][col-1];
				} else {
					dp[row][col] = Math.min(dp[row-1][col-1], Math.min(dp[row][col-1], dp[row-1][col]))+1;
				}
			}
		}
		
		for (int[] line : dp) {
			System.out.println(Arrays.toString(line));
		}
		
		return dp[str2.length()][str1.length()];
	}
	
	
	
}
