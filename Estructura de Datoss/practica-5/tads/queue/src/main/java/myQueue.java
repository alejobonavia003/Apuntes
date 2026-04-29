import java.util.Iterator;
import java.util.NoSuchElementException;

public class myQueue<T> implements Queue<T> {

    protected static final int INIT_CAPACITY = 10;
    protected int size;
    protected T first;
    protected T last;
    protected T[] array;

    public myQueue() {
        size = 0;
        first = null;
        last = null;
        array = (T[]) new Object[INIT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
        //throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        return first == null;
        //throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    /**
     * @post Adds element e to the end of the queue.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    @Override
    public void enqueue(T e) {
        if (size == array.length){
            resize(2*array.length);
        }
        last = e;
        if (isEmpty()){
            last = first;
            array[size] = e;
        }else {
            array[size++] = e;
        }
        size++;
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }


    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Removes and returns the item at the beggining of the queue. 
     *   More formally, it satisfies: 
     *     let old(this) = [e] ++ s1 |
     *       this = s1 && result = e.
     */
    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T oldFirst = array[0];
        for (int i = 0;i<(size-1);i++){
            array[i] = array[i++];
        }
        size--;
        return oldFirst;
        //throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }


    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Returns the item at the beggining of the queue.
     *   More formally, it satisfies:
     *     let this = [e] ++ s1 | result = e.
     */
    @Override
    public T peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return first;
        //throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }


    /**
     * @post Returns an iterator for the queue that iterates through 
     *   the items in FIFO order.
     */
    @Override
    public Iterator<T> iterator() {
        return new QueueStackIterator();
        //throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }


    /**
     * @post Returns true if and only if the structure is a 
     *   valid queue.
     */
    @Override
    public boolean repOK() {
        if(size()< 0 ) {
            return false;
        }

        int numberOfT = 0;
        while(numberOfT<array.length+1){
            numberOfT++;
        }
        if(numberOfT!=size || first!=array[0] || last != array[size-1]){
            return false;
        }
        return true;
        //throw new UnsupportedOperationException("Unimplemented method 'repOK'");
    }

    
/**
 * @pre capacity > size
 * @pos aumenta el tamaño del arreglo manteniendo los datos
 * @param capacity
 */
private void resize(int capacity){
    if(capacity <= size()){
        throw new IllegalAccessError("el arreglo ya tiene el tamaño suficiente");
    }

    T[] copy = (T[]) new Object[capacity];
    for(int i = 0;i< size; i++){
        copy[i] = array[i];
    }
}

private class QueueStackIterator implements Iterator<T> {
    private int current = 0;

    @Override
    public boolean hasNext() {
        return current < size;
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        return array[current++];
    }
}

}
