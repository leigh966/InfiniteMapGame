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

        if(searchObject != null) {
            inventory.add(searchObject);
            generateSearchString();
        }
        searchObject = null;

        return searchString;
    }
    protected abstract void init();
}
