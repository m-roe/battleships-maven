package battleship.view;

import battleship.BattleshipsConfig;
import battleship.model.BattleshipsFleet;
import battleship.util.Printer;

import java.util.ArrayList;

/**
 * Class for building the play field.
 * 
 * @author Mareike Röncke
 * @version 1.0, November 2020.
 */

public class BattleshipsField {
	public int fieldSize;
	public boolean debugMode;
	public int actualFields;
	public int battleshipNumber;
	public ArrayList<String> hitFields = new ArrayList<String>();
	BattleshipsFleet fleet;
	
	public BattleshipsField(BattleshipsFleet fleet) {
		this.fieldSize = BattleshipsConfig.FIELD_SIZE;
		this.actualFields = fieldSize + 1;
		this.fleet = fleet;
	}
	
	public void setupBattleField() {
		setupBattleFieldMatrix();
	}
	
	private void setupBattleFieldMatrix() {
		for(int rowIdx = 0; rowIdx < this.actualFields; rowIdx++) {
			setBattleFieldRows(rowIdx);
		}
	}
	
	private void setBattleFieldRows(int rowIdx) {
		if(rowIdx == 0) {
			// sets the first row aka column header (filles with alphabet characters)
			setHeaderRow();
		} else {
			// sets all subsequent rows (either row headers if its the first cell or potential ship cells)
			setFieldRow(rowIdx);
		}
	}
	
	private void setHeaderRow() {
		// position 0/0 (top left position) is always an empty space	
		Printer.printEmptySpace();
		setColumnHeaderCell();
		Printer.printHorizontalSeparator(this.fieldSize);
	}
	
	private void setColumnHeaderCell() {
		// Column headers a subsequent characters (beginning with 'A')
		traverseColumnHeaderTitle('A', 0);
	}
	
	private void traverseColumnHeaderTitle(char character, int counter) {
		Printer.printColumnTitle(character);
		character++;
		counter++;
		if(counter < this.fieldSize) {
		 	traverseColumnHeaderTitle(character, counter);
		}
	}
	
	private void setFieldRow(int rowIdx) {
		// first cell in a field row has to have a title (e.g. 1)
		setRowHeader(rowIdx);
		setRowCells(rowIdx);
		Printer.printHorizontalSeparator(this.fieldSize);
	}
	
	private void setRowHeader(int rowIdx) {
		// Row titles are subsequent numbers
		String rowHeaderTitle = transform2RowHeaderTitle(rowIdx);
		Printer.printRowTitle(rowHeaderTitle);
	}
	
	private String transform2RowHeaderTitle(int rowIdx) {
		String rowHeaderStr = Integer.toString(rowIdx);
		return rowHeaderStr;
	}
	
	private void setRowCells(int rowIdx) {
		for(int colIdx = 1; colIdx < this.actualFields; colIdx++) {
			// check if the cell contains a ship
			String symbol = this.fleet.getShipSymbol(rowIdx, colIdx);
			if(symbol != null) {
				Printer.printFilledCell(symbol);
			} else {
				Printer.printEmptyCell();
			}
		}
	}

}
