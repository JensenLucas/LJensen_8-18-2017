package textExcel;

import java.io.FileNotFoundException;
import java.util.*;
// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Spreadsheet cat = new Spreadsheet();
		System.out.println(cat.getGridText());
		
		
		//Test code
		//String neko = "nya";
		//cat.processCommand("A1 = \"Cat is very nice I like cat\"");
		//cat.processCommand("A2 = \""+ neko + "\"");
		cat.processCommand("A1 = \"" + 1234444444.0 + "\"");
		System.out.println(cat.getGridText());
		System.out.println(cat.processCommand("A1"));
		//String greeting = "ThisIsALongString";
        //cat.processCommand("A1 = \"" + greeting + "\"");
        //System.out.println(cat.getGridText());
        //System.out.println(cat.processCommand("A1"));
        //System.out.println(cat.processCommand("Clear A1"));
        //cat.processCommand("B1 = \"cats are the best \"");
        //System.out.println(cat.processCommand("B1"));
        //System.out.println(cat.getGridText());
        //System.out.println(cat.processCommand("A1 = ( 1 * 2 / 1 + 3 - 5 )"));
		/* System.out.println(cat.processCommand("A1 = meow"));
		System.out.println(cat.processCommand("Clear"));
		cat.processCommand("A1 = meow");
		System.out.println(cat.processCommand("A2 = meow"));
		System.out.println(cat.processCommand("Clear"));*/
		
		
		
		//TestsALL.Helper th = new TestsALL.Helper();
		//System.out.println(th.getText());
		/*Scanner userInput = new Scanner(System.in);
	    boolean check = true;
		while(check) {
	    	System.out.println("Would you like to quit? If so, enter \"QUIT\"");
	    	String input = userInput.nextLine();
	    	if(input.equalsIgnoreCase("quit")) {
	    		check = false;
	    		System.out.println("Program ended");
	    	}
	    }*/
	}
}
