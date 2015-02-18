package leetcode;

import java.util.*;

public class GrayCode {
	
	public static void main(String[] args) {
		System.out.println(gray(3));
	}
	
	static List<Integer> gray(int n) {
		
		List<Integer> result = new ArrayList<>();
		
		result.add(0);
		// start from n = 1 
		for (int i=1; i<=n; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			int add = 1 << i-1;
			for (Integer e : result) {
				temp.add(e+add);
			}
			Collections.reverse(temp);
			result.addAll(temp);
		}
		
		return result;
	}

}
