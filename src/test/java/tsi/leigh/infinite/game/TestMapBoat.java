package tsi.leigh.infinite.game;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class TestMapBoat
{
    @Test
    void testOnEntry()
    {
        String s = Map.init();
        Assertions.assertEquals("Boat washed up on shore",s);
    }

    @Test
    void testOnReturn()
    {
        Map.init();
        Map.move("east");
        String s = Map.move("west");
        Assertions.assertEquals("Back on the boat", s);
    }

    @ParameterizedTest
    @ValueSource(strings = {"north", "south", "west"})
    void testOceanGeneration(String directions)
    {
        Map.init();
        Assertions.assertEquals("You have drowned in the ocean", Map.move(directions));
    }

    @Test
    void testLandingGeneration()
    {
        Map.init();
        Assertions.assertEquals("Landed onshore", Map.move("East"));
    }


    @Test
    void testSearchEmpty()
    {
        ArrayList<Collectable> inventory = new ArrayList<>();
        Tile boat = new Boat();
        String s = boat.search(inventory);
        Assertions.assertTrue(inventory.isEmpty()); // No item should have been added to the inventory
        Assertions.assertEquals("You have already picked up everything useful", s);
    }

    @Test
    void testSearchJunk()
    {
        ArrayList<Collectable> inventory = new ArrayList<>();
        Collectable j = new Collectable("junk");
        Tile boat = new Boat(j);
        String s = boat.search(inventory);
        Assertions.assertEquals("junk", inventory.get(0).getItemName());
        Assertions.assertEquals("You pick up your trusty junk", s);
    }
}
