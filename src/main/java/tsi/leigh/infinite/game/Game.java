package tsi.leigh.infinite.game;

public class Game
{
    private static Boolean gameOver = false;

    public static void die()
    {
        gameOver = true;
    }

    public static Boolean isOver()
    {
        return gameOver;
    }

}
