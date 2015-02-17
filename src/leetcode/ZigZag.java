package leetcode;

public class ZigZag {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING"));
	}
	
	static String convert(String str) {
		
		StringBuffer line1 = new StringBuffer();
		StringBuffer line2 = new StringBuffer();
		StringBuffer line3 = new StringBuffer();
		
		for (int i=0; i<str.length(); i++) {
			if (i%4 == 0) line1.append(str.charAt(i));
			if (i%4 == 1 || i%4 == 3) line2.append(str.charAt(i));
			if (i%4 == 2) line3.append(str.charAt(i));
		}
		
		line1.append(line2).append(line3);
		
		return new String(line1);
	}
}
