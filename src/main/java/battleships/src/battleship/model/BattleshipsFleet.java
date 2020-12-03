package battleship.model;

import java.util.ArrayList;

import battleship.BattleshipsConfig;
import battleship.util.Printer;
import battleship.util.RandomNumbers;

/**
 * Class for creating a battleship fleet with a given number of ships.
 * 
 * @author Mareike Röncke
 * @version 1.0, November 2020.
 */

public class BattleshipsFleet {
	int battleshipNumber;
	boolean debugger;
	ArrayList<Battleship> battleships;
	Battleship[][] fleetPositionMatrix;
	String[][] fleetMap;
	int possiblePositions;
	
	public BattleshipsFleet() {
		this.battleshipNumber = BattleshipsConfig.BATTLESHIP_NO;
		this.possiblePositions = BattleshipsConfig.FIELD_SIZE + 1;
		fleetPositionMatrix = new Battleship[possiblePositions][possiblePositions];
		buildBattleshipFleet();
	}
	
	public void buildBattleshipFleet() {
		battleships = new ArrayList<Battleship>();
		for(int shipNoIdx = 0; shipNoIdx < battleshipNumber; shipNoIdx++) {
			int[][] positions = setBattleshipPosition();
			Battleship newShip = new Battleship(BattleshipsConfig.DEBUGGER, positions);
			this.fleetPositionMatrix[positions[0][0]][positions[0][1]] = newShip;
			battleships.add(newShip);
		}
	}
	
	public boolean checkHitShip(int rowIdx, int colIdx) {
		boolean hitShip = false;
		// catch exception when user inputs wrong position
		try {
			if(this.fleetPositionMatrix[rowIdx][colIdx] != null) {
				this.fleetPositionMatrix[rowIdx][colIdx].setBattleshipVisibility(true);
				hitShip = true;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			Printer.userInputError();
		} catch(StringIndexOutOfBoundsException e) {
			Printer.userInputError();
		}
		return hitShip;
	}
	
	public String getShipSymbol(int rowIdx, int colIdx) {
		String shipSymbol = null;
		if(this.fleetPositionMatrix[rowIdx][colIdx] != null) {
			if(this.fleetPositionMatrix[rowIdx][colIdx].getBattleshipVisibility() == true) {
				shipSymbol = this.fleetPositionMatrix[rowIdx][colIdx].getShape();
			}
		}
		return shipSymbol;
	}
	
	private int[][] setBattleshipPosition() {
		int[][] battleshipPositions = new int[1][2]; 
		int addedPositions = 0;
		// put up a ship on a free field
		while(addedPositions < 1) {
			int randomRowIdx = RandomNumbers.generateRandomIntIntRange(1, 3);
			int randomColIdx = RandomNumbers.generateRandomIntIntRange(1, 3);
			if(this.fleetPositionMatrix[randomColIdx][randomRowIdx] == null) {
				battleshipPositions[0][0] = randomColIdx;
				battleshipPositions[0][1] = randomRowIdx;
				addedPositions++;
			}
		}
		return battleshipPositions;
	}

}
