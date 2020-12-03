package battleship.util;
import java.util.ArrayList;

import battleship.BattleshipsConfig;

/**
 * Class for printing battleship field components on the console.
 * 
 * @author Mareike Röncke
 * @version 1.0, November 2020.
 */

public class Printer {
	
	public static void printVisibleVerticalSeparator() {
		System.out.print("|");
	}
	
	public static void printInvisibleVerticalSeparator() {
		System.out.print(" ");
	}
	
	public static void printHorizontalSeparator(int separatorLength) {
		System.out.println();
		System.out.print("   ");
		for(int k = 0; k < separatorLength; k++) {				
			System.out.print("----");
		}
		System.out.println();
	}
	
	public static void printEmptySpace() {
		System.out.print("   ");
	}
	
	public static void printEmptyCell() {
		System.out.print("   |");
	}
	
	public static void printFilledCell(String symbol) {
	 	System.out.print(" ");
	 	System.out.print(symbol);
	 	System.out.print(" |");
	}
	
	public static void printFilledCell(char symbol) {
	 	System.out.print("| ");
	 	System.out.print(symbol);
	 	System.out.print(" ");
	}
	
	public static void printColumnTitle(String symbol) {
	 	System.out.print(" ");
	 	System.out.print(symbol);
	 	System.out.print(" |");
	}
	
	public static void printColumnTitle(char symbol) {
	 	System.out.print(" ");
	 	System.out.print(symbol);
	 	System.out.print(" |");
	}
	
	public static void printRowTitle(String symbol) {
	 	System.out.print(" ");
	 	System.out.print(symbol);
	 	System.out.print(" ");
	}
	
	public static void printRowTitle(char symbol) {
	 	System.out.print(" ");
	 	System.out.print(symbol);
	 	System.out.print(" ");
	}
	
	public static void printGameTitle() {
		printTitleSeparator();
		System.out.println("~~~~~~~~~ BATTLESHIPS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printTitleSeparator();
		System.out.println();
	}
	
	public static void printEndMsg(boolean success) {
		String msg;
		if(success == true) {
			msg = "YOU WON !";
		} else {
			msg = "GAME OVER";
		}
		printTitleSeparator();
		System.out.println("~~~~~~~~~ " + msg + " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printTitleSeparator();
	}
	
	public static void printLifes(int lifes) {
		System.out.println("Lifes: " + lifes);
		System.out.println();
	}
	
	public static void printHits(ArrayList<String> hitFields) {
		for(int i = 0; i < hitFields.size(); i++) {
			System.out.println(hitFields.get(i) + ": You sank my battleship!");
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printTitleSeparator() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	
	public static void printFieldInfo() {
		System.out.println("Thank you! Your game field will be " + BattleshipsConfig.FIELD_SIZE + " * " + BattleshipsConfig.FIELD_SIZE);
		System.out.println("There will be " + BattleshipsConfig.BATTLESHIP_NO + " invisible ships on the battlefield.");
	}
	
	public static void userInputError() {
		System.out.println("Please input a valid battlefield position.");
		System.out.println("Valid positions are ... ");
		char character = 'A';
		for(int i = 0; i < BattleshipsConfig.FIELD_SIZE; i++) {
			System.out.print(character + ", ");
			character++;
		}
		System.out.print("for columns and ");
		for(int i = 0; i < BattleshipsConfig.FIELD_SIZE; i++) {
			int row = i + 1;
			System.out.print(row + ", ");
		}
		System.out.println("for rows.");
		System.out.println();
	}
	
}
