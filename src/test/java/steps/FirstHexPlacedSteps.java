
import javafx.util.Pair;
import org.junit.Assert;

/**
 * Created by Troy on 3/17/17.
 */
public class FirstHexPlacedSteps {

    Board testBoard;
    Hex firstHex;
    Pair<Integer,Integer> testPair;

    @Given("^there are no tiles on the board$")
    public void setup() throws Throwable {
        testBoard = new Board();
        firstHex = new Hex(0, Hex.terrainType.Jungle);
        testPair = new Pair(0,0);

    }

    @When("^the first player places a hex$")
    public void place_first_tile() throws Throwable {
        testBoard.setHex(firstHex, testPair);
    }

    /***
     * TODO
     *
     * When we make a getHex() function, change this acceptance test
     * Change magic numbers for origin to global constant
     *
     * ***/
    @Then("^the first hex should be placed at the origin$")
    public void hex_should_be_in_origin_of_board() throws Throwable {
        boolean hexIsAtOrigin;

        hexIsAtOrigin = ((testBoard.getGameBoardAvailability()[188][188] == true) ? true : false);
        Assert.assertTrue(hexIsAtOrigin);
    }
}
