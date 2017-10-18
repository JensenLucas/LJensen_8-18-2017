/* Lucas Jensen
 * 9/27/2017
 * library for QuadraticClient; contains quadrDescriber and other methods
 */

//still almost entirely incomplete, I just wanted to turn something in (one day late)
public class Quadratic {
	public static void quadrDescriber(double opperandA, double opperandB, double opperandC) {
		System.out.println("\nDescription of the graph of:\ny = " + opperandA + " x^2 + " + opperandB + " x + " + opperandC + "\n");
		if(opperandA >= 0) {
			//in the example code, if A = 0, it says "Opens: Up"
			System.out.println("Opens: Up");
		}else if(opperandA < 0) {
			System.out.println("Opens: Down");
		}
		double axis = (-opperandB/(2* opperandA));
		System.out.println("Axis of Symmetry: " + axis);
		double vertexY = ((4 * opperandA * opperandC - (opperandB * opperandB)) / (4*opperandA)) ;
		System.out.println("Vertex: (" + axis + ", " + vertexY + ")");
		if((opperandA > 0 && opperandC > 0 ) || (opperandA < 0 && opperandC < 0)) {
			System.out.println("x-intercept(s): none");
		}else if(vertexY == 0) {
			System.out.println("x - intercept(s): " + axis);
		}else {
			System.out.println(quadForm(opperandA, opperandB, opperandC));
		}
		System.out.println("y-intercept: " + opperandC);
	}
	//takes coefficients of a quadratic equation (standard form) and returns the real roots
	//accepts 3 integers, returns a String
	public static String quadForm(double opperandA, double opperandB, double opperandC) {
		//variable names are out of order b/c created out of order
		double opperandX = exponent(opperandB, 2)-(4 * opperandA * opperandC);
		if(opperandX < 0) {
			return("no real roots");
		}
		double opperandZ = round2(-opperandB + sqrt(opperandX)) / (2* opperandA);
		double opperandY = round2(-opperandB - sqrt(opperandX)) / (2* opperandA);

		if(opperandZ == opperandY) {
			return(opperandZ + "");
		}else if(min(opperandY, opperandZ) == opperandY){
			return(opperandY + " and " + opperandZ);
		}else if(min(opperandY, opperandZ) == opperandZ){
			return(opperandZ + " and " + opperandY);
		}else {
			return("0.0");
		}
	}
	//approximates the square root of a given double
	public static double sqrt(double opperand){
		if(opperand < 0) {
			throw new IllegalArgumentException("Negative input is invalid");
		}
			
		//I don't know the best place to start, so I just picked something that's between
		//the opperand and 0
		double testExpo = opperand / 4;
		
		double altExpo = (((opperand / testExpo) + testExpo) / 2);
		while( testExpo - altExpo > .005 || altExpo - testExpo > .005) {
			testExpo = altExpo;
			altExpo = (((opperand / testExpo) + testExpo) / 2);
		}
		return(round2(altExpo));
	}
	//returns opperandA^opperandB
	public static double exponent (double opperandA, int opperandB) {
		double opperandZ = opperandA;
		if(opperandB > 0) {
			for(int i=1; i < opperandB; i++) {
				opperandZ *= opperandA;
			}
		}else if(opperandB == 0) {
			opperandZ = 1;
		}else if(opperandB < 0){
			for(int i=-1; i < absValue(opperandB); i++) {
				opperandZ /= opperandA;
			}
		}
		return opperandZ;
	}
	public static double round2(double opperand) {
		double opperandZ = opperand * 100;
		opperandZ -= (opperandZ % 1);
		opperandZ /= 100;
		
		double opperandY = opperand * 1000;
		opperandY -= (opperandY % 1);
		opperandY /= 1000;
		
		if(opperandY - opperandZ >= .005 && opperandZ > 0) {
			opperandZ += .01;
		}else if(opperandY - opperandZ <= -.005 && opperandZ < 0) {
			opperandZ -= .01;
		}
		return (opperandZ);
	}
	public static double min(double opperandA, double opperandB){
		if (opperandA <= opperandB) {
			return(opperandA);
		}else {
			return(opperandB);
		}
	}
	public static double absValue(double opperand) {
		if(opperand < 0) {
			opperand = opperand - (2*opperand);
		}
		return (opperand);
	}
	
	//alternate version of absValue for integers 
	public static int absValue(int opperand) {
		if(opperand < 0) {
			opperand = opperand - (2*opperand);
		}
		return (opperand);
	}
	
	
}
