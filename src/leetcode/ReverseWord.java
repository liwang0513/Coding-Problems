package leetcode;

public class ReverseWord {
	
	public static void main(String[] args) {
		System.out.println(reverse("the sky    is blue"));
		System.out.println(reverseInPlace("the sky    is blue"));
	}
	
	static String reverse(String str) {
		if (str == null) return "";
		
		String[] strs = str.split("\\s+");
		
		int left = 0;
		int right = strs.length-1;
		
		while (left < right) {
			String temp = strs[left];
			strs[left] = strs[right];
			strs[right] = temp;
			left++;
			right--;
		}
		
		StringBuffer result = new StringBuffer();
		for (String e : strs) {
			result.append(e+" ");
		}
		
		return new String(result).trim();
	}
	
	static String reverseInPlace(String str) {
		char[] letters = str.toCharArray();
		helper(letters, 0, letters.length-1);
		
		int left = 0;
		int right = 0;
		while (right <= str.length()) {
			if (right == str.length() || letters[right] == ' ') {
				helper(letters, left, right-1);
				while (right < str.length() && letters[right] == ' ') right++;
				left = right;
			}
			right++;
		}
		
		return new String(letters);
	}
	
	static void helper(char[] str, int left, int right) {
		while (left < right) {
			char temp = str[left];
			str[left] = str[right];
			str[right] = temp;
			left++;
			right--;
		}
	}
}
