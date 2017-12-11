/*Lucas Jensen
 * 11/20/2017
 * fraction (mixed number) calculator
 */

package fracCalc;

import java.util.*;
//import java.lang.*;

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
		System.out.println("Program ended");
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
		int alphaWhole = 0;
		int alphaNum = 0;
		int alphaDen = 0;
		if(!alpha.contains("/")) {
			//whole number only
			alphaWhole = Integer.parseInt(alpha);
		}else if(!alpha.contains("_")) {
			//fraction only
			String[] divided = alpha.split("/");
			alphaNum = Integer.parseInt(divided[0]);
			alphaDen = Integer.parseInt(divided[1]);
		}else {
			//mixed number
			String[] divided = alpha.split("_");
			alphaWhole = Integer.parseInt(divided[0]);
			String temp = divided[1];
			String[] dividedB = temp.split("/");
			alphaNum = Integer.parseInt(dividedB[0]);
			alphaDen = Integer.parseInt(dividedB[1]);
		}
		//String alphaString = ("whole:" + (alphaWhole) + " numerator:" + (alphaNum) + " denominator:" + (alphaDen));
		int betaWhole = 0;
		int betaNum = 0;
		int betaDen = 1;
		if(!beta.contains("/")) {
			//whole number only
			betaWhole = Integer.parseInt(beta);
		}else if(!beta.contains("_")) {
			//fraction only
			String[] divided = beta.split("/");
			betaNum = Integer.parseInt(divided[0]);
			betaDen = Integer.parseInt(divided[1]);
		}else {
			//mixed number
			String[] divided = beta.split("_");
			betaWhole = Integer.parseInt(divided[0]);
			String temp = divided[1];
			String[] dividedB = temp.split("/");
			betaNum = Integer.parseInt(dividedB[0]);
			betaDen = Integer.parseInt(dividedB[1]);
		}
		
		if(operator.equals("+") || operator.equals("-")) {
			add(alphaWhole, betaWhole, alphaNum, betaNum, alphaDen, betaDen, operator);
		}else if(operator.equals("-")) {
			
		}
		//Output used for checkpoint 2
		//String betaString = ("whole:" + (betaWhole) + " numerator:" + (betaNum) + " denominator:" + (betaDen));
		//return(betaString);
		
		//return(answer);
    }

    public static String add(int alphaWhole, int betaWhole, int alphaNum, int betaNum, int alphaDen, int betaDen, String operator) {
    	int commonDen = alphaDen * betaDen;
    	int alphaNum2 = alphaNum * betaDen;
    	int betaNum2 = betaNum * alphaDen;
    	int whole;
    	int num;
    	if(operator.equals("+")) {
    		whole = alphaWhole + betaWhole;
    		num = alphaNum2 + betaNum2;
    	}else if(operator.equals("-")) {
    		whole = alphaWhole - betaWhole;
    		num = alphaNum2 + betaNum2;
    	}
    	simplify(num, commonDen);
    	return(null);
    }
    
    public static String simplify(int num, int den) {
    	if(num)
    	return(null);
    }
}
