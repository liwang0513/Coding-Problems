package leetcode;

import java.util.*;

public class RomanToInteger {

	static Map<Character, Integer> map = new HashMap<Character, Integer>() {
		{put('I', 1); put('V', 5); put('X', 10); put('L', 50); put('C', 100);
		put('D', 500); put('M', 1000);}
	};
	
	public static void main(String[] args) {
		System.out.println(convert("MXCVI"));
	}
	
	static int convert(String str) {
		char[] letters = str.toCharArray();
		int result = 0;
		
		for (int i=0; i<letters.length; i++) {
			result += map.get(letters[i]);
			if (i > 0 && map.get(letters[i]) > map.get(letters[i-1]))
				result -= 2*map.get(letters[i-1]);
		}
		
		return result;
	}
}
