package tsi.leigh.infinite.game;

public class Shore extends Beach
{
    public Shore()
    {
        entryString = "On the shore with nothing but ocean to the west";
        returnString = "Back at the shore";
    }

    // stub
    public Tile GenerateTile()
    {
        return new Shore();
    }

}
