package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class TestMapBoatLanding
{

    @ParameterizedTest
    @CsvSource({"north,Shore", "east,Beach", "south,Shore", "west,Boat"})
    void TestGenerateTile(String direction, String expectedTileName)
    {
        Map.init();
        Map.move("east"); // Get to Landing
        Map.move(direction);
        Assertions.assertEquals(expectedTileName, Map.getCurrentTile().getTileName());
    }

    @Test
    void testSearchEmpty()
    {
        ArrayList<Collectable> inventory = new ArrayList<>();
        Tile beach = new BoatLanding();
        String s = beach.search(inventory);
        Assertions.assertTrue(inventory.isEmpty()); // No item should have been added to the inventory
        Assertions.assertEquals("You run your fingers through the sand and find nothing", s);
    }
}
