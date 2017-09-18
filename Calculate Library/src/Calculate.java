/* Lucas Jensen
 * 9-6-2017
 * Math library
 * -contains a series of methods to do basic math functions
 */
public class Calculate {
	
	//squares input
	public static int square(int opperand){
		return opperand*opperand;
	}
	
	//cubes input
	public static int cube(int opperand) {
		return opperand*opperand*opperand;
	}
	
	//takes 2 doubles, returns the average
	public static double average(double opperandA, double opperandB) {
		double sum = opperandA + opperandB;
		return (sum/2);
	}
	
	//takes 3 doubles, returns the average
	public static double average(double opperandA, double opperandB, double opperandC) {
		double sum = opperandA + opperandB + opperandC;
		return (sum/3);
	}
	
	//converts a value in radians to degrees
	public static double toDegrees(double opperand) {
		return ((opperand*180)/3.14159);
	}
	
	//converts a value in degrees to radians
	public static double toRadians(double opperand) {
		return ((opperand*3.14159)/180);
	}
	
	//accepts coefficients for quadratic equation, returns discriminant
	public static double discriminant(double opperandA, double opperandB, double opperandC) {
		double disc = ((opperandB*opperandB)-(4*opperandA*opperandC));
		return disc;
	}
	
	//takes a mixed #, returns improper fraction
	public static String toImproperFrac(int opperandA, int opperandB, int opperandC) {
		int numerator = (opperandA * opperandC)+ opperandB;
		String fraction = (numerator + "/" + opperandC);
		return (fraction);
	}
	
	//takes improper frac, returns mixed #
	public static String toMixedNum(int opperandA, int opperandB) {
		int num = opperandA % opperandB;
		int whole = (opperandA / opperandB);
		return (whole + " " + num + "/" + opperandB);
	}
	
	//"foils", converts a binomial into a quadratic
	public static String foil(int opperandA, int opperandB, int opperandC, int opperandD, String opperandE) {
		int quadA = opperandA * opperandC;
		int quadB = (opperandA * opperandD) + (opperandB*opperandC);
		int quadC = (opperandB * opperandD);
		String operatorA;
		String operatorB;
		
		//this is so I don't have a "plus negative" (like "+ -7")
		if(quadB < 0) {
			//is there a more efficient means of doing this?
			operatorA = " - ";
			quadB = absValue(quadB);
		}else {
			operatorA = " + ";
		}
		if(quadC < 0) {
			operatorB = " - ";
			quadC = absValue(quadC);
		}else {
			operatorB = " + ";
		}
		
		return (quadA + opperandE + "^2" + operatorA +quadB + opperandE + operatorB + quadC);
	}
	
	//used to find absolute value
	//will (maybe) later research (more efficient) absolute value methods
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
	
	//calculates if 2 integers are evenly divisible (A % B = 0)
	public static boolean isDivisibleBy(int opperandA, int opperandB) {
		return ((opperandA % opperandB) == 0);
	}
	
	//finds larger of two given doubles
	public static double a(double opperandA, double opperandB) {
		if (opperandA > opperandB) {
			return(opperandA);
		}else {
			return(opperandB);
		}
	}
	
	//version of max for 3 doubles
	public static double max(double opperandA, double opperandB, double opperandC) {
		if (opperandA >= opperandB && opperandA >= opperandC) {
			return (opperandA);
		}else if(opperandB >= opperandC){
			return (opperandB);
		}else {
			return (opperandC);
		}
	}
	
	//finds smaller of two given integers
	public static int min(int opperandA, int opperandB){
		if (opperandA <= opperandB) {
			return(opperandA);
		}else {
			return(opperandB);
		}
	}
	
	//version of min for doubles
	public static double min(double opperandA, double opperandB){
		if (opperandA <= opperandB) {
			return(opperandA);
		}else {
			return(opperandB);
		}
	}
	
	//rounds a decimal to two decimal places (1.00, 1.23, 5.82, etc)
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
	
	//returns factorial
	//ex: 4! = 4*3*2*1 = 24
	//does not work with negative integers
	public static int factorial (int opperand) {
		int result = opperand;
		if(opperand >= 0) {
			for(int i=1; i<=(opperand-1); i++) {
				result *= i;
			}
		}else{
			result = (Integer)null;
		}
		return result;
	}
	
	//checks if prime, returns boolean
	public static boolean isPrime(int opperand) {
		boolean prime = false;
		//some of the code is a little weird here, but the point is it works and re-writing
		//it would be too much effort to be worth it 
		for(int i=1; i<(opperand-1) ;i++) {
			boolean check = isDivisibleBy(opperand, (i+1));
			if(check == true) {
				prime = true;
			}
		}
		return(prime);
	}
	
	//Finds greatest common factor of two integers
	public static int gcf(int opperandA, int opperandB) {
		int opperandZ = 1;
		if(opperandA > 0 && opperandB > 0) {
			for(int i = 1; opperandA >= i && opperandB >= i; i++) {
				if((isDivisibleBy(opperandA, i)) && (isDivisibleBy(opperandB, i))) {
					opperandZ = i;
				}
			}
		}else if((opperandA < 0 || opperandB < 0)) {
			opperandA = absValue(opperandA);
			opperandB = absValue(opperandB);
			for(int i = 1; opperandA >= i && opperandB >= i; i++) {
				if((isDivisibleBy(opperandA, i)) && (isDivisibleBy(opperandB, i))) {
					opperandZ = i;
				}
			}
		}else if(opperandA == 0 && opperandB == 0) {
			opperandZ = 0;
		}else if(opperandA == 0 && opperandB != 0) {
			opperandZ = opperandB;
		}else if(opperandA != 0 && opperandB ==0) {
			opperandZ = opperandA;
		}
			
		return(opperandZ);
	}
	
	//approximates the square root of a given double
	public static double sqrt(double opperand){
		if(opperand <= 0) {
			return (Double)null;
		}
		
		//maybe there's a better way of doing this, like a rng or something, but I don't have
		//that hypothetical better way so I just have my first test exponent be 1/4 of the
		//input value
		double testExpo = opperand / 4;
		//a for loop would work here, but I wanted to spread it out some so it would be
		//easier to read
		double altExpo = (((opperand / testExpo) + testExpo) / 2);
		while( testExpo - altExpo > .005 || altExpo - testExpo > .005) {
			testExpo = altExpo;
			altExpo = (((opperand / testExpo) + testExpo) / 2);
		}
		return(round2(altExpo));
	}
}
