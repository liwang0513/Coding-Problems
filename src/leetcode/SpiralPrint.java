package leetcode;

import java.util.*;

public class SpiralPrint {
	
	static List<Integer> print(int[][] matrix) {
		
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
		
		int m = matrix.length, n = matrix[0].length;
		int row = 0, col = -1;
		
		while(true) {
			// top row
			for (int i=0; i<n; i++) {
				result.add(matrix[row][++col]);
			}
			if (--m == 0) break;
			
			// right col
			for (int i=0; i<m; i++) {
				result.add(matrix[++row][col]);
			}
			if (--n == 0) break;
			
			// bottom row
			for (int i=0; i<n; i++) {
				result.add(matrix[row][--col]);
			}
			if (--m == 0) break;
			
			// lef col
			for (int i=0; i<m; i++) {
				result.add(matrix[--row][col]);
			}
			if (--n == 0) break;
		}
		
		return result;
	}
}
