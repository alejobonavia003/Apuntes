import java.util.LinkedList;
import java.util.List;

public class ListasAdyacentesGrafo implements IntGrafo {

    // numero total de vertices del grafoo o nodos
    private final int V;

    //numero de aristas
    private int E;

    //listas adyacentes
    private List<Integer>[] adj;

    public ListasAdyacentesGrafo(int V){
        if(V < 0) {
            throw new IllegalArgumentException("No puede haver una cantidad de vertices negativos");
        }


        // cuando creaoms un grafo le podemos pasar la cantidad de nodos que tiene 
        // lo unico deveria de ser positiva 
        this.V = V;
        this.E = 0;

        //luego adj es un arreglo de listas enlasadas
        adj = new LinkedList[V];

        //llamamos al constructor de la lista enlazada por cada posicin del arreglo
        for (int v = 0; v < V ; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    /**
     * @pre le pasas un nodo y te devuelve todos sus caminos
     */
    public List<Integer> adj(int v) {
        if (v < 0 || v >= V){
            throw new IllegalArgumentException("nodo invalido");
        }

        return adj[v];
    }

    //retorna el numero de vertices 
    @Override
    public int Vertices() {
        return V;
    }

    @Override
    public int Aristas() {
    return E;
    }

    /**
     * @pre 0<= v v= V && 0<= w <= V
     */
    @Override
    public void agregarVertice(int v, int w) {
        //primero revisamos que v y w esten de>ntro de los valores permitidos 

        if(v < 0 || v>= V || w < 0 || w>= V){
            throw new IllegalArgumentException("nodo no perteneciente a la grafo");
        }

        //agregamos una arista mas al contador de aristas
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    
}
