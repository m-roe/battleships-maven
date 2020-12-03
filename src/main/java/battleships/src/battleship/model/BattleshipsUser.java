package battleship.model;

import java.util.ArrayList;

/**
 * Class for creating a user with a given number of lifes.
 * 
 * @author Mareike Röncke
 * @version 1.0, November 2020.
 */

import battleship.BattleshipsConfig;

public class BattleshipsUser {
	int lifes;
	public ArrayList<String> hitFields;
	
	public BattleshipsUser()  {
		this.lifes = BattleshipsConfig.LIFES;
		this.hitFields = new ArrayList<String>();
	}
	
	public void succeeded(String input) {
		addLife(1);
		addField(input);
	}
	
	public void failed() {
		removeLife(1);
	}
	
	public boolean hasLifes() {
		boolean hasLifes = true;
		if(this.lifes == 0) {
			hasLifes = false;
		}
		return hasLifes;
	}
	
	public int getLifeCount() {
		return this.lifes;
	}
	
	public ArrayList<String> getHitFields() {
		return this.hitFields;
	}
	
	private void addLife(int newLife) {
		this.lifes = this.lifes + newLife;
	}
	
	private void removeLife(int newLife) {
		this.lifes = this.lifes - newLife;
	}
	
	private void addField(String newField) {
		this.hitFields.add(newField);
	}

}
