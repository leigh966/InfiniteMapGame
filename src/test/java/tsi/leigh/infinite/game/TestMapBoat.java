package tsi.leigh.infinite.game;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"north", "south", "west"})
    public void testOceanGeneration(String directions)
    {
        Map.init();
        Assertions.assertEquals("You have drowned in the ocean", Map.move(directions));
    }

    @Test
    public void testLandingGeneration()
    {
        Map.init();
        Assertions.assertEquals("Landed onshore", Map.move("East"));
    }
}
