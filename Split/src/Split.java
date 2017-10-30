//Lucas Jensen
//10-27-2017
//Split stuff
//Only mostly complete (further debugging would be ideal) but I reached the deadline.

import java.util.*;

public class Split {
	public static void main (String[] args) {
		//Part 1
		/*System.out.println(Arrays.toString("I like apples!".split(" ")));
//			it will split at spaces and return an array of ["I","like","apples!"]
		System.out.println(Arrays.toString("I really like really red apples".split("really")));
//			it will split at the word "really" and return an array of ["I "," like "," red apples!"]
		//play around with String.split! 
		System.out.println(Arrays.toString("I reallyreally likeapples".split("really"))); //Testing 2 "really"s
		*/
		
		//Part 2
		System.out.println(filling("breadcheesepotatobreadcakebread"));
		System.out.println(filling("breadbreadtomatobread"));
		System.out.println(filling("applespineapplesbreadlettustomatobaconmayohambreadcheese"));
		System.out.println(filling("checkbreadtestbreadpiebreadthirdbreadcheck"));
		
		//part 3
		System.out.println(fillingAlt("apples pineapples bread lettus tomato bacon mayo ham bread cheese"));
	}
	//cuts out bread and (usually) gives the filling
	//only kind of works (I'm out of time)
	public static String filling(String sandwhich) {
		String[] operand = (sandwhich).split("bread");
		if(operand.length < 2) {
			return("Invalid sandwhich");
		}
		String fillings = ("");
		for(int i=1; i<operand.length-1; i++) {
			fillings += operand[i];
		}
		
		return(fillings);
	}
	
	//filling, but also cuts out spaces
	//normally I would give more descriptive names, but I really don't feel like it
	public static String fillingAlt(String sandwhich) {
		String[] operand = (sandwhich).split(" ");
		//I'm aware, bad variable/method names
		//Too lazy to change (it mostly works anyways)
		String fillings = filling(Arrays.toString(operand));
		return(fillings);
		
	}
}
