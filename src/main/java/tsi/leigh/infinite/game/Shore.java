package tsi.leigh.infinite.game;

public class Shore extends Beach
{
    public Shore()
    {
        tileName = "Shore";
        entryString = "On the shore with nothing but ocean to the west";
        returnString = "Back at the shore";
    }

    @Override
    public Tile GenerateTile()
    {
        int currentX = Map.getPosition()[0];
        switch(currentX)
        {
            case 0:
                return new Ocean();
            case 1:
                return new Shore();
            case 2:
                return new Beach();
            default:
                throw new TileShouldNotGenerateException("You should not be able to move off the shore to x > 1 or x < 0");
        }
    }

}
