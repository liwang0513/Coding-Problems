package leetcode;

public class ReadNCharaters {
	char[] buffer = {'t','o','d','a','y','i','s','a','g','o','o','d','d','a','y'};
	
	public static void main(String[] args) {
		
		
	}
	
	static int read(char[] buf, int n) {
		char[] temp = new char[4];
		boolean eof = false;
		int size = 0;
		while (!eof && size < n) {
			int len = 0;//read4(temp);
			len = Math.min(len, n-size);
			System.arraycopy(temp, 0, buf, size, len);
			if (len < 4) eof = true;
			size += len;
		}
		
		return size;
	}
	
}
