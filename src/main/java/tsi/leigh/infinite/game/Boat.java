package tsi.leigh.infinite.game;

public class Boat extends Tile
{
    public Boat()
    {
        tileName = "Boat";
        entryString = "Boat washed up on shore";
        returnString = "Back on the boat";
    }

    public Tile GenerateTile()
    {
        int[] position = Map.getPosition();
        if(position[0] == 1)
        {
            return new BoatLanding();
        }
        return new Ocean();
    }
}
