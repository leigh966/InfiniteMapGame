package tsi.leigh.infinite.game;

import java.util.Hashtable;

public class Map
{
    private static Hashtable<String, Tile> visitedTiles = new Hashtable<String, Tile>();
    private static int currentX = 0, currentY = 0;


    public static String init()
    {
        final int START_X = 0;
        final int START_Y = 0;
        Tile boat = new Boat();
        visitedTiles.put(getKey(START_X,START_Y), boat);
        return boat.OnEntry();
    }

    public static int[] getPosition()
    {
        int[] position = {currentX, currentY};
        return position;
    }

    private static String getKey(int x, int y)
    {
        return Integer.toString(x) + "," + Integer.toString(y);
    }

    public static Tile getTile(int x, int y)
    {
        return visitedTiles.get(getKey(x,y));
    }

    public static Tile getCurrentTile()
    {
        return getTile(currentX, currentY);
    }

    private static void updatePosition(String direction)
            throws IllegalArgumentException
    {
        direction = direction.toLowerCase();
        switch (direction)
        {
            case "north":
                currentY++;
                break;
            case "east":
                currentX++;
                break;
            case "south":
                currentY--;
                break;
            case "west":
                currentX--;
                break;
            default:
                throw new IllegalArgumentException("Not a valid direction");
        }
    }

    public static String move(String direction)
            throws IllegalArgumentException
    {
        int previousX = currentX, previousY = currentY;
        updatePosition(direction);
        Tile newTile = getCurrentTile();
        if(newTile == null) // Not in map
        {
            newTile = getTile(previousX, previousY).GenerateTile();
            visitedTiles.put(getKey(currentX, currentY), newTile);
            return newTile.OnEntry();
        }
        return newTile.OnReturn();
    }
}
