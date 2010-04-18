
public class FindLast {

	public static void main (String[] args){
		
		int[] x = {2, 3, 5};
		int y = 2;
		
		int returned = findLast(x, y);
		System.out.println("returned: " + returned);
	}
	
	public static int findLast (int[] x, int y) {
		/* Initial code with fault */
//		for(int i = x.length-1; i > 0; i--) {
		
		/* Modified code for #2 3f without fault*/
		for(int i = x.length-1; i >= 0; i--) {
			
			if( x[i] == y ) {
				return i;
			}
		}
		
		return -1;
	}
}
