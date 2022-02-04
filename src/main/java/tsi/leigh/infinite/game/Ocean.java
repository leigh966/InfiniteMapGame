package tsi.leigh.infinite.game;

public class Ocean extends Tile
{
    public Ocean()
    {
        tileName = "Ocean";
        entryString = "You have drowned in the ocean";
    }


    public Tile GenerateTile()

    {
        throw new TileShouldNotGenerateException("The Ocean should never have its generateTile method called");
    }
}
