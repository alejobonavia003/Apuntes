import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Clase para almacenar conjuntos de palabras, y contar la cantidad
 * de veces que cada palabra fue observada.
*/
public class WordCounter
{
    // Associate each word with a count.
    SortedMap<String, Integer> conter;
    

    /**
     * @post Crea un WordCounter
     */
    public WordCounter() {
        conter = new MyMapTree<String, Integer>();
    }
    
    /**
     * @post Almacena el conjunto de palabras input, incrementando 
     *   por cada palabra su cuenta en 1.
     */
    public void addWords(SortedSet<String> input) {
        if (input.size() == 0) 
            throw new NoSuchElementException("input vacío");

        for (String palabra : input) {
            if (conter.containsKey(palabra)) {
                int prev = conter.get(palabra);
                conter.put(palabra, prev + 1);
            } else {
                conter.put(palabra, 1);
            }
        }
    }

    
    /**
     * @post Retorna todas las palabras almacenadas como un 
     *   conjunto
     */
    public SortedSet<String> getAllWords() {
        SortedSet<String> result = new MyBinarySearch<>();
        Iterator<String> iterador = conter.iterator();

        while(iterador.hasNext()){
            String aux = iterador.next();
            result.add(aux);
        }

        return result;
    }
    
    /**
     * @post Retorna la cantidad de veces que una palabra fue
     *   ingresada
     */
    public int getRepetitions(String word) {
        if (!conter.containsKey(word))
            throw new NoSuchElementException();
        return conter.get(word);    
    }

    
    /**
     * @post Retorna verdadero si y solo si word pertenece al
     *   conjunto de palabras que fueron observadas
     */
    public boolean belongsToSet(String word) {
      return conter.containsKey(word);       
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Iterator<String> it = conter.iterator();
        boolean first = true;
        while (it.hasNext()) {
            String palabra = it.next();
            Integer cuenta = conter.get(palabra);
            if (!first) {
                sb.append(", ");
            }
            sb.append(palabra).append("=").append(cuenta);
            first = false;
        }
        sb.append("}");
        return sb.toString();
    }

}
