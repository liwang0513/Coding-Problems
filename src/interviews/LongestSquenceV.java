package interviews;

public class LongestSquenceV {
	public static void main(String[] args) {
		LongestSquenceV lsv = new LongestSquenceV();
		System.out.println(lsv.findLongestV("aaaa"));
	}
	
	public String findLongestV(String str) {
		if (str.length() == 0) {
			return "";
		}
		
		if (str.length() == 1) {
			return str;
		}
		
		char[] letters = str.toCharArray();
		
		int max = -1;
		int left = 0;
		String result = "";
		
		for (int i=0; i<letters.length; i++) {
			if (isTop(letters, i)) {
				if (isFakeTop(letters, left)) {
					int len = i - left;
					if (len > max) {
						result = str.substring(left, i+1);
					}
					left = i+1;
				} else {
					int len = i - left+1;
					if (len > max) {
						result = str.substring(left, i+1);
					}
					left = i;
				}
			}
		}
		
		return result;
	}
	
	private boolean isTop(char[] letters, int index) {
		if (index == 0) {
			return letters[1] <= letters[0];
		}
		
		if (index == letters.length-1) {
			return letters[index-1] <= letters[index];
		}
		
		return letters[index] >= letters[index-1] && letters[index] >= letters[index+1];
	}
	
	private boolean isFakeTop(char[] letters, int index) {
		if (index == letters.length-1) return false;
		
		return letters[index] == letters[index+1];
	}
}
