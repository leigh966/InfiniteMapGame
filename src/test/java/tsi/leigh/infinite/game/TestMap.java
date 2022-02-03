package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMap
{

    @Test
    public void testMoveCaps()
    {
        Map.init();
        int startX = Map.getPosition()[0];
        Map.move("WeSt");
        int newX = Map.getPosition()[0];
        Assertions.assertEquals(startX-1, newX);
    }

    @Test
    public void testPositionMoveWest()
    {
        Map.init();
        int startX = Map.getPosition()[0];
        Map.move("west");
        int newX = Map.getPosition()[0];
        Assertions.assertEquals(startX-1, newX);
    }

    @Test
    public void testPositionMoveEast()
    {
        Map.init();
        int startX = Map.getPosition()[0];
        Map.move("east");
        int newX = Map.getPosition()[0];
        Assertions.assertEquals(startX+1, newX);
    }


    @Test
    public void testPositionMoveNorth()
    {
        Map.init();
        int startY = Map.getPosition()[1];
        Map.move("north");
        int newY = Map.getPosition()[1];
        Assertions.assertEquals(startY+1, newY);
    }

    @Test
    public void testPositionMoveSouth()
    {
        Map.init();
        int startY = Map.getPosition()[1];
        Map.move("south");
        int newY = Map.getPosition()[1];
        Assertions.assertEquals(startY-1, newY);
    }

    @Test
    public void testMoveGiberish()
    {
        Map.init();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {Map.move("blah");});
    }

}
