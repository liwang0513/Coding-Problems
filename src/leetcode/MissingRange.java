package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
	
	public static void main(String[] args) {
		System.out.println(missingRange(new int[]{0, 1, 3, 50, 75}));
	}
	
	static List<String> missingRange(int[] nums) {
		List<String> result = new ArrayList<String>();
		
		if (nums.length == 0) {
			result.add("0->99");
			return result;
		}
		
		// check 0
		if (nums[0] != 0) {
			result.add(nums[0] == 1 ? "0" : "0->"+(nums[0]-1));
		}
		
		for (int i=0; i<nums.length-1; i++) {
			if (nums[i] != nums[i+1]-1) {
				result.add(nums[i]+1 == nums[i+1]-1 ? String.valueOf(nums[i]+1) : (nums[i]+1)+"->"+(nums[i+1]-1));
			}
		}
		
		// check 99
		if (nums[nums.length-1] != 99) {
			result.add(nums[nums.length-1] == 98 ? "99" : (nums[nums.length-1]+1)+"->99");
		}
		
		return result;
	}
}
