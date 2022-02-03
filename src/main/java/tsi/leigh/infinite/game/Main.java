package tsi.leigh.infinite.game;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    private static String getInput(String prompt)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        String input = scan.nextLine();
        return input;
    }


    private static String parse(String command)
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
        while(true)
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
