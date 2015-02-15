package leetcode;

import java.util.*;

public class AllValidParentheses {
	
	public static void main(String[] args) {
		System.out.println(print(2));
	}
	
	static List<String> print(int n) {
		List<String> result = new ArrayList<String>();
		helper(n, n, result, "");
		return result;
	}
	
	static void helper(int left, int right, List<String> result, String temp) {
		if (left == 0 && right == 0) {
			result.add(temp);
			return;
		}
		
		if (left == 0 && right > 0) {
			while (right > 0) {
				temp += ")";
				right--;
			}
			helper(left, right, result, temp);
		} else if (left == right) {
			temp += "(";
			left--;
			helper(left, right, result, temp);
		} else {
			helper(left-1, right, result, temp+"(");
			helper(left, right-1, result, temp+")");
		}
		
		
	}

}
