package tsi.leigh.infinite.game;

public class Grass extends Tile
{
    public Grass()
    {
        entryString = "Found grassland";
        returnString = "Entered familiar grassland";
    }

    // stub
    public Tile GenerateTile()
    {
        return new Grass();
    }
}
