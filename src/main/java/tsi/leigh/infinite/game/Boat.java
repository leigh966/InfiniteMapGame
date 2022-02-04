package tsi.leigh.infinite.game;

public class Boat extends Tile
{
    @Override
    protected void init()
    {
        tileName = "Boat";
        entryString = "Boat washed up on shore";
        returnString = "Back on the boat";
        generateSearchString();
    }

    public Boat()
    {
        searchObject = null;
        init();
    }

    public Boat(Collectable c)
    {
        searchObject = c;
        init();
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

    @Override
    protected void generateSearchString()
    {
        if(searchObject == null)
        {
            searchString = "You have already picked up everything useful";
        }
        else
        {
            searchString = "You pick up your trusty " + searchObject.getItemName();
        }
    }
}
