import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * Union performs the union on a set of elements in two Integer Vectors.
 * @author Tara Schultz
 *
 */
public class Union {

	/**
	 * Takes arguments of integer values for two distinct vectors
	 * separated by a "/" and returns a vector containing the 
	 * union of the values in the original two vectors. 
	 * 
	 * For Example - For Arguments 1 3 5 7 9 / 1 4 5 6 2 7 8:
	 * - 1, 3, 5, 7, 9 will be stored in the first vector.
	 * - 1, 4, 5, 6, 2, 7, 8 will be stored in the second vector.
	 * - The resulting union vector will contain 1, 3, 5, 7, 9, 4, 6, 2, 8
	 * 
	 * @param args
	 */
	public static void main (String[] args) {
		// ArrayLists to store the values from args
		ArrayList<Integer> aVals = new ArrayList<Integer>();
		ArrayList<Integer> bVals = new ArrayList<Integer>();
		
		/* Whether or not the arg values belong to the first or second ArrayList */
		boolean firstArray = true;
		
		// Check each arg value
		for(String s: args) {
			/* if it's a '/' character then all subsequent values belong to second ArrayList */
			if(s.equals("/")) {
				firstArray = false;
				
			} else {
				/* if the string can be converted to an integer add it to the appropriate ArrayList */
				try {
					Integer i = new Integer(s);
					
					if(firstArray) {
						aVals.add(i);
					} else {
						bVals.add(i);
					}
		
				// if the string is not a valid integer, throw an error	
				} catch (NumberFormatException nfe) {
					System.out.println("WARNING Invalid Input: \"" + s + "\" is not an integer, and will not be added to either Vector.\n");
				}
			}
		}
		
		// Vector A of Integers initialized with first ArrayList
		Vector<Integer> a = new Vector<Integer>(aVals);
		// Vector B of Integers initialized with second ArrayList
		Vector<Integer> b = new Vector<Integer>(bVals);
		// Union Vector of A and B
		Vector<Integer> c = new Vector<Integer>();
		
		// perform the union of vectors a and b
		c = union(a, b);
		
		// Show the contents of all three vectors in the Console
		System.out.println("Vector A: " + a);
		System.out.println("Vector B: " + b);
		System.out.println("Union of A and B: " + c);
	}
	
	/**
	 * Checks each value in the parameterized Vectors a and b adding each
	 * unique value to the union Vector to be returned.  
	 * @param a
	 * @param b
	 * @return the union of a and b
	 */
	public static Vector<Integer> union(Vector<Integer> a, Vector<Integer> b) {
		// The union vector to return
		Vector<Integer> toReturn = new Vector<Integer>();
		
		// Add the values from Vector A
		Iterator<Integer> iter = a.iterator();
		while(iter.hasNext()) {
			Integer nextInt = iter.next();
			// Only add the Integer to the vector if it's not already there
			if(!toReturn.contains(nextInt)) {
				toReturn.add(nextInt);
			}
		}
		
		// Add the values from Vector B
		iter = b.iterator();
		while(iter.hasNext()) {
			Integer nextInt = iter.next();
			// Only add the Integer to the vector if it's not already there
			if(!toReturn.contains(nextInt)) {
				toReturn.add(nextInt);
			}
		}
		
		// Return the union vector
		return toReturn;
	}
}
