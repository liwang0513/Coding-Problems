package interviews;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		String result = "";
		Map<List<Double>, Integer> map = new HashMap<List<Double>, Integer>();
		
		for (int i=0; i<lineNum; i++) {
			for (int j=i+1; j<lineNum; j++) {
				double[] num1 = new double[]{xArray[i], yArray[i]};
				double[] num2 = new double[]{xArray[j], yArray[j]};


				List<Double> AB = new ArrayList<Double>();
				if (num1[0] == num2[0]) {
					AB.add(num1[0]);
				} else {
					double[] theAB = findAandB(num1, num2);
					AB.add(theAB[0]);
					AB.add(theAB[1]);
				}
				
				//put it in to hashtable
				if (map.containsKey(AB)) {
					map.put(AB, map.get(AB)+1);
				} else {
					map.put(AB, 1);
				}
			}
		}
		
		int max = 0;
		List<Double> theAB = null;
		for (List<Double> AB : map.keySet()) {
			System.out.println(AB+" "+map.get(AB));
			if (map.get(AB) > max) {
				max = map.get(AB);
				theAB = AB;
			}
		}
		
		if (theAB == null) {
			return "Line not found.";
		} else {
			if (theAB.size() == 1) {
				return "X ="+theAB.get(0)+","+countMatch(theAB, xArray, yArray);
			} else {
				return "Y = "+theAB.get(0)+"x+"+theAB.get(1)+","+countMatch(theAB, xArray, yArray);
			}
		}
		
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
	
	private int countMatch(List<Double> AB, int[] xArray, int[] yArray) {
		int count = 0;
		
		if (AB.size() == 1) {
			double num = AB.get(0);
			
			for (int i=0; i<xArray.length; i++) {
				if (xArray[i] == num) {
					count++;
				}
			}
		} else {
			double a = AB.get(0);
			double b = AB.get(1);
			
			for (int i=0; i<xArray.length; i++) {
				if (a*xArray[i] + b == yArray[i]) {
					count++;
				}
			}
		}
		
		return count;
	}
	
}
