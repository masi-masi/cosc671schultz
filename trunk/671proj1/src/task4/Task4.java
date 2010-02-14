package task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Tara Schultz
 * COSC 671.101
 * Project 1
 * Task 4 - Program Modification.  Using the set up from Tasks 1-3, you will now
 * perform a simple software maintenance task.  You are to make the following 
 * modifications to the Stutter.c program:
 *    1.  Change the program from C to Java
 *    2.  Format the program according to the Java Programming Style Guidelines
 *        and the Tips for Maintainable Java Code discussed and handed out in class
 *    3.  Document your Java code in Javadoc format and generate the Javadoc API
 *        HTML files for your code
 * 
 * @author tarayang
 */
public class Task4 {
	// The name of the file to read
	private static final String FILE_NAME = "Project1_Test_File.txt";
	
	/**
	 * Creates a File object to read the contents of the specified file. 
	 * File name is a constant String FILE_NAME.  Executes method Stut
	 * with the created file.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// The name of the file to read.
		File file = new File (FILE_NAME);
		Stut(file); 
	}
	
	/**
	 * Reads the contents of the text file by character checking for duplicate
	 * words.  If a non-alphanumeric character is found it is omitted.  
	 * 
	 * @param textFile the file to read
	 */
	private static void Stut(File textFile) {
		char c;
		char[] current = new char[100];
		char[] last = new char[100];
		
		int i = 0;
		int lineCount = 1;	//line count
		boolean ld = true;
		
		last[0] = '\0';
		FileReader fr;
		
		try {
			fr = new FileReader(textFile);
			BufferedReader in = new BufferedReader(fr);
			int tmp;
			
			while( (tmp = in.read()) != -1) {
				c = (char) tmp;
				// if end of line, increment line count
				if(c == '\n') {
					lineCount++;
				}
				
				// if the character should be deleted
				if(deleteChar(c)) {
					if (ld)
						// end this iteration and discard char
						continue;
					
					ld = true;
					current[i] = '\0';
					
					for(i = i + 1 ; i < 100; i++) {
						current[i] = '\0';
					}

					i = 0;
					
					if(same(last, current)) {
						System.out.println("Repeated word on line " + lineCount + ": " + new String(last) + " " + new String(current));
					
					} else {
						copy(current, last);
					}
					
				} else {
					ld = false;
					current[i++] = c;
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("stutter: can't find file " + FILE_NAME);
		} catch (IOException e) {
			System.out.println("stutter: can't open " + FILE_NAME);
		}
	}
	
	/**
	 * Delete checks whether or not the character should be deleted.
	 * C can be deleted if it is in included in the array of chars 
	 * to be omitted.
	 * 
	 * @param C the character
	 * 
	 * @return true, if C should be deleted
	 */
	private static boolean deleteChar(char C) {
		final char DELS [] = {'\0', '\n', '\r', '	', ' ', ',', '.', '!', '-',
							   '+', '=', ';', ':', '?', '&', '{', '}', '\\'};
		int N = 17;
		int i;
		
		for (i = 0; i <= N-1; i++) 
			if(C == DELS [i])
				return true;
		return false;
	}
	
	/**
	 * Same checks whether or not the specified character arrays are the same.
	 * 
	 * @param a the first char array to be compared
	 * @param b the second char array to be compared
	 * 
	 * @return true, if the contents of the arrays are equal
	 */
	private static boolean same(char a[], char b[]) {
		int i = 0;
		
		while((a[i] != '\0') && (b[i] != '\0')) {

			if(a[i] != b[i])
				return false;
			i++;
		}
		if((a[i] == '\0') && (b[i] == '\0')) {
			int j = i + 1;
			if((a[j] != '\0') || (b[j] != '\0')) {
				while(j < 100) {
					a[j] = '\0';
					b[j] = '\0';
					j++;
				}
			}
			return true;
		} else 
			return false;
	}
	
	/**
	 * Copy copies the contents of the original array to the copy.
	 * 
	 * @param original the array to copy
	 * @param copy the copied array
	 */
	private static void copy (char original[], char copy[]) {	
		for(int i = 0; i< 100; i++) {
			copy[i] = original[i];
		}
	}
}
