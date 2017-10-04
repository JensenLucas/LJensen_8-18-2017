//Code from the Collaborative Programming Exercise
//Programmer 1: Lucas Jensen
//Programmer 2: Mandy Woo
//Takes input numbers and returns the smallest, largest, sum of all evens, and largest even
import java.util.*;
public class Collab_exercise {
	public static void main(String[] args) {
		int sum = 0;
		int largestEvenInt = 0;
		//this was the best way I could come up with on short notice to make sure I could get an
		//even number through properly
		boolean even_Check = true;
		boolean done = false;
		Scanner input = new Scanner(System.in);
		System.out.println("Input an integer: ");
		int firstNum = input.nextInt();
		int smallestInt = firstNum;
		int largestInt = firstNum;		
		if(firstNum % 2 == 0) {
			largestEvenInt = firstNum;
		}
		while(!done) {
			System.out.println("Input an integer: ");
			int userNum = input.nextInt();
			if(userNum > largestInt) {
				largestInt = userNum;
			}else if(userNum < smallestInt){
				smallestInt = userNum;
			}
			if(userNum % 2 == 0) {
				sum += userNum;
				if(userNum > largestEvenInt){
					largestEvenInt = userNum;
				}else if(even_Check){
					largestEvenInt = userNum;
					even_Check = false;
				}
			}
			System.out.println("Done yet? ");
			String finished = input.next();
			if(finished.equals("yes")){
				done = true;
			}
		}
		System.out.println("Smallest number : " + smallestInt);
		System.out.println("Largest number: " + largestInt);
		System.out.println("Sum of even numbers: " + sum);
		if(!even_Check) {
			System.out.println("Largest even number: " + largestEvenInt);
		}
	}
}
