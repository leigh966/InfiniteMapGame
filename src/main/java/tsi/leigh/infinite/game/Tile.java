package tsi.leigh.infinite.game;

public abstract class Tile
{
    public abstract String OnEntry();
    public abstract String OnReturn();
    public abstract Tile GenerateTile();
}
