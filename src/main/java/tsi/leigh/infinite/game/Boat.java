package tsi.leigh.infinite.game;

public class Boat extends Tile
{
    public Boat()
    {
        entryString = "Boat washed up on shore";
        returnString = "Back on the boat";
    }

    // stub
    public Tile GenerateTile()
    {
        return new Grass();
    }
}
