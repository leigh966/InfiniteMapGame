package tsi.leigh.infinite.game;

public class Shovel extends Collectable
{
    public Shovel()
    {
        super("Shovel");
    }

    @Override
    public String use()
    {
        return Map.getCurrentTile().dig();
    }

}
