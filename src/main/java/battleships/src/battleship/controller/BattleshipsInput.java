package battleship.controller;
import java.util.Scanner;

/**
 * Class containing user input scanner from the console.
 * 
 * @author Mareike Röncke
 * @version 1.0, November 2020.
 */

public class BattleshipsInput {
	
	public static String consoleInputStr() {
		Scanner input = new Scanner(System.in);
		String inputStr = input.nextLine();
		return inputStr;
	}
	
	public static int consoleInputInt() {
		Scanner input = new Scanner(System.in);
		int inputInt = input.nextInt();
		return inputInt;
	}
	
}
