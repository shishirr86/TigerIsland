import javafx.util.Pair;
import org.junit.After;
import org.junit.*;

/**
 * Created by WIIZZARD on 3/19/2017.
 */
public class HexValidationTest {
    Board gameBoard;

    @Before
    public void setUp() throws Exception {
        gameBoard = new Board();
    }

    @After
    public void tearDown() throws Exception {
        gameBoard = null;
    }

    @Test
    public void existsAdjacentHexSuccessTest() {
        Hex firstHex = new Hex(0, Terrain.terrainType.Jungle);
        Pair<Integer, Integer> hex1Loc = new Pair(0, 0);
        gameBoard.setHex(firstHex, hex1Loc);

        Integer firstHexLocX = firstHex.getLocation().getKey();
        Integer firstHexLocY = firstHex.getLocation().getValue();
        Integer secondHexLocX = firstHexLocX + Orientation.UPLEFT.getKey();
        Integer secondHexLocY = firstHexLocY + Orientation.UPLEFT.getValue();

        Pair<Integer, Integer> hex2Loc = new Pair(secondHexLocX, secondHexLocY);


        Assert.assertEquals("adjacencyValidationSuccessTest", true, HexValidation.existsAdjacentHex(hex2Loc, gameBoard));
    }

    @Test
    public void existsAdjacentHexFailureTest() {
        Hex firstHex = new Hex(0, Terrain.terrainType.Jungle);
        Pair<Integer, Integer> hex1Loc = new Pair(0, 0);
        gameBoard.setHex(firstHex, hex1Loc);

        Integer firstHexLocX = firstHex.getLocation().getKey();
        Integer firstHexLocY = firstHex.getLocation().getValue();
        Integer secondHexLocX = firstHexLocX + Orientation.UPLEFT.getKey() + Orientation.UPLEFT.getKey();
        Integer secondHexLocY = firstHexLocY + Orientation.UPLEFT.getValue() + Orientation.UPLEFT.getValue();

        Pair<Integer, Integer> hex2Loc = new Pair(secondHexLocX, secondHexLocY);


        Assert.assertEquals("adjacencyValidationFailureTest", false, HexValidation.existsAdjacentHex(hex2Loc, gameBoard));
    }

    @Test
    public void isValidVolcanoPlacementSuccessTest() {
        Hex firstHex = new Hex(0, Terrain.terrainType.Volcano);
        Pair<Integer, Integer> hex1Loc = new Pair(0, 0);
        gameBoard.setHex(firstHex, hex1Loc);

        Integer secondHexLocX = firstHex.getLocation().getKey();
        Integer secondHexLocY = firstHex.getLocation().getValue();

        Pair<Integer, Integer> hex2Loc = new Pair(secondHexLocX, secondHexLocY);

        Hex secondHex = new Hex(0, Terrain.terrainType.Volcano);


        Assert.assertEquals("terrainValidationSuccessTest", true, HexValidation.isValidVolcanoPlacement(secondHex, hex2Loc, gameBoard));

    }

    @Test
    public void isValidVolcanoPlacementFailureTest() {
        Hex firstHex = new Hex(0, Terrain.terrainType.Volcano);
        Pair<Integer, Integer> hex1Loc = new Pair(0, 0);
        gameBoard.setHex(firstHex, hex1Loc);

        Integer secondHexLocX = firstHex.getLocation().getKey();
        Integer secondHexLocY = firstHex.getLocation().getValue();

        Pair<Integer, Integer> hex2Loc = new Pair(secondHexLocX, secondHexLocY);

        Hex secondHex = new Hex(0, Terrain.terrainType.Rocky);


        Assert.assertEquals("terrainValidationFailureTest", false, HexValidation.isValidVolcanoPlacement(secondHex, hex2Loc, gameBoard));


    }
    @Test
    public void isValidVolcanoPlacementGenericSuccessTest() {
        Hex firstHex = new Hex(0, Terrain.terrainType.Jungle);
        Pair<Integer, Integer> hex1Loc = new Pair(0, 0);
        gameBoard.setHex(firstHex, hex1Loc);

        Integer secondHexLocX = firstHex.getLocation().getKey();
        Integer secondHexLocY = firstHex.getLocation().getValue();

        Pair<Integer, Integer> hex2Loc = new Pair(secondHexLocX, secondHexLocY);

        Hex secondHex = new Hex(0, Terrain.terrainType.Rocky);


        Assert.assertEquals("terrainValidationSuccessTest", true, HexValidation.isValidVolcanoPlacement(secondHex, hex2Loc, gameBoard));

    }
    @Test
    public void isValidVolcanoPlacementGenericTerrainFailureTest() {
        Hex firstHex = new Hex(0, Terrain.terrainType.Jungle);
        Pair<Integer, Integer> hex1Loc = new Pair(0, 0);
        gameBoard.setHex(firstHex, hex1Loc);

        Integer secondHexLocX = firstHex.getLocation().getKey();
        Integer secondHexLocY = firstHex.getLocation().getValue();

        Pair<Integer, Integer> hex2Loc = new Pair(secondHexLocX, secondHexLocY);

        Hex secondHex = new Hex(0, Terrain.terrainType.Volcano);


        Assert.assertEquals("terrainValidationSuccessTest", true, HexValidation.isValidVolcanoPlacement(secondHex, hex2Loc, gameBoard));

    }



}