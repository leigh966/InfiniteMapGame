package tsi.leigh.infinite.game;

public class Collectable
{
    private String itemName;
    public Collectable(String name)
    {
        itemName = name;
    }

    public String getItemName()
    {
        return itemName;
    }
    public String use()
    {
        return "Nothing Happens";
    }

}
