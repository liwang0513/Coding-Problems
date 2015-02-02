package interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class DistributedBackUp {
	
	public static void main(String[] args) {
		DistributedBackUp db = new DistributedBackUp();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(db.backup(input));
		
	}
	
	public String backup(Scanner input) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		int numOfDataCenter, numOfDataSet, id;
		
		// record the # of data center
		numOfDataCenter = input.nextInt();
		
		// record the (data-set id, data-center id) in the map
		for (int idOfDataCenter=1; idOfDataCenter<=numOfDataCenter; idOfDataCenter++) {
			numOfDataSet = input.nextInt();
			System.out.println(numOfDataSet);
			for (int i=0; i<numOfDataSet; i++) {
				id = input.nextInt();
				
				if (map.containsKey(id)) {
					map.get(id).add(idOfDataCenter);
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(idOfDataCenter);
					map.put(id, list);
				}
 			}
		}
		
		// back up the information from the map
		StringBuffer result = new StringBuffer();
		for (Entry<Integer, List<Integer>> e : map.entrySet()) {
			int key = e.getKey();
			List<Integer> value = e.getValue();
			
			for (int i=1; i<=numOfDataCenter; i++) {
				if (!value.contains(i)) {
					result.append(key+" "+value.get(0)+" "+i+"\n");
				}
			}
		}
		
		result.append("done");
		
		return new String(result);
	}
}
