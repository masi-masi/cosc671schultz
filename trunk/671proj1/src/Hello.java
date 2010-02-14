/**
 * COSC 671.101
 * Project 1
 * Task 1
 * 
 * Hello World
 * 
 * @author tarayang
 */
public class Hello {
	
	/** The booyah. */
	private static String booyah;
	
	/** The hello. */
	private static Hello hello = new Hello();
	
	/**
	 * The main method. Outputs the string "Hello World!"
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		hello.setBooyah("Hello World!");
		System.out.println(hello.getBooyah());
	}
	
	/**
	 * Gets the booyah.
	 * 
	 * @return the booyah
	 */
	private String getBooyah() {
		return booyah;
	}
	
	/**
	 * Sets the booyah.
	 * 
	 * @param newBooyah the new booyah
	 */
	private void setBooyah(String newBooyah) {
		booyah = newBooyah;
	}
}
