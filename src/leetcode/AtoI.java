package leetcode;

public class AtoI {
	
	public static void main(String[] args) {
		System.out.println(covert("adsfadg ++12495423643262354asdfadsf"));
		
	}
	
	static int covert(String str) {
		
		// ie. ssssss[-+]d*sssss
		int left = 0;
		
		while (left < str.length()) {
			char c = str.charAt(left);
			if (Character.isDigit(c)) break;
			left++;
		}
		
		int right = left+1;
		while (right < str.length()) {
			char c = str.charAt(right);
			if (!Character.isDigit(c)) break;
			right++;
		}
		
		String sub = str.substring(left, right);
		
		boolean neg = false;
		if (left > 0 && str.charAt(left-1) == '-') neg = true;
		int maxDiv10 = Integer.MAX_VALUE/10;
		int maxDigit = Integer.MAX_VALUE%10;
		
		int result = 0;
		for (int i=0; i < sub.length() ; i++) {
			int digit = sub.charAt(i)-'0';
			
			if (result > maxDiv10 || result == maxDiv10 && digit >= maxDigit)
				return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			
			result = result*10 + digit;
		}
		
		return neg ? -1*result : result;
	}
}
