package n.queens.problem;

import java.util.Scanner;

public class Main {
	
	private boolean solved = false;		// flag to check if solution(s) found...
	private int n, count = 1;
	private int[][] board;

	public static void main(String[] args) {
		int n;

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Value of N = ");
		
		n = scanner.nextInt();

		scanner.close();
		System.out.println();
		
		Main main = new Main(n);
		main.solve(0);
		
		if (!main.isSolved()) {
			System.out.println("No solution found...");
		}
	}

	public Main(int n) {
		this.n = n;
		board = new int[n][n];
	}
	
	public boolean isSolved() {
		return solved;
	}
	
	private boolean canPlaceQueen(int row, int column) {		// checks if queen can be placed on "board[row][column]"...
		int i, j;

		for (i = 0; i < column; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		for (i = row, j = column; i > -1 && j > -1; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		for (i = row, j = column; j > -1 && i < n; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	public void solve(int column) {			// solves N-Queens Problem recursively...
		if (column == n) {
			solved = true;
			
			print();		// printing solution...
		}

		for (int i = 0; i < n; i++) {
			if (canPlaceQueen(i, column)) {
				board[i][column] = 1;		// queen is placed...
				
				solve(column + 1);		// recursive call...
				
				board[i][column] = 0;		// queen is removed...
			}
		}
	}
	
	public void print() {		// prints the board...
		System.out.println("Solution " + count++ + "\n");
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print("\t" + board[i][j]);
			}

			System.out.println();
		}
		
		System.out.println();
	}

}