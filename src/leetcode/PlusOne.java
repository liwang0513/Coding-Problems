package leetcode;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[]{9,8,9})));
		System.out.println(Integer.MAX_VALUE);
	}
	
	static int[] plusOne(int[] num) {
		
		int[] temp = Arrays.copyOf(num, num.length);
		
		if (temp[temp.length-1] == 9) {
			int index = temp.length-1;
			while (index >= 0 && temp[index] == 9) {
				temp[index] = 0;
				index--;
			}
			if (index >= 0) {
				temp[index]++;
			} else {
				temp = new int[temp.length+1];
				temp[0] = 1;
			}
		} else {
			temp[temp.length-1]++;
		}
		
		return temp;
	}
}
