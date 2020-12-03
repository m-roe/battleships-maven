package battleship.util;

import java.util.Random;

/**
 * Class for creating a random number within a range.
 * 
 * @author Mareike R�ncke
 * @version 1.0, November 2020.
 */

public class RandomNumbers {
	
	public static int generateRandomIntIntRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min + 1)) + min;
	}

}
