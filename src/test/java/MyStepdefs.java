import cucumber.api.PendingException;
import javafx.util.Pair;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

/**
 * Created by Joe on 3/18/17.
 */
public class MyStepdefs {

    Board testBoard;
    GameAPI testAPI;
    HexValidation validate;
    Hex testHex;
    Tile testTile;
    Tuple testPair;

    @Given("^there are no hexes on the board")
    public void setupBoardForHexTest () throws Throwable {
      testBoard = new Board();
      testHex = new Hex(0, Terrain.terrainType.Jungle);
      testPair = Orientation.getOrigin();

    }

    @When("^the first player places a hex")
    public void place_first_hex () throws Throwable {
      testBoard.setHex(testHex, testPair);
    }

    /***
     * TODO
     *
     * When we make a getHex() function, change this acceptance test
     * Change magic numbers for origin to global constant
     *
     * ***/
    @Then("^the first hex should be placed at the origin")
    public void hex_should_be_in_origin_of_board () throws Throwable {

      Assert.assertTrue(!testBoard.isOriginEmpty());
    }

    // @Given definition will be reworked once our program supports turn functionality
    @Given("^the game is being played")
    public void setupTile () throws Throwable {
        testBoard = new Board();
    }

    @When("^i draw a tile")
    public void createTile () throws Throwable {
        Terrain.terrainType terrainLeft = Terrain.terrainType.Grassland;
        Terrain.terrainType terrainRight = Terrain.terrainType.Lake;
        Orientation.Orientations leftOrientation = Orientation.Orientations.downLeft;
        testTile = new Tile(1,terrainLeft,terrainRight,leftOrientation);
    }

    @Then("^i should have a tile composed of 3 hexes joined together with one being a volcano")
    public void tile_should_be_composed_of_three_hexagons () throws Throwable {
        Assert.assertEquals("verify tileId",testTile.getTileId(),1);
        Assert.assertEquals("verify a volcano hex", testTile.getVolcano().getTerrain(), Terrain.terrainType.Volcano);
        Assert.assertEquals("verify getLeft", testTile.getLeft().getTerrain(), Terrain.terrainType.Grassland);
        Assert.assertEquals("verify getRight", testTile.getRight().getTerrain(), Terrain.terrainType.Lake);
    }

//    @Given("^there are no tiles on the board")
//    public void setupBoardForTileTest () throws Throwable {
//        testAPI = new GameAPI();
//        Terrain.terrainType terrainLeft = Terrain.terrainType.Grassland;
//        Terrain.terrainType terrainRight = Terrain.terrainType.Lake;
//        Orientation.Orientations leftOrientation = Orientation.Orientations.downLeft;
//        testTile = new Tile(1,terrainLeft,terrainRight,leftOrientation);
//        testPair = Orientation.getOrigin();
//
//    }
//
//    @When("^the first player places a tile")
//    public void place_first_tile () throws Throwable {
//        testAPI.placeTile(testTile, testPair);
//    }
//
//    @Then("^the first tile should be placed at the origin in whatever orientation the player chooses")
//    public void tile_should_be_in_origin_of_board () throws Throwable {
//        Assert.assertTrue(testAPI.gameBoard.getGameBoardAvailability()[188][188]);
//        Assert.assertTrue(testAPI.gameBoard.getGameBoardAvailability()[186][187]);
//        Assert.assertTrue(testAPI.gameBoard.getGameBoardAvailability()[186][189]);
//    }

    // TODO: MAX FIX THIS
//    @Given("^there is already a hex on the board")
//    public void setupBoardForHexValidationPassingTest () throws Throwable {
//        testBoard = new Board();
//        validate = new HexValidation();
//        testHex = new Hex(0, Terrain.terrainType.Jungle);
//        testPair = Orientation.getOrigin();
//        testBoard.setHex(testHex, testPair);
//    }
//
//    @When("^a player tries to place another hex in a valid placement position")
//    public void place_hex_in_valid_position () throws Throwable {
//        Hex hexToPlace = new Hex(1, Terrain.terrainType.Lake);
//
//        Tuple firstHexLoc = testHex.getLocation();
//        Tuple hex2Loc = Orientation.upLeftOf(firstHexLoc);
//
//        if(validate.existsAdjacentHex(hex2Loc, testBoard))
//            testBoard.setHex(hexToPlace, hex2Loc);
//    }
//
//    @Then("^the hex will be placed on the board")
//    public void hex_should_be_placed () throws Throwable {
//        Assert.assertTrue(testBoard.getGameBoardAvailability()[190][187]);
//    }

//    @Given("^there is already a hex placed on the board")
//    public void setupBoardForHexValidationFailingTest () throws Throwable {
//        testBoard = new Board();
//        validate = new HexValidation();
//        testHex = new Hex(0, Terrain.terrainType.Jungle);
//        testPair = Orientation.getOrigin();
//        testBoard.setHex(testHex, testPair);
//    }
//
//    @When("^a player tries to place another hex in a invalid placement position")
//    public void place_hex_in_invalid_position () throws Throwable {
//        Hex hexToPlace = new Hex(1, Terrain.terrainType.Lake);
//
//        Tuple firstHexLoc = testHex.getLocation();
//        Tuple hex2Loc = Orientation.upLeftOf(Orientation.upLeftOf(firstHexLoc));
//
//        if(validate.existsAdjacentHex(hex2Loc, testBoard))
//            testBoard.setHex(hexToPlace, hex2Loc);
//    }
//
//    @Then("^the hex will be not placed on the board")
//    public void hex_should_not_be_placed () throws Throwable {
//        Assert.assertFalse(testBoard.getGameBoardAvailability()[190][187]);
//
//    }
}
