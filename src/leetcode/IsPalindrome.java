package leetcode;

public class IsPalindrome {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	static boolean isPalindrome(String str) {
		if (str.length() == 0) return true;
		
		int left = 0;
		int right = str.length()-1;
		
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(str.charAt(left))) left++;
			while (left < right && !Character.isLetterOrDigit(str.charAt(right))) right--;
			if (left < right) {
				if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
					return false;
				}
			}
			left++;
			right--;
		}
		
		return true;
	}
}
