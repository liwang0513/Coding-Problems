package leetcode;

import java.util.*;

public class WaysToSumMoney {
	
	enum Values {
		One(1), Five(5), Ten(10), TweentyFive(25);
		
		private int val;
		
		Values(int a) {
			this.val = a;
		}
		
		public int getVal() {
			return val;
		}
	}

	public static void main(String[] args) {
		System.out.println(print(16));
	}
	
	static List<String> print(int n) {
		List<String> result = new ArrayList<>();
		helper(0, result, n, "");
		return result;
	}
	
	static void helper(int sum, List<String> result, int n, String temp) {
		if (sum > n) return;
		if (sum == n) {
			result.add(temp);
			return;
		}
		
		for (Values e : Values.values()) {
			helper(sum+e.getVal(), result, n, temp+e.getVal()+" ");
		}
	}
}
