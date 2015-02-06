package interviews;

public class CheckFourPointsSameLine {
	
	public static void main(String[] args) {
		
		int[] p1 = {1, 1};
		int[] p2 = {2, 2};
		int[] p3 = {3, 3};
		int[] p4 = {4, 4};
		
		System.out.println(sameLine(p1, p2, p3, p4));
		
	}
	
	static boolean sameLine(int[] p1, int[] p2, int[] p3, int[] p4) {
		
		// check the area of p1 p2 p3
		if ((p2[0]-p1[0])*(p3[1]-p1[1]) - (p3[0]-p1[0])*(p2[1]-p1[1]) != 0) {
			return false;
		}
		
		// check the area of p1 p2 p4
		if ((p2[0]-p1[0])*(p4[1]-p1[1]) - (p4[0]-p1[0])*(p2[1]-p1[1]) != 0) {
			return false;
		}
		
		return true;
	}
	
	
}
