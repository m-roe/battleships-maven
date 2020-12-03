package battleship.util;

/**
 * Class for transforming user input to row and column indexes of the battle field.
 * 
 * @author Mareike Röncke
 * @version 1.0, November 2020.
 */

public class Transformer {
	
	public static int transformStringInput(String userInput) {
		char posXChar = userInput.charAt(0);
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int colIdx = alphabet.indexOf(Character.toLowerCase(posXChar)) + 1;
		return colIdx;
	}
	
	public static int transformNumericInput(String userInput) {
		int rowIdx = Character.getNumericValue(userInput.charAt(1));
		return rowIdx;
	}
}
