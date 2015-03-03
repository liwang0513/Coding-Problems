package leetcode;

import java.util.*;

public class LengthOfLongestSubstring {
	public enum Suit {
		CLUBS (1), SPADES (2), HEARTS (3), DIAMONDS (4); int value;
		private Suit(int v) { value = v; }
	};
	
	public static void main(String[] args) {
		//System.out.println(lengthOfLongestSubstring("pwwkew"));
		int[] A = {1, 2};
		int[] B = {1, 2};
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		
		
		
		System.out.println();
		Set<Set<Integer>> set = new HashSet<>();
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);set1.add(2);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(2);set2.add(1);
		set.add(set1); set.add(set2);
		
		System.out.println(new ArrayList<>(set));
	}
	
	static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        int left = 0;
        int right = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            
            if (set.contains(c)) {
                while (left < right && s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(c);
            }
            
            max = Math.max(max, right-left+1);
            right++;
        }
        
        return max;
    }
	
	
    static int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        int result = 0;
        
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            else {
                dividend += Math.abs(divisor);
                result++;
            }
        }
        
        boolean neg = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? false : true;
        dividend = Math.abs(dividend); divisor = Math.abs(divisor);
        int add = divisor;
        int factor = 1;
        
        
        
        while (dividend>>1 >= add) {
        	System.out.println(dividend + " "+ result);
            dividend -= add;
            result += factor;
            add <<= 1;
            factor <<= 1;
        }
        
        System.out.println(result);
        
        while (dividend >= divisor) {
            if (dividend-add < 0) {
                add >>= 1;
                factor >>= 1;
            } else {
                dividend -= add;
                result += factor;
            }
        } 
        
        return neg ? -result : result;
    }
}
