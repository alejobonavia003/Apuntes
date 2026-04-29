import java.util.Scanner;


/**
 * Reads input from the user
 */
public class InputReader
{
    private static Scanner reader;

    public InputReader() {
        reader = new Scanner(System.in);
    }    
    
    /**
     * @post Read a line of text from the text terminal,
     * and return it as a String.
     */
    public String readUserInput()
    {
        System.out.print("> Enter a file to write to:");         // print prompt
        String inputLine = reader.nextLine();

        return inputLine;
    }
}