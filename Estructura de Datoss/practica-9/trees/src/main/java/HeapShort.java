public class HeapShort {
    
    private HeaPriorityQueue<Integer> heap;
    private int[] arreglo;

    public HeapShort(){
        heap = new HeaPriorityQueue<>();
        arreglo = new int[100];
    }

    public void createHeap(int[] arregloRandom){
        System.out.println("cargando arreglo dentro del heap");
        for(int i=0;i<arregloRandom.length;i++){
            heap.insert(arregloRandom[i]);
            System.out.println("heap: "+ heap);
        }
    }

    public void vaciarHeap(){
        System.out.println("vaciando el heap dentro del arreglo");
        int i = 0;
        System.out.print("[");
        while(!heap.isEmpty()){
            arreglo[i] = heap.removeMax();
            System.out.print(arreglo[i] + ", ");
            i++;
           
        }
        System.out.print("]");
    }
}
