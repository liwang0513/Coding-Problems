package leetcode;

public class SqrlRoot {

	
	public static void main(String[] args) {
		System.out.println(sqrt(9));
	}
	
	static int sqrt(int num) {
		if (num <= 0) throw new IllegalArgumentException();
		
		if (num == 1) return 1;
		
		// the result must located between (0, num/2+1)
		// use binary search to find the result
		int left = 0;
		int right = num/2+1;
		
		while (left+1 < right) {
			int mid = (left + right)/2;
			if (mid * mid == num) return mid;
			else if (mid * mid < num) left = mid;
			else right = mid;
		}
		
		return left;
	}
}
