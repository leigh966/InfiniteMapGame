package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestMap
{

    @Test
    void testMoveCaps()
    {
        Map.init();
        int startX = Map.getPosition()[0];
        Map.move("WeSt");
        int newX = Map.getPosition()[0];
        Assertions.assertEquals(startX-1, newX);
    }

    @Test
    void testPositionMoveWest()
    {
        Map.init();
        int startX = Map.getPosition()[0];
        Map.move("west");
        int newX = Map.getPosition()[0];
        Assertions.assertEquals(startX-1, newX);
    }

    @Test
    void testPositionMoveEast()
    {
        Map.init();
        int startX = Map.getPosition()[0];
        Map.move("east");
        int newX = Map.getPosition()[0];
        Assertions.assertEquals(startX+1, newX);
    }


    @Test
    void testPositionMoveNorth()
    {
        Map.init();
        int startY = Map.getPosition()[1];
        Map.move("north");
        int newY = Map.getPosition()[1];
        Assertions.assertEquals(startY+1, newY);
    }

    @Test
    void testPositionMoveSouth()
    {
        Map.init();
        int startY = Map.getPosition()[1];
        Map.move("south");
        int newY = Map.getPosition()[1];
        Assertions.assertEquals(startY-1, newY);
    }

    @Test
    void testMoveGiberish()
    {
        Map.init();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {Map.move("blah");});
    }

}
