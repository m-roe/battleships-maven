package battleship.controller;

import battleship.BattleshipsConfig;
import battleship.model.BattleshipsFleet;
import battleship.model.BattleshipsUser;
import battleship.util.Printer;
import battleship.util.Transformer;
import battleship.view.BattleshipsField;

/**
 * Class containing control flow of the game.
 * 
 * @author Mareike Röncke
 * @version 1.0, November 2020.
 */

public class BattleshipsNavigator {
	int possiblePositions;
	String userInput;
	BattleshipsFleet fleet;
	BattleshipsField battleField;
	BattleshipsUser newUser;
	
	public BattleshipsNavigator() {
		Printer.printGameTitle();
		showUserMenu();
		setupBattleshipGame();
	}
	
	public void setupBattleshipGame() {
		boolean gameIsOn = true;
		this.fleet = new BattleshipsFleet();
		this.newUser = new BattleshipsUser();
		battleField = new BattleshipsField(this.fleet);
		while(gameIsOn) {
			showCurrentGame();
			processUserInput(this.userInput);
			gameIsOn = checkGameState();
		} 
		showCurrentGame();
		boolean success = checkUserSuccess();
		Printer.printEndMsg(success);
	}
	
	private void showUserMenu() {
		int number;
		do {
			System.out.println("Input a number between 2 and 10 as game field size: ");
		    number = BattleshipsInput.consoleInputInt();
		} while ((number > 2) && (number > 10));
		BattleshipsConfig.FIELD_SIZE = number;
		// number of battleships to be found on the field
		BattleshipsConfig.BATTLESHIP_NO = BattleshipsConfig.FIELD_SIZE;
		Printer.printFieldInfo();
		System.out.println();
	}
	
	private void showCurrentGame() {
		Printer.printLifes(this.newUser.getLifeCount());
		Printer.printHits(this.newUser.getHitFields());
		battleField.setupBattleField();
		this.userInput = requestPositionInput();
	}
	
	private String requestPositionInput() {
		System.out.println("Input position (e.g. 'A1'): ");
		String userInput = BattleshipsInput.consoleInputStr();
		return userInput;
	}
	
	private void processUserInput(String userInput) {
		int colIdx = Transformer.transformStringInput(userInput);
		int rowIdx = Transformer.transformNumericInput(userInput);
		boolean hitShip = this.fleet.checkHitShip(rowIdx, colIdx);
		if(hitShip == true) {
			this.newUser.succeeded(userInput);
		} else {
			this.newUser.failed();
		}
	}
	
	private boolean checkGameState() {
		boolean continueGame = false;
		boolean userHasLifes = this.newUser.hasLifes();
		boolean userWonGame = checkUserSuccess();
		if((userHasLifes) && (userWonGame == false)) {
			continueGame = true;
		}
		return continueGame;
	}
	
	private boolean checkUserSuccess() {
		boolean success = false;
		int numOfHitFields = this.newUser.getHitFields().size();
		if(numOfHitFields == BattleshipsConfig.BATTLESHIP_NO) {
			success = true;
		}
		return success;
	}
	
}
