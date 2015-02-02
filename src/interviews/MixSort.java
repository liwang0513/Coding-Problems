package interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MixSort {
	
	public static void main(String[] args) {
		
		//String str1 = "d 3 c 2 1 a";
		
		//String str2 = "add 6 abb at";
		
		MixSort sort = new MixSort();
		
		Scanner input = new Scanner(System.in);
		
		while (input.hasNext()) {
			System.out.println(sort.mixSort(input.nextLine()));
		}
		
	}
	
	public String mixSort(String str) {
		
		String[] strs = str.trim().split(" ");
		
		// label: number -- true      word -- false
		boolean[] labels = new boolean[strs.length];
		
		List<String> numList = new ArrayList<String>();
		List<String> wordList = new ArrayList<String>();
		
		for (int i=0; i<strs.length; i++) {
			if (isNumber(strs[i])) {
				labels[i] = true;
				numList.add(strs[i]);
			} else {
				wordList.add(strs[i]);
			}
		}
		
		Collections.sort(numList);
		Collections.sort(wordList);
		
		StringBuffer result = new StringBuffer();
		
		for (boolean label : labels) {
			if (label) {
				result.append(numList.remove(0));
			} else {
				result.append(wordList.remove(0));
			}
			result.append(" ");
		}
		
		return new String(result).trim();
		
	} 
	
	public boolean isNumber(String str) {
		
		return str.matches("[+-]?\\d*\\.?\\d+");
	}
	
}
