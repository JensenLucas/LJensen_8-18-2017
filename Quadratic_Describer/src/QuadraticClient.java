/* Lucas Jensen
 * 9/27/2017
 * accesses Quadratic.java
 * handles user input and interface
 */
import java.util.*;
public class QuadraticClient {
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		Boolean done = false;
		//These two lines are only seen once, at the beginning of the sample program
		System.out.println("Welcome to the Quadratic Describer");
		System.out.println("Provide values for coefficients a, b, and c");
		do{
			//does not currently prompt the user to quit if an invalid int is given
			System.out.println("\na: ");
			double a = userInput.nextDouble();
			System.out.println("b: ");
			double b = userInput.nextDouble();
			System.out.println("c: ");
			double c = userInput.nextDouble();
			
			Quadratic.quadrDescriber(a,b,c);
			
			//@ program end
			System.out.println("Do you want to keep going? (type \"quit\" to end);");
			//need to debug. Currently does not work properly if user inputs
			//more than one word
			char check = userInput.next().charAt(0);
			Character.toString(check);
			if((Character.toString(check)).equals("q")) {
				done = true;
			}
		}while(!done);
	}
}
