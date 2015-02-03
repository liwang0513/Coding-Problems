package interviews;

import java.util.ArrayList;
import java.util.List;

public class FindPathCrossBoard {
	
	public static void main(String[] args) {
		
		/*  
		    1 0 1 0 1 1
			1 0 1 0 0 1
			1 0 0 1 0 1
			1 1 0 1 1 1
			0 1 0 0 0 1
			1 0 1 0 1 1
		*/
		int[][] board = {{1, 0, 1, 0, 1, 1},
				{1, 0, 1, 0, 0, 1},
				{1, 0, 0, 1, 0, 1},
				{1, 1, 0, 1, 1, 1},
				{0, 1, 0, 0, 0, 1},
				{1, 0, 1, 0, 1, 1}};
		
		FindPathCrossBoard fp = new FindPathCrossBoard();
		
		fp.printBoard(board);
		
		System.out.println(fp.findPath(board));
		
		
	}
	
	public String findPath(int[][] board) {
		int n = board.length;
		
		// create a label board to mark used path
		boolean[][] label = new boolean[n][n];
		
		// set all obstacle to false
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				label[i][j] = board[i][j] == 1 ? false : true; 
			}
		}
		
		// iterate from the outer circle
		List<Entry> candidates = getCandidates(board);
		//System.out.println(candidates.size());
		
		for (Entry e : candidates) {
			// test if this path is available
			String result = checkPath(board, label, e, e.toString());
			if (!result.equals("No")) {
				return result;
			}
		}
		
		return "No result is found";
	}
	
	private String checkPath(int[][] board, boolean[][] label, Entry e, String result) {
		// if current place is obstacle, return
		if (label[e.rowIndex][e.colIndex] == false) {
			return "No";
		}
		
		
		
		// label current entry to false
		label[e.rowIndex][e.colIndex] = false;
		
		// find next available entries
		List<Entry> candidates = findNext(board, label, e);
		
		// if there is no candidate, return fail
		if (candidates.size() == 0) {
			return "No";
		}
		
		for (Entry candidate : candidates) {
			//if the candidate is in the outer circle, we find a path
			if (candidate.colIndex == 0 || candidate.rowIndex == 0 || candidate.colIndex == board.length-1 || candidate.rowIndex == board.length-1) {
				return result + " " + candidate;
			} 
			
			String str = checkPath(board, label, candidate, result+" "+candidate);
			
			if (!str.equals("No")) {
				return str;
			}
		}
		
		return "No";
		
	}
	
	private List<Entry> findNext(int[][] board, boolean[][] label, Entry e) {
		int rowIndex = e.rowIndex;
		int colIndex = e.colIndex;
		
		List<Entry> result = new ArrayList<Entry>();
		
		// check upside
		if (rowIndex > 0 && label[rowIndex-1][colIndex] == true) {
			result.add(new Entry(rowIndex-1, colIndex));
		}
		
		// check leftside
		if (colIndex > 0 && label[rowIndex][colIndex-1] == true) {
			result.add(new Entry(rowIndex, colIndex-1));
		}
		
		// check rightside
		if (colIndex < board.length-1 && label[rowIndex][colIndex+1] == true) {
			result.add(new Entry(rowIndex, colIndex+1));
		}
		
		// check downside
		if (rowIndex < board.length-1 && label[rowIndex+1][colIndex] == true) {
			result.add(new Entry(rowIndex+1, colIndex));
		}
		
		return result;
	}
	
	public void printBoard(int[][] board) {
		for (int[] line : board) {
			StringBuffer str = new StringBuffer();
			for (int e : line) {
				str.append(e+" ");
			}
			System.out.println(new String(str).trim());
		}
	}
	
	public List<Entry> getCandidates(int[][] board) {
		
		List<Entry> result = new ArrayList<Entry>();
		int n = board.length;
		
		// add the first line
		for (int i=0; i<n-1; i++) {
			result.add(new Entry(0, i));
		}
		
		// add the last column
		for (int i=0; i<n-1; i++) {
			result.add(new Entry(i, n-1));
		}
		
		// add the last line
		for (int i=n-1; i>0; i--) {
			result.add(new Entry(n-1, i));
		}
		
		// add the first column
		for (int i=n-1; i>0; i--) {
			result.add(new Entry(i, 0));
		}
		
		return result;
	}
	
}

class Entry {
	public int rowIndex;
	public int colIndex;
	
	public Entry(int rowIndex, int colIndex) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}
	
	public String toString() {
		return "(" + rowIndex + "," + colIndex + ")";
	}
}
