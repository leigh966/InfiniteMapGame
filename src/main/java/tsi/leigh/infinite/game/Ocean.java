package tsi.leigh.infinite.game;

import java.util.ArrayList;

public class Ocean extends Tile
{
    public Ocean()
    {
        searchObject = null;
        init();
    }

    @Override
    public String OnEntry()
    {
        Game.die();
        return entryString;
    }

    @Override
    protected void init()
    {
        tileName = "Ocean";
        entryString = "You have drowned in the ocean";
    }

    public Tile GenerateTile()

    {
        throw new TileShouldNotGenerateException("The Ocean should never have its generateTile method called");
    }

    @Override
    protected void generateSearchString() {
        throw new CannotSearchHereException("Searching should never happen in the ocean");
    }

    @Override
    public String search(ArrayList<Collectable> inventory)
    {
        throw new CannotSearchHereException("Searching should never happen in the ocean");
    }
}
