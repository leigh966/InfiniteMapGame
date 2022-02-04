package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

class TestMapShore
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

    @Test
    void testSearchEmpty()
    {
        ArrayList<Collectable> inventory = new ArrayList<>();
        Tile beach = new Shore();
        String s = beach.search(inventory);
        Assertions.assertTrue(inventory.isEmpty()); // No item should have been added to the inventory
        Assertions.assertEquals("You run your fingers through the sand and find nothing", s);
    }

    @Test
    void testSearchJunk()
    {
        ArrayList<Collectable> inventory = new ArrayList<>();
        Collectable j = new Collectable("junk");
        Tile beach = new Shore(j);
        String s = beach.search(inventory);
        Assertions.assertEquals("junk", inventory.get(0).getItemName());
        Assertions.assertEquals("You run your fingers through the sand and find junk", s);
    }

    @Test
    void testDigEmpty()
    {
        Tile s = new Shore();
        Assertions.assertEquals("You dig and find nothing", s.dig());
    }

    @Test
    void testDigHasSearchable()
    {
        Collectable j = new Collectable("junk");
        Tile s = new Shore(j);
        Assertions.assertEquals("You're about to dig but notice something on the ground", s.dig());

    }

}
