import java.util.Iterator;
import java.util.Set;
import java.io.EOFException;
import java.util.HashMap;
import java.util.HashSet;

public class WordCounter {
    // Used to map key words to count words.
    private HashMap<String, Integer> responseMap;

    /**
     * @post Construct a Responder.
     */
    public WordCounter()
    {
        responseMap = new HashMap<>();
    }


    public void contar(HashSet<String> words){
        Iterator<String> it = words.iterator();

        while(it.hasNext()){
            String palabra = it.next();
            if(responseMap.containsKey(palabra)){
                Integer aux = responseMap.get(palabra);;
                 responseMap.put(palabra, (aux+1));
            }else {
                responseMap.put(palabra, 1);
            }

        }
    }


    public void showCountWord (){
        Set<String> key = responseMap.keySet();

        for(String palabra : key){
            System.out.println("La palabra "+palabra+" tuvo "+responseMap.get(palabra)+" apariciones");
        }
    } 

    /**
     * @post Remove words from the responseMap that are in the responses set.
     * @param responses Set of words to be removed from the responseMap.
     */
    public void removeWordsResponses(Set<String> responses) {
        for (String palabra : responses) { // Respuestas grabadas
            System.out.println("trabajando con :  " + palabra);
            Iterator<String> it = responseMap.keySet().iterator(); // Iterador sobre las claves
            while (it.hasNext()) {
                String palabra2 = it.next(); // Palabras cargadas por el usuario
                System.out.println("comparando " + palabra + " con " + palabra2);
                if (palabra.equals(palabra2)) {
                    it.remove(); // Eliminar usando el iterador
                    System.out.println("se elimino una palabra");
                }
            }
        }
    } 

}
