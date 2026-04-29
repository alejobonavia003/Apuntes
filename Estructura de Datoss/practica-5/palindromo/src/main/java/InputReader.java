import queueArray.*;
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
     * @post escribe una palabra y te devuelve como arreglo de caracteres
     * si se escribe mas de una palabra se retorna la primera
     */
    public CircularQueue<Character> getInput() 
    {
        // se escribe el prompt
        System.out.print("> ");
        String inputLine = reader.nextLine();
        // elimina los espacios en blanco
        inputLine = inputLine.trim();
        // separa las palabras por espacios
        String[] wordArray = inputLine.split(" ");
        String palabra = wordArray[0];
        // add words from array into hashset 
        CircularQueue<Character> letras = new CircularQueue<>();

        for (Character e : palabra.toCharArray()){
            letras.enqueue(e); 
        }

        System.out.println("se escucho de la terminal: "+letras);
        

        return letras;
    }

    
}
