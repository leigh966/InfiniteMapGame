package tsi.leigh.infinite.game;

public class Grass extends Tile
{

    public Grass()
    {
        tileName = "Grass";
        entryString = "Found grassland";
        returnString = "Entered familiar grassland";
    }

    public Tile GenerateTile()
    {
        int currentX = Map.getPosition()[0];

        if(currentX == 2)
        {
            return new Beach();
        }

        if(currentX == 3)
        {
            double chanceOfBeach = 0.3;
            double outcome = Math.random();
            if(outcome < chanceOfBeach)
            {
                return new Beach();
            }
            return new Grass();
        }

        if(currentX > 3)
        {
            return new Grass();
        }

        throw new TileShouldNotGenerateException("Grass should never allow you to move off it to an x position less than 2!");
    }
}
