public class MatricesAdyacenteGrafo implements IntGrafo {

    //numero total de vertices
    private final int vertices;

    //numero de aristas 
    private int aristas;

    //matris adyacente 
    private int[][] adj;

    public MatricesAdyacenteGrafo(int v) {
        if(v < 0) throw new IllegalArgumentException("cantidad de nodos negativa");
        
        vertices = v;
        aristas = 0;

        adj = new int[v][v];

        for(int i = 0; i< v; i++){
            for (int j = 0; j< v; j++){
                adj[i][j] = 0;
            }
        }
    }

    @Override
    public int Vertices() {
        return vertices;
//        throw new UnsupportedOperationException("Unimplemented method 'Vertices'");
    }

    @Override
    public int Aristas() {
        return aristas;
        //throw new UnsupportedOperationException("Unimplemented method 'Aristas'");
    }

    @Override
    public void agregarVertice(int v, int w) {
        if (v < 0 || v >= vertices || w < 0 || w >= vertices){
            throw new IllegalArgumentException("cargame un par de nodos como la gente");
        }
        if (adj[v][w] == 0 || adj[w][v] == 0){
            adj[v][w] = 1;
            adj[w][v] = 1;
            aristas++;
        }
        
        //throw new UnsupportedOperationException("Unimplemented method 'agregarVertice'");
    }
    
}
