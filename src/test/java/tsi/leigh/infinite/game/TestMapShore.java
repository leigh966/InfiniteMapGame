package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestMapShore
{
    @ParameterizedTest
    @CsvSource({"north,Shore", "south,Shore", "east,Beach", "west,Ocean"})
    void testGenerateTiles(String direction, String expected)
    {
        Map.init();
        Map.move("east");
        Map.move("north");
        Map.move("north");
        Map.move(direction);
        Assertions.assertEquals(expected, Map.getCurrentTile().getTileName());
    }
}
