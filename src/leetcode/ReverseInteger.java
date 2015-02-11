package leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		
	}
	
	static int reverse(int num) {
		
		boolean neg = num < 0 ? true : false;
		num = Math.abs(num);
		
		int result = 0;
		int maxLeft = Integer.MAX_VALUE/10;
		int maxRight = neg ? Integer.MIN_VALUE%10 : Integer.MAX_VALUE%10;
		while (num != 0) {
			int right = num%10;
			if (result > maxLeft || result == maxLeft && right >= maxRight) return 0;
			result = result*10 + right;
			num /= 10;
		}
		
		return neg ? -result : result;
	}
}
