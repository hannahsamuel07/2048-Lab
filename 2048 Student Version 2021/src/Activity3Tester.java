
public class Activity3Tester {

	public static void main(String[] args) {
		
		//Declare a Board object
		Board b = new Board();
		//create an array with some values you want to 
		//slideRight. ie [2 0 0 0]
		
		//invoke the slideRight method on the array 
		
		
		//print out the array to see if slideRight
		//worked
		int[] array = {2,0,0,2};
		//System.out.print(b);
		b.slideRight(array);
		//System.out.print(array);
		for(int val : array) {
			System.out.println(val + " ");
		
		}
	}

}
