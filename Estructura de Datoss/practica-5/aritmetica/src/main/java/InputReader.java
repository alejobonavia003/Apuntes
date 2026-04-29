import MyArrayList.*;
import java.util.Scanner;


/**
 * InputReader es una clase para recibir texto por consola y separarlo
 * en palabras
 */
public class InputReader
{
    private Scanner reader;

    /**
     * @post crea un nuevo imput reader 
     * para leer texto por consola
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * @post escribe una linea por terminal y se 
     * separa en un hasset por palabras
     */
    public ArrayStack<String> getInput() 
    {
        // escribe el prompt
        System.out.print("> ");
        String inputLine = reader.nextLine();
        // remove textos en blanco
        inputLine = inputLine.trim();
        // separa por espacios
        String[] wordArray = inputLine.split(" ");

        // agrega todas las palabras en un hashSet<> 
        ArrayStack<String> words = new ArrayStack<>();
        for(String word : wordArray) {
            words.push(word.toLowerCase());
        }
        return words; //retornamos un hastSet de todas las palabras
    }
}
