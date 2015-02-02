package two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	Map<Integer, Integer> map;
	
	public TwoSum() {
		
		map = new HashMap<Integer, Integer>();
	}
	
	public void add(int num) {
		if (map.containsKey(num)) {
			map.put(num, map.get(num)+1);
		} else {
			map.put(num, 1);
		}	
	}
	
	public boolean find(int target) {
		
		for (Integer first : map.keySet()) {
			
			int second = target - first;
			
			if (first == second && map.get(first) >= 2) {
				return true;
			} 
			
			if (map.containsKey(second)) {
				return true;
			}
		}
		
		return false;
	}

}