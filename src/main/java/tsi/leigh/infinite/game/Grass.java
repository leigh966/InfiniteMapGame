package tsi.leigh.infinite.game;

public class Grass extends Tile
{
    public String OnEntry()
    {
        return "You have entered another stretch of grassland";
    }

    public String OnReturn()
    {
        return "You have returned to a familiar stretch of grassland";
    }
}
