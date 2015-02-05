package interviews;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindLine {
	
	public static void main(String[] args) {
		FindLine fl = new FindLine();
		System.out.println(fl.findLine("/Users/liwang/Desktop/test.txt"));
		
	}
	
	public String findLine(String url) {
		Scanner input = null;
		
		try {
			input = new Scanner(new File(url));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int lineNum = Integer.parseInt(input.nextLine());
		int[] xArray = new int[lineNum];
		int[] yArray = new int[lineNum];
		
		for (int i=0; i<lineNum; i++) {
			String line = input.nextLine();
			
			line = line.substring(1);
			line = line.substring(0, line.length()-1);
			
			String[] vals = line.split(",");
			
			xArray[i] = Integer.parseInt(vals[0]);
			yArray[i] = Integer.parseInt(vals[1]);
		}
		
		//System.out.println(Arrays.toString(yArray));
		int max = 0;
		String result = "";
		
		for (int i=0; i<lineNum; i++) {
			for (int j=i+1; j<lineNum; j++) {
				double[] num1 = new double[]{xArray[i], yArray[i]};
				double[] num2 = new double[]{xArray[j], yArray[j]};

				
				//check special case
				if (num1[0]-num2[0] == 0) {
					int count = 0;
					for (int e : xArray) {
						if (num1[0] == e) {
							count++;
						}
					}
					if (count > max) {
						max = count;
						result = "X ="+num1[0]+","+max;
					}
					
				} else {
					double[] AB = findAandB(num1, num2);
					int count = countMatch(AB, xArray, yArray);
					if (count > max) {
						max = count;
						result = "Y = "+AB[0]+"x+"+AB[1]+","+max;
					}
				}
				
				
			}
		}
		
		return result;
	}
	
	private double[] findAandB(double[] coord1, double[] coord2) {
		// calculate a
		double x1 = coord1[0];
		double y1 = coord1[1];
		double x2 = coord2[0];
		double y2 = coord2[1];
		
		double a = (y1-y2)/(x1-x2);
		double b = y1-x1*a;
		
		return new double[]{a, b};
	}
	
	private int countMatch(double[] AB, int[] xArray, int[] yArray) {
		int count = 0;
		
		double a = AB[0];
		double b = AB[1];
		
		for (int i=0; i<xArray.length; i++) {
			if (a*xArray[i] + b == yArray[i]) {
				count++;
			}
		}
		
		return count;	
	}
	
}
