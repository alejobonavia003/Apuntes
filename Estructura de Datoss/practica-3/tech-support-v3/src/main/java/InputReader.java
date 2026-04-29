import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is then chopped into words, and a set of words 
 * is provided.
 */
public class InputReader
{
    private Scanner reader;

    /**
     * @post Create a new InputReader that reads text 
     * from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * @post Read a line of text from the text terminal,
     * and return it as a set of words.
     */
    public HashSet<String> getInput() 
    {
        // print prompt
        System.out.print("> ");
        String inputLine = reader.nextLine();
        // Remove leading and trailing whitespaces
        inputLine = inputLine.trim();
        // split at spaces
        String[] wordArray = inputLine.split(" ");

        // add words from array into hashset 
        HashSet<String> words = new HashSet<>();
        for(String word : wordArray) {
            words.add(word.toLowerCase());
        }
        return words;
    }
}
