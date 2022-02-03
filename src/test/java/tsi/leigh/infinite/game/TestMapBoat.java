package tsi.leigh.infinite.game;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMapBoat
{
    @Test
    public void testOnEntry()
    {
        String s = Map.init();
        Assertions.assertEquals("Boat washed up on shore",s);
    }

    @Test
    public void testOnReturn()
    {
        Map.init();
        Map.move("east");
        String s = Map.move("west");
        Assertions.assertEquals("Back on the boat", s);
    }
}
