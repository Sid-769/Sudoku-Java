
public class Sudoku {
	
	private int size; // Declare variable size of type int
	
	private int [][] grid;	// Declare variable grid of type 2d array
	
	public Sudoku (int [][] numbers) { // When invoked, 2d array numbers will be set to numbers and number.lenght will be set to size of the grid
		
		size = numbers.length;
		
		grid = numbers;
		
		
	}
	
	
	public int[][] getGrid (){ // Returns grid ie. all the numbers present in it
		
		
	    return grid;
	    
	    
	}
	
	public int getSize () { // Returns grid size
		
		return size;
		
	}
	
	
	public int getDigitAt (int row, int col) { // Returns the digit at a certain place
	
		
		if (row < 0 || row > size - 1 || col < 0 || col > size - 1) { // if row is less than 0 or more than size -1 will be returned, same with column
			
			return -1; 
			
		}
		
		else { // If the row and col are valid, the specific grid number at row, col position will be returned
			
			return grid [row][col];
			
		}
		
		
	}
	
	public boolean isValidRow (int row) { // Row number passed through parameters to check if it's valid or not
		
		int col; // Declaring variable col or type int
		
		int digit; // Declaring variable digit or type int
		
		int i = 0; // Declaring variable i or type int and initializing it as 0 to use it in loops
		
		boolean a = true;
		
		if (row < 0 || row >= size) { // If row passed through parameters is invalid, false will be returned
			
	        return !a;
	        
	    }
		
		boolean[] digit_checker = new boolean[size]; // Stores boolean values, ie. true false of numbers in grid, if not encountered before, it is changed to true
		
		for (col = 0; col < size; col++) { // Loop through all the digits
			
	        digit = grid[row][col]; 
	        
			if (digit < 1 || digit > size) { // Case for invalid digit
				
	            return !a;
	        }
			
			else if (digit_checker[digit - 1]) { // In case digit has already been encountered before, return false
				
	            return !a;
	            
	        }
			
			else digit_checker[digit - 1] = a; // If all the conditions are passed, then the bool value is set to true, meaning it has been encountered for the first time
	        
	        }
		
		while (i < size) { // Loops through the digit_checker bool array, if there is a false value, false is returned, else a true is returned, meaning the digits are valid and not out of range
			
	        if (digit_checker[i] == !a) {
	            return !a;
	        }
	        
	        i++;
	        
	    }

	    return a;
	
	}
	
	
	public boolean isValidCol(int col) { // Loops through all the columns to check if the numbers are valid or not
		
		int i = 0; // Declaring variable i or type int and initializing it as 0 to use it in loops
		
		int row = 0; // Declaring variable row or type int
		
	    boolean a = true;

	    if (col < 0 || col >= size) { // Checks for invalid parameter col
	    	
	        return !a;
	        
	    }

	    boolean[] digit_checker = new boolean[size]; // Holds true false value, false by default, if 

	    for (row = 0; row < size; row++) {
	    	
	        int digit = grid[row][col];

	        if (digit < 1 || digit > size) { // Checks if digits are valid
	        	
	            return !a;
	            
	        } 
	        
	        else if (digit_checker[digit - 1]) { // If that specific number has been encountered before, false will be returned
	        	
	            return !a;
	            
	        } 
	        
	        else { // If all the conditions are passed, digit_checker will have a true boolean value
	        	
	            digit_checker[digit - 1] = a;
	            
	        }
	        
	    }

	    for (i = 0; i < size; i++) { // If any value in digit_checker is false, then false is returned
	    	
	        if (digit_checker[i] == !a) {
	        	
	            return !a;
	            
	        }
	        
	    }

	    return a;
	    
	}
	
	public boolean isValidBox(int row, int col) { // After checking the validity of rows and columns we now move to boxes
		
		int ninebyninebox = 9; // Declaring a size variable, this method will only be invoked if the grid size is 9
		
		boolean a = true;
		
		if (row < 0 || row > 6 || col < 0 || col > 6) { // Boxes start from 0,0 , 3,0 , 6,0 so if the number inputed is out of range, false will be returned
			 
	        return !a;
	        
	    }
		
		boolean[] digit_checker = new boolean[ninebyninebox]; // Bool values of size 9
		
		for (int i = 0; i < 3; i++) { // Loops through the box and stores the grid numbers in int num, and if it's out of range, false is returned, otherwise true is returned
			
			
			for (int j = 0; j < 3; j++) {
				
				int num = grid[row + i][col + j];
				
	            if (num < 1 || num > 9 || digit_checker[num - 1]) {
	            	
	                return !a;
	                
	            }
	            
	            digit_checker[num - 1] = a;
	            
			}
			
		}
		
		return a;
		
	}
	
	public boolean isValidSolution () {
		
		boolean a = true;
		
		for (int row = 0; row < size; row++) {
			
			if(isValidRow(row) == !a) {
				
				return !a;
				
			}
			
		}
		
		for (int col = 0; col < size; col++) {
			
	        if (isValidCol(col) == !a) {
	        	
	            return !a;
	            
	        }
	        
	    }
		
		if (size == 9) {
			
			for (int row = 0; row < size; row += 3) {
				
				for (int col = 0; col < size; col += 3) {
					
					if (isValidBox(row, col) == !a) {
						
						return !a;
						
					}
					
				}
				
			}
			
		}
		
		return a;
	
	}
	
	public boolean equals (Sudoku other) {
		
		boolean a = true;
		
		if(this.size != other.size) {
			
			return !a;
			
		}
		
		for(int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				if (this.grid[i][j] != other.grid[i][j]) {
					
					return !a;
					
				}
			}
		}
		
		return a;
		
	}
	
	public String toString() {
		
	    String final_string = "";

	    for (int i = 0; i < size; i++) {
	    	
	        for (int j = 0; j < size; j++) {
	        	
	        	final_string += grid[i][j] + " ";
	        	
	        }
	        
	        final_string += "\n";
	        
	    }

	    return final_string;
	}
	
}
