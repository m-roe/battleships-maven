package battleship;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BattleshipsConfigTest {

    @Test
    public void ConfigFieldsAndShipsTest() {
    	// BattleshipsConfig.FIELD_SIZE = 3;
    	// BattleshipsConfig.BATTLESHIP_NO = 10;
        int acutalFields = BattleshipsConfig.FIELD_SIZE * BattleshipsConfig.FIELD_SIZE;
        String failMsg = "There are more ships (" + BattleshipsConfig.BATTLESHIP_NO + ")" +
        "than actual fields (" + acutalFields + ") defined in the configuration file.";
        assertTrue(acutalFields > BattleshipsConfig.BATTLESHIP_NO, failMsg);
    }

    @Test
    public void ConfigLifesTest() {
        // BattleshipsConfig.LIFES = 0;
        String failMsg = "Please input a life count greater than 0 in the configuration file.";
        assertTrue(BattleshipsConfig.LIFES > 0, failMsg);
    }

    @Test
    public void ConfigShipSymbolsTest() {
        // BattleshipsConfig.SHIP_SHAPES = new String[0];
        int shipSymbolLength = BattleshipsConfig.SHIP_SHAPES.length;
        String failMsg = "Please input ship symbols in the configuration file.";
        assertTrue(shipSymbolLength > 0, failMsg);
    }
}