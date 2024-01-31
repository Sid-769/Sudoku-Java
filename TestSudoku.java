
public class TestSudoku {

	public static void main(String[] args) {
		
		int[][] g1 = new int[][] {
			{1, 2, 3, 4, 5, 6, 7, 8, 9},
			{4, 5, 6, 7, 8, 9, 1, 2, 3},
			{7, 8, 9, 1, 2, 3, 4, 5, 6},
			{2, 3, 4, 5, 6, 7, 8, 9, 1},
			{5, 6, 7, 8, 9, 1, 2, 3, 4},
			{8, 9, 1, 2, 3, 4, 5, 6, 7},
			{3, 4, 5, 6, 7, 8, 9, 1, 2},
			{6, 7, 8, 9, 1, 2, 3, 4, 5},
			{9, 1, 2, 3, 4, 5, 6, 7, 8}
		};
		
		int[][] g2 = new int[][] {
			{2, 3, 1, 4},
			{4, 1, 3, 2},
			{3, 4, 2, 1},
			{1, 2, 4, 3}
		};
		
		int[][] g3 = new int[][] {
			{5, 6, 3, 2, 1, 4},
			{4, 1, 2, 3, 6, 5},
			{6, 3, 4, 5, 2, 1},
			{2, 5, 1, 6, 4, 3},
			{1, 2, 5, 4, 3, 6},
			{3, 4, 6, 1, 5, 2}
		};
		
		int[][] g4 = new int[][] {
			{5, 4, 2, 7, 1, 3, 8, 6, 9},
			{3, 6, 1, 9, 8, 2, 7, 5, 4},
			{7, 9, 8, 4, 6, 5, 1, 3, 2},
			{6, 5, 4, 3, 2, 1, 9, 8, 7},
			{1, 3, 7, 6, 9, 8, 4, 2, 5},
			{8, 2, 9, 5, 4, 7, 6, 1, 3},
			{4, 7, 5, 1, 3, 6, 2, 9, 8},
			{2, 1, 3, 8, 7, 9, 5, 4, 6},
			{9, 8, 6, 2, 5, 4, 3, 7, 1}
		};
		
		int[][] g5 = new int[][] {
			{5, 4, 2, 7, 1, 3, 8, 6, 9},
			{3, 6, 1, 9, 8, 2, 7, 5, 4},
			{7, 9, 3, 4, 6, 5, 1, 3, 2},
			{6, 5, 4, 3, 2, 1, 9, 8, 7},
			{1, 3, 7, 6, 9, 8, 4, 2, 5},
			{8, 2, 9, 5, 4, 7, 6, 1, 3},
			{4, 7, 5, 1, 3, 6, 2, 0, 8},
			{2, 1, 3, 8, 7, 9, 5, 4, 6},
			{9, 8, 6, 2, 5, 4, 3, 7, 1}
		};
		
		int[][] g6 = new int[][] {
			{1, 2, 3, 4, 5, 6, 7, 8, 9},
			{4, 5, 6, 7, 8, 9, 1, 2, 3},
			{7, 8, 9, 1, 2, 3, 4, 5, 6},
			{2, 3, 4, 7, 6, 7, 8, 9, 1},
			{5, 6, 7, 8, 2, 1, 2, 3, 4},
			{8, 9, 1, 2, 3, 6, 5, 6, 7},
			{3, 4, 5, 6, 7, 8, 3, 1, 2},
			{6, 7, 8, 9, 1, 2, 3, 4, 5},
			{9, 1, 2, 3, 4, 5, 6, 7, 8}
		};

		boolean b1, b2, b3;
		
		Sudoku s1 = new Sudoku(g1);
		Sudoku s2 = new Sudoku(g2);
		Sudoku s3 = new Sudoku(g3);
		Sudoku s4 = new Sudoku(g4);
		Sudoku s5 = new Sudoku(g5);
		Sudoku s6 = new Sudoku(g6);
		Sudoku s7 = new Sudoku(new int[][] {{2, 3, 1, 4}, {4, 1, 3, 2}, {3, 4, 2, 1}, {1, 2, 4, 3}});
		Sudoku s8 = new Sudoku(new int[][] {{2, 3, 1, 4}, {4, 1, 3, 2}, {3, 4, 2, 1}, {1, 2, 3, 4}});
		
		UniqueDiagonalSudoku u1 = new UniqueDiagonalSudoku(g1);
		UniqueDiagonalSudoku u2 = new UniqueDiagonalSudoku(g2);
		UniqueDiagonalSudoku u3 = new UniqueDiagonalSudoku(g3);
		UniqueDiagonalSudoku u4 = new UniqueDiagonalSudoku(g4);
		UniqueDiagonalSudoku u6 = new UniqueDiagonalSudoku(g6);
		
		// ---------- Test 1 ---------- [getters]
		
		b1 = s1.getSize() == 9 && s2.getSize() == 4;
		b2 = s1.getGrid() == g1 && s2.getGrid() == g2;
		b3 = s1.getDigitAt(2, 3) == 1 && s2.getDigitAt(1, 4) == -1;
		
		if (b1 && b2 && b3) {
			System.out.println("Test 1 Passed");
		} else {
			System.out.println("Test 1 Failed");
		}
		
		
		// ---------- Test 2 ---------- [equals]
		
		b1 = !s1.equals(s2);
		b2 = s2.equals(s7);
		b3 = !s2.equals(s8);
		
		if (b1 && b2 && b3) {
			System.out.println("Test 2 Passed");
		} else {
			System.out.println("Test 2 Failed");
		}
		
		
		// ---------- Test 3 ---------- [toString]
		
		String s1Str = "1 2 3 4 5 6 7 8 9 \n" + 
				"4 5 6 7 8 9 1 2 3 \n" + 
				"7 8 9 1 2 3 4 5 6 \n" + 
				"2 3 4 5 6 7 8 9 1 \n" + 
				"5 6 7 8 9 1 2 3 4 \n" + 
				"8 9 1 2 3 4 5 6 7 \n" + 
				"3 4 5 6 7 8 9 1 2 \n" + 
				"6 7 8 9 1 2 3 4 5 \n" + 
				"9 1 2 3 4 5 6 7 8";
		String s2Str = "2 3 1 4 \n" + 
				"4 1 3 2 \n" + 
				"3 4 2 1 \n" + 
				"1 2 4 3";

		b1 = s1.toString().trim().equals(s1Str);
		b2 = s2.toString().trim().equals(s2Str);
		
		if (b1 && b2) {
			System.out.println("Test 3 Passed");
		} else {
			System.out.println("Test 3 Failed");
		}
		
		
		
		// ---------- Test 4 ---------- [isValidRow]
		
		b1 = s1.isValidRow(0) && s1.isValidRow(8);
		b2 = s3.isValidRow(4) && s3.isValidRow(5);
		b3 = !s5.isValidRow(2) && !s5.isValidRow(6);
		
		if (b1 && b2 && b3) {
			System.out.println("Test 4 Passed");
		} else {
			System.out.println("Test 4 Failed");
		}
		
		
		// ---------- Test 5 ---------- [isValidCol]
		
		b1 = s1.isValidCol(3) && s1.isValidCol(6);
		b2 = s3.isValidCol(2) && s3.isValidCol(3);
		b3 = !s5.isValidCol(7) && s5.isValidCol(8);
		
		if (b1 && b2 && b3) {
			System.out.println("Test 5 Passed");
		} else {
			System.out.println("Test 5 Failed");
		}
		
		
		// ---------- Test 6 ---------- [isValidBox (only for 9-based sudokus)]
		
		b1 = s1.isValidBox(0, 3) && s1.isValidBox(3, 0);
		b2 = s4.isValidBox(6, 3) && s4.isValidBox(3, 3);
		b3 = !s5.isValidBox(0, 0) && !s5.isValidBox(6, 6);
		
		if (b1 && b2 && b3) {
			System.out.println("Test 6 Passed");
		} else {
			System.out.println("Test 6 Failed");
		}
		
		
		// ---------- Test 7 ---------- [isValidSolution]
		
		b1 = s1.isValidSolution();
		b2 = s3.isValidSolution();
		b3 = s4.isValidSolution();
		
		if (b1 && b2 && b3) {
			System.out.println("Test 7 Passed");
		} else {
			System.out.println("Test 7 Failed");
		}
		
		
		// ---------- Test 8 ---------- [isValidSolution]
		
		b1 = !s5.isValidSolution();
		b2 = !s6.isValidSolution();
		b3 = !s8.isValidSolution();
		
		if (b1 && b2 && b3) {
			System.out.println("Test 8 Passed");
		} else {
			System.out.println("Test 8 Failed");
		}
		
		
		// ---------- Test 9 ---------- [UD isValidSolution]

		b1 = u3.isValidSolution();
		b2 = u4.isValidSolution();
		
		if (b1 && b2) {
			System.out.println("Test 9 Passed");
		} else {
			System.out.println("Test 9 Failed");
		}
		
		
		// ---------- Test 10 ---------- [UD isValidSolution]
		
		b1 = !u1.isValidSolution();
		b2 = !u2.isValidSolution();
		b3 = !u6.isValidSolution();
		
		if (b1 && b2 && b3) {
			System.out.println("Test 10 Passed");
		} else {
			System.out.println("Test 10 Failed");
		}
		
	}

}
