package leetcode;

public class FindKthElementinTwoSortedArray {
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = {4,5,6};
		
		// 2
		
		System.out.println(find(a, b, 4));
	}
	
	static int find(int[] a, int[] b, int k) {
		return find(a, b, 0, a.length-1, 0, b.length-1, k);
	}
	
	static int find(int[] a, int[] b, int a1, int a2, int b1, int b2, int k) {
		int aLen = a2-a1+1;
		int bLen = b2-b1+1;
		
		if (aLen == 0) return b[b1+k];
		if (bLen == 0) return a[a1+k];
		if (k == 0) return a[a1] <= b[b1] ? a[a1] : b[b1];
		
		int ai = a1+k*aLen/(aLen+bLen);
		int bi = b1+k*bLen/(aLen+bLen);
		
		
		if (a[ai] < b[bi]) {
			return find(a, b, ai+1, a2, b1, bi, k-(ai-a1+1));
		} else {
			return find(a, b, a1, ai, bi+1, b2, k-(bi-b1+1));
		}
	}
}
