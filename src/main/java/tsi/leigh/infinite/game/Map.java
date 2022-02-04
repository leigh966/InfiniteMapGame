package tsi.leigh.infinite.game;

import java.util.Hashtable;

public class Map
{
    private static Hashtable<String, Tile> visitedTiles;
    private static int currentX = 0, currentY = 0;
    private static int treasureX, treasureY;

    private Map(){}

    public static String init()
    {
        visitedTiles = new Hashtable<>();
        final int START_X = 0;
        final int START_Y = 0;
        Tile boat = new Boat();
        visitedTiles.put(getKey(START_X,START_Y), boat);
        currentX = 0;
        currentY = 0;
        generateTreasure();
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
                throw new IllegalArgumentException("'" +direction +"' is not a valid direction");
        }
    }

    public static String move(String direction)
            throws IllegalArgumentException
    {
        int previousX = currentX;
        int previousY = currentY;
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

    public static int getNewTreasureDelta(int minDelta, int maxDelta)
    {
        return (int) ((Math.random()+minDelta)*(maxDelta-minDelta)+minDelta);
    }

    private static void generateTreasure()
    {
        final int minDelta = 5;
        final int maxDelta = 10;
        final int minX = 4;
        int treasureXDelta = getNewTreasureDelta(minDelta, maxDelta);
        int treasureXPos = currentX - treasureXDelta;
        if(Math.random()<0.5 || treasureXPos < minX)
        {
            treasureXPos = currentX + treasureXDelta;
        }
        int treasureYDelta = getNewTreasureDelta(minDelta, maxDelta);
        treasureYDelta = Math.random()<0.5 ? treasureYDelta : treasureYDelta*-1;
        int treasureYPos = currentY + treasureYDelta;

        Tile treasureTile = visitedTiles.get(getKey(treasureXPos, treasureYPos));

        // Look for an untaken square
        while(treasureTile != null)
        {
            treasureXPos += minDelta;
            if(Math.random()<0.5) {
                treasureYPos += minDelta;
            }else{
                treasureYPos -= minDelta;
            }
            treasureTile = visitedTiles.get(getKey(treasureXPos, treasureYPos));
        }
        treasureX = treasureXPos;
        treasureY = treasureYPos;
        visitedTiles.put(getKey(treasureXPos,treasureYPos), new Grass(null, new TreasureChest()));

    }


    public static int[] getTreasureLocation()
    {
        int[] position = {treasureX, treasureY};
        return position;
    }
}
