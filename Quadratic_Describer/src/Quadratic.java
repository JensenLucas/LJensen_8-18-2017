/* Lucas Jensen
 * 9/27/2017
 * library for QuadraticClient; contains quadrDescriber and other methods
 */

//still almost entirely incomplete, I just wanted to turn something in (one day late)
public class Quadratic {
	public static void quadrDescriber(double operandA, double operandB, double operandC) {
		System.out.println("\nDescription of the graph of:\ny = " + operandA + " x^2 + " + operandB + " x + " + operandC + "\n");
		if(operandA >= 0) {
			//in the example code, if A = 0, it says "Opens: Up"
			System.out.println("Opens: Up");
		}else if(operandA < 0) {
			System.out.println("Opens: Down");
		}
		double axis = (-operandB/(2* operandA));
		//This turns -0.0 into 0.0
		axis += 0.0;
		System.out.println("Axis of Symmetry: " + axis);
		double vertexY = ((4 * operandA * operandC - (operandB * operandB)) / (4*operandA)) ;
		System.out.println("Vertex: (" + axis + ", " + vertexY + ")");
		if((operandA > 0 && operandC > 0 ) || (operandA < 0 && operandC < 0)) {
			System.out.println("x-intercept(s): none");
		}else if(vertexY == 0) {
			System.out.println("x - intercept(s): " + axis);
		}else {
			System.out.println(quadForm(operandA, operandB, operandC));
		}
		System.out.println("y-intercept: " + operandC);
	}
	//takes coefficients of a quadratic equation (standard form) and returns the real roots
	//accepts 3 integers, returns a String
	public static String quadForm(double operandA, double operandB, double operandC) {
		//variable names are out of order b/c created out of order
		double operandX = exponent(operandB, 2)-(4 * operandA * operandC);
		if(operandX < 0) {
			return("no real roots");
		}
		double operandZ = round2(-operandB + sqrt(operandX)) / (2* operandA);
		double operandY = round2(-operandB - sqrt(operandX)) / (2* operandA);

		if(operandZ == operandY) {
			return(operandZ + "");
		}else if(min(operandY, operandZ) == operandY){
			return(operandY + " and " + operandZ);
		}else if(min(operandY, operandZ) == operandZ){
			return(operandZ + " and " + operandY);
		}else {
			return("0.0");
		}
	}
	//approximates the square root of a given double
	public static double sqrt(double operand){
		if(operand < 0) {
			throw new IllegalArgumentException("Negative input is invalid");
		}
			
		//I don't know the best place to start, so I just picked something that's between
		//the operand and 0
		double testExpo = operand / 4;
		
		double altExpo = (((operand / testExpo) + testExpo) / 2);
		while( testExpo - altExpo > .005 || altExpo - testExpo > .005) {
			testExpo = altExpo;
			altExpo = (((operand / testExpo) + testExpo) / 2);
		}
		return(round2(altExpo));
	}
	//returns operandA^operandB
	public static double exponent (double operandA, int operandB) {
		double operandZ = operandA;
		if(operandB > 0) {
			for(int i=1; i < operandB; i++) {
				operandZ *= operandA;
			}
		}else if(operandB == 0) {
			operandZ = 1;
		}else if(operandB < 0){
			for(int i=-1; i < absValue(operandB); i++) {
				operandZ /= operandA;
			}
		}
		return operandZ;
	}
	public static double round2(double operand) {
		double operandZ = operand * 100;
		operandZ -= (operandZ % 1);
		operandZ /= 100;
		
		double operandY = operand * 1000;
		operandY -= (operandY % 1);
		operandY /= 1000;
		
		if(operandY - operandZ >= .005 && operandZ > 0) {
			operandZ += .01;
		}else if(operandY - operandZ <= -.005 && operandZ < 0) {
			operandZ -= .01;
		}
		return (operandZ);
	}
	public static double min(double operandA, double operandB){
		if (operandA <= operandB) {
			return(operandA);
		}else {
			return(operandB);
		}
	}
	public static double absValue(double operand) {
		if(operand < 0) {
			operand = operand - (2*operand);
		}
		return (operand);
	}
	//alternate version of absValue for integers 
	public static int absValue(int operand) {
		if(operand < 0) {
			operand = operand - (2*operand);
		}
		return (operand);
	}
}
