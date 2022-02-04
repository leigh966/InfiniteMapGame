package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestMain
{
    @ParameterizedTest
    @CsvSource({"go east,y","Head south,y", "walk WEST,y", "head North,y", "hed west,Invalid Command", "walk wes,e"})
    void testParseMoveAccepts(String command, String expected)
    {
        Map.init();
        String output = "";
        try
        {
            output = Main.parse(command);
        }
        catch(IllegalArgumentException IAE) {
            Assertions.assertTrue(expected.equals("e")); // We were expecting this
            return;
        }
        if(expected.equals("y"))
        {
            Assertions.assertNotEquals("Invalid command", output);
        }
        else
        {
            Assertions.assertEquals("Invalid command", output);
        }
    }



}
