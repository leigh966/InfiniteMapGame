package tsi.leigh.infinite.game;

import java.util.ArrayList;

public abstract class Tile
{
    protected String tileName;
    protected String entryString = "", returnString = "";
    protected String searchString = "";
    private Boolean dug = false;
    protected Collectable searchObject = null, buriedObject = null;
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
    public String dig()
    {
        if(searchObject == null) {
            dug = true;
            String returnString = "You dig ";
            if(buriedObject == null)
            {
                returnString += "and find nothing";
            }
            else {
                returnString += "something up";
            }
            searchObject = buriedObject;
            buriedObject = null;
            return returnString;
        }
        else
        {
            return "You're about to dig but notice something on the ground";
        }
    }
    protected abstract void init();
    public Boolean getDug()
    {
        return dug;
    }
}
