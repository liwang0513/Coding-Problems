package leetcode;

public class IsNumber {
	
	public static void main(String[] args) {
		System.out.println(isNumber("+913"));
		System.out.println(isNumber("   .913"));
		System.out.println(isNumber("  +9.13  "));
		
	}
	
	static boolean regMatch(String str) {
		return str.matches("\\s*[+-]?\\d*.?\\d+\\s*");
	}
	
	
	static boolean isNumber(String str) {
		str = str.trim();
		
		if (str.charAt(0) == '+' || str.charAt(0) == '-') str = str.substring(1);
		
		int i = 0;
		boolean isNumber = false;
		
		while (i<str.length() && Character.isDigit(str.charAt(i))) {
			i++;
			isNumber = true;
		}
		
		if (i<str.length() && str.charAt(i) == '.') {
			i++;
			while (i<str.length() && Character.isDigit(str.charAt(i))) {
				i++;
				isNumber = true;
			}
		}
		
		return isNumber && i == str.length();
	}
}
