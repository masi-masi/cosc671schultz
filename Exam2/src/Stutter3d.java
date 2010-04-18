import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Class Stutter.
 * 
 * @author Josh Dehlinger
 * @version 1.0
 */

/**
 * The Class Stutter.
 */
public class Stutter3d{   
   
   /**
    * The main method.
    * Get the file name from the first argument or keyboard.
    * Call checkStutter.
    * If no file name is given, alert the user.
    * 
    * @param args the arguments
    */
   public static void main (String args[]){
	   // Print out header to consnole
	   System.out.println("COSC 671 - Software Testing and Maintenance");
	   System.out.println("*******************************************");       
	   
	   //  Check to make sure only a single file argument was provided
	   if (args.length > 1)
		   System.out.println ("Too many arguments.\nUsage: java stutter <input file>");
	   else if (args.length > 0){
		   // Read in file argument
		   try{
			   BufferedReader reader = new BufferedReader (new FileReader (args[0]));
			   
			   checkStutter (reader);
			   reader.close();
		   }
		   catch (Exception e){
			   System.err.println ("Error reading from file " + args[0] + ": " + e.getMessage());
		   }
	   }
   	}
   
   	/**
	    * Check stutter.
	    * 
	    * Reads the input file one line, then one word at a time.
	    * Looks for repeated words and informs users.
	    * 
	    * @param input the input file argument
	    * 
	    * @throws IOException Signals that an I/O exception has occurred.
	    */
   	public static void checkStutter (BufferedReader input) throws IOException {
   		int lineNumber = 1;
   		String line     = null;
   		String lastWord = null;

		// Get the first line from the file argument
   		line = input.readLine();

   		System.out.println("Covered Edge: (0,1)");
   		
   		// Keep reading and analyzing lines until end of file
   		while (line != null){
   			
   			System.out.println("Covered Edge: (1,2)");
   			
   			// Remove all non alpha-numeric characters
   			line = line.replaceAll ("[^a-zA-Z0-9 ]", "");
   	
   			// Splits the line into words and puts in an array of strings
   			String[] words = line.split (" ");

   			// Compare with the last word on the previous line
   			if (words [0].equalsIgnoreCase (lastWord)) {
   				System.out.println("Covered Edge: (2,4)");
   				System.out.println ("Stuttered word on line " + lineNumber + ": " + words[0]);
   				
   			} else {
   				System.out.println("Covered Edge: (2,5)");
   			}
   			
   			System.out.println("Covered Edge: (4,6) & (5,6)");
   			// Stop before the end, nothing to compare the last word with
   			System.out.println("Covered Edge: (6,7)");
   			for (int i = 0; i < (words.length-1); i++){
   				// Check to see if the current and subsequent words are the same
   				if (words [i].equalsIgnoreCase (words [i+1])) {
   					System.out.println("Covered Edge: (8,10)");
   					System.out.println ("Stutered word on line " + lineNumber + ": " + words [i]);
   				
   				} else {
   					System.out.println("Coverd Edge: (8,11)");
   				}
   				
   				System.out.println("Covered Edge: (10,12) & (11,12)");
   				System.out.println("Covered Edge: (12,7");
            }
   			
   			System.out.println("Covered Edge: (7,9) & (9,1)");
   			
   			// Save last word in the line
   			lastWord = words [words.length-1];
   			// Get the next line from the file argument
   			line = input.readLine();
   			// Increment line counter
   			lineNumber++;
   		}
   		
   		System.out.println("Covered Edge: (1,3)");
   	}
}