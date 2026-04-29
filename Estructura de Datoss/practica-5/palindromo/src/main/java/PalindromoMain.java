import queueArray.*;

public class PalindromoMain {

    public static void main (String[] args){
        InputReader escuchador = new InputReader();
        SystemPalindromo func = new SystemPalindromo();

        CircularQueue<Character> palabra = escuchador.getInput();

        System.out.println("Original: " + palabra);
        CircularQueue<Character> invertida = func.fumao(palabra);
        System.out.println("Invertida: " + invertida);

        System.out.println(func.esPalindromo(palabra, invertida));

    }
}