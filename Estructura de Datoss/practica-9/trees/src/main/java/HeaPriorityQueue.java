import java.util.NoSuchElementException;
import java.util.Queue;

public class HeaPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T> {
    private T[] queue;

    private int size;

    private static final int INIT_CAPACITY = 8;


    public HeaPriorityQueue() {
        queue = (T[]) new Comparable[INIT_CAPACITY+1];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0 ;
    }



    public boolean repOk(){
        //chequeamos que se usen las pociciones correctas del arreglo

        //primero que aya elementos hasta la cantidad que lleva registrada la estructura 
        for(int i = 1; i<= size; i++){
            if (queue[i] == null) return false; //que no sea null ninguna pocicion  
        }

        //despues de la el ultimo elementos registrado por la estructura no deveria de haber ningun elemento 
        for(int i = size+1; i< queue.length; i++){
            if(queue[i] != null) return false;
        }

        //la pocicion 0 no se usa para no complicarnos la vida por lo que deveria de estar vacia 
        if(queue[0] != null) return false;


        //nos fijamos que la estructura tenga el orden correcto 
        return isMaxHeapOrdered(1);
    }

    private boolean isMaxHeapOrdered(int k){
        if(k>size) return true; //si k es mayor entonces el arbol esta vacio

        int left = 2*k;
        int right = 2*k+1;

        if(left <= size && menorQue(queue[k], queue[left])){
            return false;
        }

        if(right <= size && menorQue(queue[k], queue[right])){
            return false;
        }

        return  isMaxHeapOrdered(left) && isMaxHeapOrdered(right);

    }

    private boolean menorQue(T t, T t2) { //TODO:
        return t.compareTo(t2) < 0;
    }

    @Override
    public void insert(T x) {
        if(size == queue.length-1) resize(2 * queue.length);

        size = size + 1;

        queue[size] = x;

        swim(size);
    }

    private void resize(int newCapacity) {
        T[] queue2 = (T[]) new Comparable[newCapacity];

        for(int i = 1; i<= size; i++){
            queue2[i] = queue[i];
        }

        queue = queue2;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T max() {
        if(isEmpty()) throw new NoSuchElementException();

        return queue[1];
    }

    @Override
    public T removeMax() { //TODO
        if(isEmpty()) throw new NoSuchElementException();

        T aux = queue[1];

        queue[1] = queue[size];

        size--;

        sink(1);

        return aux;
    }

    /**
     * @post si el nodo k esta mal ubicado osea no esta ordenado 
     * @param k
     */
    public void swim(int k){
        while(k>1 && menorQue(queue[k/2], queue[k])){
            intercabiar(queue, k/2, k);
            k = k/2;
        }
    }

    private void intercabiar(T[] queue2, int padre, int hijo) {
        T aux = queue2[padre];
        queue2[padre] = queue2[hijo];
        queue2[hijo] = aux;
    }


    private void sink(int k){
        while (2*k <= size){ //mientras el primer hijo de k este dentro del arreglo

            // j es el hijo ezquierdo de k
            int j = 2*k;

            // este if es para acegurarnos de que vamos a comparar al padre con el hijo mas grande 
            if(j<size && menorQue(queue[j], queue[j+1])){
                //si el hijo en j es menor que el de j+1 entonces aumentamos el j en 1 para usar el derecho
                j++;
            }

            //si el padre k no es menor que su hijo j entonces no hay nada para hacer  
            if(!menorQue(queue[k], queue[j])){
                break;
            }
            //sino intercabiamos el padre por el hijo y nos fijamos devuelta lo mismo sobre el hijo
            intercabiar(queue, k, j);
            k = j;
        }
    }

            @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HeaPriorityQueue(size=").append(size).append(", elements=[");
            for (int i = 1; i <= size; i++) {
                sb.append(queue[i]);
                if (i < size) sb.append(", ");
            }
            sb.append("])");
            return sb.toString();
        }
    }



