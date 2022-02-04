package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestMapBoatLanding
{

    @ParameterizedTest
    @CsvSource({"north,Shore", "east,Beach", "south,Shore", "west,Boat"})
    public void TestGenerateTile(String direction, String expectedTileName)
    {
        Map.init();
        Map.move("east"); // Get to Landing
        Map.move(direction);
        Assertions.assertEquals(expectedTileName, Map.getCurrentTile().getTileName());
    }
}
