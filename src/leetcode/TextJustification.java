package leetcode;

import java.util.*;

public class TextJustification {

	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(Arrays.toString(format(words, 16)));
	}
	
	static String[] format(String[] strs, int len) {
		List<String> result = new ArrayList<>();
		
		int index = 0;
		while (index < strs.length) {
			List<String> temp = new ArrayList<>();
			int curSize = 0;
			
			// put in the first word
			if (strs[index].length() <= len) {
				temp.add(strs[index]);
				curSize += strs[index].length();
				index++;
			}
			
			while (index < strs.length && curSize+strs[index].length()+1 < len) {
				temp.add(strs[index]);
				curSize += strs[index].length()+1;
				index++;
			}
			
			int split = temp.size()-1;
			if (split == 0) {
				StringBuffer newLine = new StringBuffer();
				newLine.append(temp.get(0));
				for (int i=0; i<len-temp.get(0).length(); i++) {
					newLine.append(" ");
				}
				result.add(new String(newLine));
				continue;
			}
			
			
			int[] spaces = new int[split];
			int total = len;
			for (String e : temp) {
				total -= e.length();
			}
			
			Arrays.fill(spaces, total/split);
			int rest = total%split;
			
			for (int i=0; i<rest; i++) {
				spaces[i]++;
			}
			
			StringBuffer newLine = new StringBuffer();
			newLine.append(temp.get(0));
			
			for (int i=1; i<temp.size(); i++) {
				for (int j=0; j<spaces[i-1]; j++) {
					newLine.append(" ");
				}
				newLine.append(temp.get(i));
			}
			
			result.add(new String(newLine));
		}
		
		return result.toArray(new String[result.size()]);
	}
	
	
}
