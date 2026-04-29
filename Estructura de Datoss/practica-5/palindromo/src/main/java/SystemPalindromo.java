import queueArray.*;

public class SystemPalindromo {

    CircularQueue<String> palabra;

    public SystemPalindromo(){
        
    }

    public String esPalindromo(CircularQueue<Character> palabra1, CircularQueue<Character> palabra2){

        if (palabra1.equals(palabra2)) {
            return ("¡Es palíndromo!");
        } else {
            return ("¡NO Es palíndromo!");
        }
        

    }

    public CircularQueue<Character> fumao(CircularQueue<Character> palabraE){
        
        CircularQueue<Character> yafumo = new CircularQueue<>();
        CircularQueue<Character> palabra = new CircularQueue<>();

        palabra = palabraE;

        int tamaño = palabra.size();
        for(int i = 0; i < tamaño; i++){
            yafumo.enqueue(palabra.dequeue());
            for(int j = i; j>0 ; j--){
                yafumo.enqueue(yafumo.dequeue());
            }
        }

        return yafumo;
    }
}