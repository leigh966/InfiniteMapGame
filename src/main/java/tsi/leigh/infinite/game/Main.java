package tsi.leigh.infinite.game;


import java.util.Scanner;

public class Main
{
    private static String getInput(String prompt)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        return scan.nextLine();
    }


    public static String parse(String command)
            throws IllegalArgumentException
    {
        String[] splitCommand = command.toLowerCase().split(" ");
        switch(splitCommand[0])
        {
            case "go", "head", "walk":
                return Map.move(splitCommand[1]);
            default:
                return "Invalid command";
        }
    }

    public static void main(String[] args)
    {
        System.out.println(Map.init());
        while(!Game.isOver())
        {
            String userInput = getInput(">> ");
            try {
                System.out.println(parse(userInput));
            }catch(IllegalArgumentException IAE)
            {
                System.out.println(IAE.getMessage());
            }
        }
    }
}
