// This class checks all the diagonals, one starting from top left and the other from top right, if the numbers are repeated, then false is returned, otherwise the test is passed


public class UniqueDiagonalSudoku extends Sudoku {
	
	public UniqueDiagonalSudoku(int[][] numbers) {
		
        super(numbers); // Invoke sudoku constructor class
        
	}
	
	private boolean Uniqueness_checker(int diagonal) {
		
	    boolean[] digit_checker = new boolean[getSize()];

	    for (int i = 0; i < getSize(); i++) {
	    	
	        int num;

	        if (diagonal == 1) {
	        	
	            num = getGrid ()[i][i];
	            
	        } 
	        
	        else {
	        	
	            num = getGrid ()[i][getSize() - 1 - i];
	            
	        }

	        // Check if the number is out of range or if it has been encountered before.
	        if (num < 1 || num > getSize() || digit_checker[num - 1]) {
	        	
	            return false;
	            
	        }

	        digit_checker[num - 1] = true;
	    }

	    // At this point, all numbers in the diagonal are unique and within range.
	    
	    return true;
	}
	
	public boolean isValidSolution() {
		
		boolean a = true;
		
		if (super.isValidSolution() == !a) {
			
			return !a;
			
		}
		
		return Uniqueness_checker(1) || Uniqueness_checker(2); // Invoke Uniqueness_checker with 2 diagonals to check if the numbers and diagonals are valid
		
	}
	
}