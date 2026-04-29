import MyArrayList.*;

public class Balanceador {
    
    private MyArrayList<Character> palabra;
    private ArrayStack<Character> pilaDeBalanceo;

    public Balanceador(String word) {
        palabra = new MyArrayList<>();
        for (char c : word.toCharArray()) {
            palabra.add(c);
        }

        pilaDeBalanceo = new ArrayStack<Character>();
    }
    

    public boolean isBalanceado() {


        for (Character e : palabra) {
            //si encuentra un parentesis abriendo lo carga en la pila
            if(e.equals('[')){
                pilaDeBalanceo.push(e);
            }
            if(e.equals('(')){
                pilaDeBalanceo.push(e);
            }
            if(e.equals('{')){
                pilaDeBalanceo.push(e);
            }

            //si encuenta uno cerrando en la pila deveria haber uno abriendo del mismo tipo 
            // entonces si es asi lo saca y si no es asi la pila esta desvalanceada
            if(e.equals(']')){
                if (pilaDeBalanceo.top().equals('[') ){
                     pilaDeBalanceo.pop();
                    }else {
                         return false;
                        }

            }
            if(e.equals(')')){
                if (pilaDeBalanceo.top().equals('(') ){
                    pilaDeBalanceo.pop();
                   }else {
                        return false;
                       }
           }
            if(e.equals('}')){
                if (pilaDeBalanceo.top().equals('{') ){
                    pilaDeBalanceo.pop();
                   }else {
                        return false;
                       }
           }
            
        }

        return true;
    }

    

}
