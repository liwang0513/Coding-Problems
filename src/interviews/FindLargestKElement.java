package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindLargestKElement {

	public static void main(String[] args) {
		Integer[] nums = {2, 10, 8, 6, 4, 5, 1, 3, 7, 9};
		
		Comparator<Integer> comparator = new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		};
		
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1, comparator);
		
		
		for (int i=0; i<4; i++) {
			heap.add(nums[i]);
		}
		
		for (int i=4; i<nums.length; i++) {
			if (nums[i] < heap.peek()) {
				heap.remove();
				heap.add(nums[i]);
			}
		}
		
		System.out.println(heap.toString());
		
		List<Integer> list = new ArrayList<Integer>();
		for (int e : nums) {
			list.add(e);
		}
		
		List<Integer> a = Arrays.asList(nums);
		Collections.sort(a, comparator);
		System.out.println(2^1);
		
	}
}
