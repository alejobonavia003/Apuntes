import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class GrafoAdyacente<T extends Comparable<? super T>> implements Graph<T> {

    private int v;

    private int e;

    private TreeMap<T, Integer> map;

    private T[] keys;

    private List<Integer>[] adj;

    public GrafoAdyacente(int v){
        this.v = 0;
        this.e = 0;

        adj = new LinkedList[v];
        map = new TreeMap<>();
        keys = (T[]) new Comparable[v];
    }

    /**
     * @pre 0 <= v < V
     * @post retorna el nombre del vertice asosiado al entero v
     */
    T nameOf (int v){
        return keys[v];
    }

    /**
     * @pre ContainsVertex(v)
     * @post retorna el entero asociado al vertice de nombre v
     */
    int indexOf(T v){
        return map.get(v);
    }

    @Override
    public int v() {
        return v;
    }   

    @Override
    public int e() {
        return e;
    }

    @Override
    public void addVertex(T v) {
        if(contaisVertex(v)){
            throw new IllegalArgumentException("el vertice ya existe");
        }
        int vid = this.v++;
        map.put(v,vid);
        adj[vid] = new LinkedList<>();
        keys[vid] = v;

    }

    @Override
    public boolean contaisVertex(T v) {
        return map.containsKey(v);
    }

    @Override
    public void addEdge(T v, T w) {
        if(!contaisVertex(v) || !contaisVertex(w)) throw new IllegalArgumentException("no existe uno de los nodos");
        adj[indexOf(v)].add(indexOf(w));
        this.e++;
    }
    
}
