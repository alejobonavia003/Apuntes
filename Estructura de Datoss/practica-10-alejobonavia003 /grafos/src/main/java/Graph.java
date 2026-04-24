public interface Graph<T extends Comparable<? super T>> {
    /**
     * retorna el numero de nodos del grafo
     */
    public int v();

    /**
     * retorna el numero de aristas del grafo
     */
    public int e();

    /**
     * @pre !contaisVertex(v)}
     * @post agrega el vertice nuevo 
     */
    public void addVertex(T v);

    /**
     * @post return true si existe el nodo el el grafo 
     */
    public boolean contaisVertex(T v);

    /**
     * @pre v y w son vertices del grafo
     * @post agrega una arista sin direccion entre los nodos
     */
    public void addEdge(T v, T w);
}
