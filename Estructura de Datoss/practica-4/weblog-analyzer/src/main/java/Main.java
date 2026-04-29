import java.util.Scanner;
import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.Path;


/**
 * Main class for the weblog-analyzer project
 */
public class Main
{
    public static InputReader reader;
    public static LogfileCreator creator;
    private static final int LOG_ENTRIES = 10;
    
    public static void main(String [] args) 
    {
        reader = new InputReader();
        creator = new LogfileCreator();
         
        boolean success = false;
        while (!success) {
            String filename = reader.readUserInput();
            // Better security checks to satisfy createFile's 
            // precondition.
            if (isValidPath(filename)) 
            {
                try 
                {
                    creator.createFile(filename, LOG_ENTRIES);
                    success = true;
                }
                // Do nothing, success is already false.
                catch (IOException exception) { }
   
            }
            if (!success) {
                System.out.println("Error writing to file." +
                  " Try again.");
            }
        }
    }
    
    /**
     * @pre The path is in a valid directory (TODO: not checked).
     * @post Returns true if and only if 'path' is a 
     * valid path for the user's operating system.
     *  
     * Calling examples on Windows:
     *    isValidPath("c:/test");      //returns true
     *    isValidPath("c:/te:t");      //returns false
     *    isValidPath("c:/te?t");      //returns false
     *    isValidPath("c/te*t");       //returns false
     *    isValidPath("good.txt");     //returns true
     *    isValidPath("not|good.txt"); //returns false
     *    isValidPath("not:good.txt"); //returns false
     */
    public static boolean isValidPath(String path)
    {
        // TODO: To avoid security problems, we should also verify 
        // that the file belongs to the directory we want to use 
        // to store log files

        if (path == null || path.trim().isEmpty()){
            return false;
        }


        String escapadoDeCaracteres = "[<>:\"/\\|?*]";
        if (path.matches(escapadoDeCaracteres)) {
            return false;
        }


        try 
        {
            Path targetPath = Paths.get(path).normalize();
            Path logDir = Paths.get("logs").toAbsolutePath().normalize();
            Path javaPath = Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex)
        {
            return false;
        }
        return true;
    }
    
        
}
