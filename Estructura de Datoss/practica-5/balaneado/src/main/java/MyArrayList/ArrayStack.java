package MyArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T>, Iterable<T>
{
    
    private static final int INIT_CAPACITY = 10;
    protected T[] array;
    protected int size;

    public ArrayStack (){
        array = (T[]) new Object[INIT_CAPACITY];
        size = 0;
    }

    /**
     * @pos return size the stack
     */
    @Override
    public int size() {
        return size;
        //throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    /**
     * @pos return true if stack empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
//        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    /**
     * @pos agrega el elemento e al tope de la pila
     */
    @Override
    public void push(T e) {
        if (size == array.length){
            resize(2*array.length);
        }

        array[size++] = e;
   //throw new UnsupportedOperationException("Unimplemented method 'push'");
    }

    /**
     * @pos elimina el ultimo elemento cargado  
     */
    @Override
    public T pop() {

        if(size > 0 ){
        T aux = array[size-1];

        array[size-1] = null;
        size--;

        return aux;
        }else {
            throw new IllegalArgumentException("no puedes eliminar elementos donde no hay");
        }
        
        //throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }


    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Returns the item at the top of the stack.
     *   More formally, it satisfies:
     *     let this = s1 ++ [e] | result = e.
     */
    @Override
    public T top() {
        if (isEmpty()){
            throw new NoSuchElementException("no hay elementos en la pila");
        }
        return array[size-1];
        //throw new UnsupportedOperationException("Unimplemented method 'top'");
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

    /**
     * @post Returns an iterator for the stack that iterates through 
     *   the items in LIFO order.
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
        //throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    } 


    private class ArrayStackIterator implements Iterator<T> {
        private int current = size - 1;
    
        @Override
        public boolean hasNext() {
            return current >= 0;
        }
    
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[current--];
        }
    }




}