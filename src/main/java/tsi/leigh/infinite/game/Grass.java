package tsi.leigh.infinite.game;

public class Grass extends Tile
{

    public Grass()
    {
        tileName = "Grass";
        entryString = "Found grassland";
        returnString = "Entered familiar grassland";
    }

    // stub
    public Tile GenerateTile()
    {
        return new Grass();
    }
}
