package com.tschul2.stutter.server;

import java.io.IOException;
import java.io.StringReader;

import com.tschul2.stutter.client.GreetingService;
import com.tschul2.stutter.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidText(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Text must be at least 10 characters long");
		}
		
		// Read input to find duplicate words
		return findStutter(input);
	}
	
	/**
	 * Reads a string by character checking for duplicate words.
	 * If a non-alphanumeric character is found it is omitted.
	 * 
	 * @param input the text to check
	 * @return a response containing all duplicate words found
	 */
	private String findStutter(String input) {
		// StringBuffer to hold the results from looking for duplicate words
		StringBuffer returnBuffer = new StringBuffer();
		
		char c;
		char[] current = new char[100];
		char[] last = new char[100];
		
		int i = 0;
		int lineCount = 1;
		boolean ld = true;
		
		last[0] = '\0';
		// StringReader to walk through the input string.  
		// Input is normalized so comparison of words isn't case sensitive
		StringReader in = new StringReader(input.toLowerCase());
		int tmp;
		
		try {
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
					
					// If a repeated word is found, add the word and its line number to the StringBuffer
					if(same(last, current)) {
						returnBuffer.append("Repeated word at line number " + lineCount + ": " + new String(last) + "<br>");
					
					} else {
						copy(current, last);
					}
					
				} else {
					ld = false;
					current[i++] = c;
				}
				
			}
		} catch (IOException e) {
			returnBuffer.append( "Could not read next character." );
		}
		
		// If the StringBuffer is empty, no repeated words were found, so state so.
		if(returnBuffer.length() < 1) {
			returnBuffer.append("No repeated words found.");
		}
		
		// Return the contents of the StringBuffer as a String
		return returnBuffer.toString();
	}
	
	/**
	 * Checks whether or not the character should be deleted.
	 * C can be deleted if it is included in the array of chars to be omitted.
	 *  
	 * @param C the character
	 * @return true, if C should be deleted
	 */
	private boolean deleteChar(char C) {
		final char DELS [] = {'\0', '\n', '\r', '	', ' ', ',', '.', '!', '-',
				   '+', '=', ';', ':', '?', '&', '{', '}', '\\'};
		int N = 18;
		int i;
		
		for (i = 0; i <= N-1; i++)
			if(C == DELS[i])
				return true;
		return false;
	}
	
	/**
	 * Checks whether or not the specified character arrays are the same.
	 * 
	 * @param a the first char array to be compared
	 * @param b the second char array to be compared
	 * 
	 * @return true, if the contents of the arrays are equal
	 */
	private boolean same(char a[], char b[]) {
		int i = 0;
		
		while((a[i] != '\0') && (b[i] != '\0')) {
			if(a[i] != b[i])
				return false;
			i++;
		}
		
		if((a[i] == '\0') && (b[i] == '\0')) {
			int j = i+1;
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
	 * Copies the contents of the original array to the copy
	 * 
	 * @param original the array to copy
	 * @param copy the copied array
	 */
	private void copy(char original[], char copy[]) {
		for(int i = 0; i < 100; i++) {
			copy[i] = original[i];
		}
	}
}
