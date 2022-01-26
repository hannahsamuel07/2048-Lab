public class Activity3Tester {

	public static void main(String[] args) {
		
		//Declare a Board object
		Board b = new Board();
		//create an array with some values you want to 
		//slideRight. ie [2 0 0 0]
		
		//invoke the slideRight method on the array 
		
		
		//print out the array to see if slideRight
		//worked
		//int[] array = {2,0,0,2};
		//System.out.print(b);
//		int[][] array = { {0,0,0,0},
//						  {0,2,0,0,},
//						  {0,0,4,0},
//						  {0,0,4,0} } ;
//		
//		int[] my1Darray = new int[4];
//		my1Darray = b.getCol(array,2);
//		for(int val : my1Darray) {
//			System.out.print(val);	
//		}
		
//		System.out.print(b.toString());
//		b.slideDown();
//		System.out.println();
//		System.out.print(b.toString());

		int[] array = {2,2,2,2};
		b.combineLeft(array);
		for(int val : array) {
			System.out.print(val);	
		}
		
	}

}

