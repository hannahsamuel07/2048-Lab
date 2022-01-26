import java.util.Random;

public class Board {
 
	private int[][] board; // holds state of game
	private Random rnd = new Random(0); // setup random # generator
	private int size;
	
	//What instance variable can you add to keep track of the size or the number of tiles occupied?
	
	/* default constructor for board */
	// constructors must match exactly the name
	// of the class.
	public Board() {
		
		// instantiate the board
		board = new int[4][4];
		populateOne();
		populateOne();
	}

	/*
	 * return a String representation of the 2D array board
	 * each row should be in its own line
	 * 
	 * Example:
	 * 
	 * { {1, 2, 3}, {4, 5, 6}} -> 1 2 3
	 * 
	 * 4 5 6
	 */

	
	// overriding a method is when a "child"
	// class implement the exact same method
	// that its parent class has
	public String toString() {
		
		/*
		 * Use the String formatter to pad the numbers with leading 0s
		 * so that the print out does not become jagged
		 * An example is shown below. 
		 * String str = String.format("%04d", 9);  // 0009  
		 * int x = 30;
		 * System.out.println(String.format("%04d",x));
		 *     
		 */
		
		//setup loops to visit
		//every spot possible
		String builder = "";
				//String.format("%04d",board[0][0]);
		
		//Inserting New Line characters?
		//builder+= "\n"; //\n----> new line character
		//builder+= String.format("%04d",board[0][1]);
		
		//write nested loop
		//to traverse the 2D array
		//build the String to represent the elements on the board
		//when you do add a new line character in the String you're building
		for(int row = 0; row<board.length; row++) {
			for(int col = 0; col<board[row].length; col++) {
				
				
					builder+= String.format("%04d", board[row][col]);
					builder+= " ";
					if(board[row][col] != 0) {
						size++;
					}
				
				
			}
				builder+= "\n"; //\n----> new line character
		}
		
		return builder;
	}

	/*
	 * set one of the empty spaces (at random)
	 * to a 2 or 4 (90/10 chance). an empty spot is defined to be a 0 element
	 * Must use the Random class object rnd.
	 * Example Use of rnd object.
	 * 
	 * int randomNum = rnd.nextInt(10); //returns a number in range [0 10) (not
	 * inclusive on the 10)
	 */

	public void populateOne() {
		
		// is there an empty spot?
		// for randomness, generate a row and column
		// check if that tile is empty, if it is NOT empty,
		// generate another set of row and column
		// what happens if the entire board is full??! 
		//int x = rnd.nextInt(range+1) +min;
		int row = rnd.nextInt(3-0+1) + 0; //min : 0 max : 3
		
		//write the line of code to randomly pick a column similar to
		//picking a row
		int col = rnd.nextInt(3-0+1) + 0;
		boolean found = false;
		while(found == false) {
			if(board[row][col]!= 0) {
				row =  rnd.nextInt(4);
				col = rnd.nextInt(4);
			}else {
				found = true;
			}
		}
		if(rnd.nextInt(10)<=8) {
			board[row][col] = 2;
		}else {
			board[row][col] = 4;
		}
		//check if the spot is taken- AKA it's not 0 at the location
		//keep generating a row and col value until you find a spot 
		//that is empty
		
		
		
			
		//}
		
		//generating a 2 a 4 with 10& chance 4 and 90% chance 2
		//if(rnd.nextInt(4)<=1) {
			//because rnd.nextInt can return 0,1,2,3,4
			//0 will be generated 25% of the time!
			//and a 1 will be generated 25% time
		
	}
	public void eraseBoard() {
		for(int row = 0; row<board.length; row++) {
			for(int col = 0; col<board[row].length; col++) {
				board[row][col] = 0;
			}
			
			}
	}

	
	
	/*
	 * 
	 * Given an array of integers, slide all non-zero elements to the right.
	 * zero elements are considered open spots.
	 * example:
	 * 
	 * [0 2 0 2]->[0 0 2 2]
	 * [2 8 0 2]->[0 2 8 2]
	 * [4 0 0 0]->[0 0 0 4]
	 */
	
	public void slideRight(int[] row) {
		int index = row.length-1;
		int[] myArray = new int[row.length];
		for (int i = row.length-1; i>=0; i--) {
			if(row[i] != 0) {
				myArray[index] = row[i];
				index--;
			}
		}
		for(int i = 0; i<row.length; i++) {
			row[i] = myArray[i];
		}
	
	}

	/*
	 * 
	 * Move the numbers as far to the right as they can go
	 * aka the numbers are trying to move to the right-most
	 * empty spaces. This method must utilize the slideRight(int[] row) method
	 * must utilize the helper method above for full credit.
	 * param: a valid row of 2048 where 0s are "empty" spots
	 * effect: row is modified so all numbers are to the right side
	 * return: none
	 */

	public void slideRight() {

		// go through 2D array, move all digits as far right as possible
		//setup a loop to grab ONE row at a time from 2d array board
		for(int i = 0 ; i<board.length; i++) {
			slideRight(board[i]);
		}
		
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the left.
	 * zero elements are considered open spots.
	 * example:
	 * 
	 * [0 2 0 2] -> [2 2 0 0]
	 * [2 0 0 2] -> [2 2 0 0]
	 */

	public void slideLeft(int[] arr) {
		
		int index = 0;
		int[] myArray = new int[arr.length];
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] != 0) {
				myArray[index] = arr[i];
				index++;
			}
		}
		for(int i = 0; i<arr.length; i++) {
			arr[i] = myArray[i];
		}
		
	}

	/*
	 * Slide all the numbers to the left so that
	 * 
	 * all of the empty spaces are on the right side
	 */

	public void slideLeft() {
		
		// grabbing a row from a 2D array
		// if it's called arr then arr[i] grabs ONE row!
		for(int i = 0; i<board.length; i++) {
			slideLeft(board[i]);
		}
		
		
		//visit every single row in the 2D array
		//call the slideLeft method that takes in one argument
		
		
	}

	/**
	 * Given a 2D array and a column number, return a 1D array representing the
	 * elements in the given column number.
	 */
	public int[] getCol(int[][] data, int c) {
		//return a col in the 1D array
		int row = 0;
		int[] myArray = new int [data.length];
			for(int i = 0; i<data. length; i++) {
				if(data[row][c] != 0) {
				myArray[i] = data[row][c];
				row++;
				}else {
				row++;
				}
				
			}


		return myArray;
		
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the top.
	 * 
	 * zero elements are considered open spots.
	 */

	public void slideUp(int[] arr) {
		/* calls a helper method */
		
		// do not rewrite logic you already have!
		//apply the left logic on the col bc the col is a another row and to move it up you move left
		slideLeft(arr);
	}

	/*
	 * 
	 * Slide all elements in the board towards the top.
	 * 
	 * You must use slideUp and getCol for full credit.
	 */
	public void slideUp() {
		
		//visit every column index
		//grab each column as an array using getCol -> keep track of it in a 1d array
		// variable/reference
		//have slideLeft perform manipulation on the array
		// copy over the 1D array representation of the column
		// back to the 2D board array
		for(int col = 0; col<board.length; col++) {
			int array[] = new int[4];
			//get a col and put in an a new array
			array = getCol(board, col);
			//slide it up
			slideUp(array);
			//coppy the slid up col into the board on the same col location
			for(int row = 0; row<board.length; row++) {
				board[row][col] = array[row];
			}

		}
		
		
		
	}

	public void slideDown(int[] arr) {
		//apply slide right logic on on the array being passed in
		slideRight(arr);
		
	}

	/*
	 * slide all the numbers down so that any
	 * empty space is at the top
	 * You must use slideDown and getCol for full credit.
	 */

	public void slideDown() {
		
		for(int col = 0; col<board.length; col++) {
			int array[] = new int[4];
			//get a column from 2d array and put in 1d array
			array = getCol(board, col);
			//slide down the 1D array
			slideDown(array);
			//put the new slide down array into the board
			for(int row = 0; row<board.length; row++) {
				board[row][col] = array[row];
			}
		}
	}
	
	/*
	 * Given the 2D array, board, combineRight will take adjacent numbers that
	 * are the same and combine them (add them).
	 * After adding them together, one of the numbers is zeroed out. For
	 * example, if row 0 contained [0 0 4 4],
	 * a call to combineRight will produce [0 0 0 8]. If row 1 contained [2 2 2
	 * 2], a call to combineRight will
	 * produce [0 4 0 4].
	 * 
	 * Notice that the left element is zeroed out.
	 * [2 2 2 2]
	 * [0 4 2 2] 
	 */
	public void combineRight(int[] arr) {
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[i]==arr[i+1]) { //if you find adjacent tiles
				arr[i+1] = arr[i] +arr[i]; //add them together
				arr[i] = 0;	//and zero the other one
				i++; // NOTE: skip an element once  you combined right so yo move forward
			}
		}
		
	}
	public void combineRight() {
		//for every element on the board, apply the combine right method
		for(int i = 0; i<board.length; i++) {
			combineRight(board[i]);
		}
	}

	/*
	 * same behavior as combineRight but the right element is zeroed out when
	 * two elements are combined
	 * [2,2,2,2]
	 * [4,0,4,0]
	 * [8,0,0,0]
	 */
	public void combineLeft(int[] arr) {
		for(int i = 0; i<arr.length-1; i++) { 
			if(arr[i]==arr[i+1]) { //if you find adjacent cells
				arr[i] = arr[i] +arr[i];	//add them together
				arr[i+1] = 0; //zero the element out
	
				i++; //skip the element you just used
			}
		}
	}
	public void combineLeft() {
		//apply the combine left method onto the entire board
		for(int i = 0; i<board.length; i++) {
			combineLeft(board[i]);
		}
		
		
	}
	
	/*
	 * same behavior as combineRight but the bottom element is zeroed out when
	 * two elements are combined
	 */
	public void combineUp(int[]arr) {
		//combineUp uses the combineLeft method
		combineLeft(arr);
	}
	public void combineUp() {
		for(int col = 0; col<board.length; col++) {
			int array[] = new int[4];
			//take a col from the 2D array
			array = getCol(board, col);
			//combine Up
			combineUp(array);
			//aply the new fixed array onto the board
			for(int row = 0; row<board.length; row++) {
				board[row][col] = array[row];
			}

		}
	}

	/*
	 * same behavior as combineRight but the top element is zeroed out when two
	 * elements are combined
	 */
	public void combineDown(int[]arr) {
		//apply the combine right method
		combineRight(arr);
	}
	public void combineDown() {
		for(int col = 0; col<board.length; col++) {
			int array[] = new int[4];
			//take a col from the 2D array
			array = getCol(board, col);
			//combine the elements
			combineDown(array);
			//put the combine array onto the board
			for(int row = 0; row<board.length; row++) {
				board[row][col] = array[row];
			}

		}
	}

	
	
	/* reminder: these are the methods that will ultimately invoke
	 * a series of methods
	 * 
	 * the combine and slide methods should not worry about each other's methods
	 */
	public void left() {
		//1) numbers slide to the left
		//2) combine
		//3) slide
		slideLeft();
		combineLeft();
	}

	public void right() {
		slideRight();
		combineRight();
	}

	public void up() {
		slideUp();
		combineUp();
		

	}

	public void down() {
		slideDown();
		combineDown();

	}
	
	

	public boolean gameOver() {
		return false;
	}

	public int[][] getBoard() {
		return board;
	}

	// populate with a given 2d array
	public void populate(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				board[r][c] = arr[r][c];
			}
		}
	}

}

