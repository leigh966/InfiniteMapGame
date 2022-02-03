package tsi.leigh.infinite.game;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main
{
    public static String getInput(String prompt)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        String input = scan.nextLine();
        return input;
    }


    public static void main(String[] args)
    {
        System.out.println("Hello World");
    }
}
