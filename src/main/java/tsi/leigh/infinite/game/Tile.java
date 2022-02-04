package tsi.leigh.infinite.game;

public abstract class Tile
{
    protected String tileName;
    protected String entryString = "", returnString = "";
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
}
