package battleship.model;

import battleship.BattleshipsConfig;
import battleship.util.RandomNumbers;

/**
 * Class for creating a single battleship instance.
 * 
 * @author Mareike Röncke
 * @version 1.0, November 2020.
 */

public class Battleship {
	int[][] battleshipPositions;
	boolean isVisible;
	String[] shipShapes;
	String customShape;
	
	public Battleship(boolean visibility, int[][] battleshipPositions) {
		this.battleshipPositions = battleshipPositions;
		this.isVisible = visibility;
		this.shipShapes = BattleshipsConfig.SHIP_SHAPES;
		setRandomShape();
		setBattleshipVisibility(visibility);
	}
	
	public void showBattleship() {
		setBattleshipVisibility(true);
	}
	
	public int[][] getBattleshipPositions() {
		return this.battleshipPositions;
	}
	
	public void setBattleshipVisibility(boolean visibility) {
		this.isVisible = visibility;
	}
	
	public boolean getBattleshipVisibility() {
		return this.isVisible;
	}
	
	public String getShape() {
		return this.customShape;
	}
	
	private void setRandomShape() {
		int randomShape = RandomNumbers.generateRandomIntIntRange(0, (this.shipShapes.length- 1));
		setShape(shipShapes[randomShape]);
	}
	
	private void setShape(String shape) {
		this.customShape = shape;
	}
	
}
