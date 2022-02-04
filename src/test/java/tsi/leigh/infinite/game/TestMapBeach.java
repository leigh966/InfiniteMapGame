package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestMapBeach
{
    // Tests that the correct tiles are being generated either side of the beach line
    @ParameterizedTest
    @CsvSource({"2,north,Beach", "2,south,Beach", "3,east,Grass", "3,west,Beach"})
    void testGenerateTileGuarenteed(int x, String direction, String expected)
    {
        Map.init();
        for(int i = 0; i < x; i++)
        {
            Map.move("east");
        }
        Map.move(direction);
        Assertions.assertEquals(expected, Map.getCurrentTile().getTileName());
    }

    @Test
    void testLineHasBoth()
    {
        Map.init();
        Boolean hasBeach = false, hasGrass = false;

        for(int x = 0; x < 3; x++) // Get to x = 3
        {
            Map.move("east");
        }

        Assertions.assertEquals(3, Map.getPosition()[0]);

        for(int y = 0; y <= 5000; y++)
        {
            String tileName = Map.getCurrentTile().getTileName();
            hasBeach = hasBeach || tileName.equals("Beach");
            hasGrass = hasGrass || tileName.equals("Grass");
            if(hasGrass && hasBeach) break;
            Map.move("south");
        }

        Assertions.assertTrue(hasBeach && hasGrass);

    }

    @Test
    void testLineOnlyGrassAndBeach()
    {
        Map.init();

        for(int x = 0; x < 3; x++) // Get to x = 3
        {
            Map.move("east");
        }

        Assertions.assertEquals(3, Map.getPosition()[0]);

        for(int y = 0; y <= 5000; y++)
        {
            String tileName = Map.getCurrentTile().getTileName();
            Assertions.assertTrue(tileName.equals("Beach") || tileName.equals("Grass"));
            Map.move("south");
        }
    }
}
