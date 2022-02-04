package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestMapGrass
{
    @Test
    void testSearchEmpty()
    {
        ArrayList<Collectable> inventory = new ArrayList<>();
        Tile beach = new Grass();
        String s = beach.search(inventory);
        Assertions.assertTrue(inventory.isEmpty()); // No item should have been added to the inventory
        Assertions.assertEquals("You scour the grass but find nothing", s);
    }

    @Test
    void testSearchJunk()
    {
        ArrayList<Collectable> inventory = new ArrayList<>();
        Collectable j = new Collectable("junk");
        Tile beach = new Grass(j);
        String s = beach.search(inventory);
        Assertions.assertEquals("junk", inventory.get(0).getItemName());
        Assertions.assertEquals("You scour the grass and find junk", s);
    }



}
