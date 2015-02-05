package interviews;

import java.util.Arrays;

public class SpiralPrint {
	
	public static void main(String[] args) {
		SpiralPrint sp = new SpiralPrint();
		
		sp.print(6);
	}
	
	public void print(int n) {
		String[][] result = new String[n][n];
		
		for (int i=0; i<n/2; i++) {
			// top
			for (int col=i; col<n-i-1; col++) {
				result[i][col] = "T";
			}
			
			// right
			for (int row=i; row<n-i-1; row++) {
				result[row][n-i-1] = "R";
			}
			
			// bottom
			for (int col=n-i-1; col>i; col--) {
				result[n-i-1][col] = "B";
			}
			
			// left
			for (int row=n-i-1; row>i; row--) {
				result[row][i] = "L";
			}
		}
		
		if (n%2 != 0) {
			result[n/2][n/2] = "C";
		}
		
		for (String[] line : result) {
			System.out.println(Arrays.toString(line));
		}
		
	}
}
