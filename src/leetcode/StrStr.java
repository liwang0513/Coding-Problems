package leetcode;

public class StrStr {
	
	public static void main(String[] args) {
		System.out.println(findMatch("aaaba", "ba"));
		
		
	}
	
	// this is a brute force method
	static int findMatch(String hayStack, String needle) {
		if (needle.length() == 0) return 0;
		if (hayStack.length() == 0 || hayStack.length() < needle.length()) return -1;
		
		for (int hIndex=0; ; hIndex++) {
			for (int nIndex=0; ; nIndex++) {
				if (nIndex == needle.length()) return hIndex;
				if (hIndex+nIndex == hayStack.length()) return -1;
				if (needle.charAt(nIndex) != hayStack.charAt(hIndex+nIndex)) break;
			}
		}
	}
}
