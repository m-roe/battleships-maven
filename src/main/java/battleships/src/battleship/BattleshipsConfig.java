package battleship;

/**
 * Class to encapsulate globally used variables.
 * 
 * @author Mareike R�ncke
 * @version 1.0, November 2020.
 */

public class BattleshipsConfig {
	
	// Life count for every user playing the game
	public static int LIFES = 3;
	// size of the battlefield (number of rows and columns are even)
	public static int FIELD_SIZE = 5;
	// number of battleships to be found on the field
	public static int BATTLESHIP_NO = 3;
	public static String[] SHIP_SHAPES = {"o", "x", "#", "+", "�"};
	public static final boolean DEBUGGER = false;

}
