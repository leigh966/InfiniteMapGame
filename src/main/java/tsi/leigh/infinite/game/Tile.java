package tsi.leigh.infinite.game;

import java.util.ArrayList;

public abstract class Tile
{
    protected String tileName;
    protected String entryString = "", returnString = "";
    protected String searchString = "";
    protected Collectable searchObject = null;
    public String OnEntry()
    {
        return entryString;
    }
    public String OnReturn()
    {
        return returnString;
    }
    public abstract Tile GenerateTile() ;
    public String getTileName()
    {
        return tileName;
    }
    protected abstract void generateSearchString();
    public String search (ArrayList<Collectable> inventory)
    {
        if(searchObject != null) inventory.add(searchObject);
        searchObject = null;
        generateSearchString(); // Update the output to reflect that the item is no longer there
        return searchString;
    }
}
