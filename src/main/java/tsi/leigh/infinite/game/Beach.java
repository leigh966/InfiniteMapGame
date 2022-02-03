package tsi.leigh.infinite.game;

public class Beach extends Tile
{
    public Beach()
    {
        entryString = "Found beach";
        returnString = "On a familiar patch of beach";
    }

    // stub
    public Tile GenerateTile()
    {
        return new Beach();
    }
}
