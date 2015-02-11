package leetcode;

public class IntegerPalindrome {

	
	public static void main(String[] args) {
		System.out.println(isPalindrome(010));
	}
	
	static boolean isPalindrome(int i) {
		
		if (i < 0) return false;
		if (i >= 0 && i < 10) return true;
		
		int count = 1;
		int temp = i;
		while (temp >= 10) {
			count *= 10;
			temp /= 10;
		}
		
		while (i != 0) {
			int left = i/count;
			int right = i%10;
			if (left != right) return false;
			i = i%count/10;
			count /= 100;
		}
		
		return true;
	}
}
