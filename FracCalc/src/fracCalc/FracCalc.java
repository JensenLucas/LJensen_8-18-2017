/*Lucas Jensen
 * 11/20/2017
 * fraction (mixed number) calculator
 */

package fracCalc;

import java.util.*;

public class FracCalc {
    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
		boolean check = true;
		System.out.println("Please provide input in the form of two numbers (whole, fraction, or mixed) separated by an operation.");
		do {
    		String input = userInput.nextLine();
    		if(input.equalsIgnoreCase("QUIT")) {
    			break;
    		}else{
    			System.out.println(produceAnswer(input));
    		}
    		System.out.println("Please provide next input or type QUIT to exit the program.");
		}while(check);
		System.out.println("Done");
    }
    /*
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"  
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    */
    public static String produceAnswer(String operand){ 
    	String[] operandB = operand.split(" ");
		String alpha = operandB[0];
		String operator = operandB[1];
		String beta = operandB[2];
		return(beta);
    }


}
