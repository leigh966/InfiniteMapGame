package tsi.leigh.infinite.game;

import java.util.ArrayList;

public class Beach extends Tile
{
    public Beach()
    {
        tileName = "Beach";
        entryString = "Found beach";
        returnString = "On a familiar patch of beach";
        searchObject = null;
    }

    @Override
    protected void generateSearchString()
    {
        searchString = "You run your fingers through the sand and find ";
        if(searchObject == null)
        {
            searchString += "nothing";
        }
        else
        {
            searchString += searchObject.getItemName();
        }
    }

    @Override
    public Tile GenerateTile()
    {
        int currentX = Map.getPosition()[0];

        switch(currentX)
        {
            case 1:
                return new Shore();
            case 2:
                return new Beach();
            case 3:
                final double chanceOfBeach = 0.3;
                double outcome = Math.random();
                if(outcome < chanceOfBeach)
                {
                    return new Beach();
                }
                return new Grass();
            case 4:
                return new Grass();
            default:
                throw new TileShouldNotGenerateException("Beach should never allow you to move off it to an x position less than 1 or more than 4!");
        }


    }

}
