package MyArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Write a description of class MyArrayList here.
 * 
 */
public class MyArrayList<T> implements List<T>, Iterable<T> 
{
    private T[] items;
    private static final int MAX_LIST = 100;
    private int numItems;

    /**
     * Constructor for objects of class MyArrayList with specific size.
     */
    public MyArrayList(int size)
    {
        if(size <= 0) {
            throw new IllegalArgumentException("colection size mast be positive");
        }
        items = (T[]) new Object[size];
        numItems = 0;
    }
    
    /**
     * Constructor for objects of class MyArrayList
     */
    public MyArrayList( )
    {
        items = (T[]) new Object[MAX_LIST];
        numItems = 0;
    }

     /**
     * @post Returns the number of elements in the list.
     *   More formally, it satisfies: result = #this.
     */
    public int size() {
        return numItems;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("..[");
        boolean first = true;
        for (int i = 0; i < numItems; i++) {
            T elem = items[i];
            if (elem == null) continue;           // saltar huecos nulos, si quieres
            if (!first) {
                sb.append(", ");
            }
            sb.append(elem.toString());
            first = false;
        }
    
        sb.append("]..");
        return sb.toString();
    }
    

    /**
     * @post Returns true iff the list contains no elements.
     *   More formally, it satisfies: result = #this = 0.
     */
    public boolean isEmpty() {
        return (numItems==0);
    }
    
    /**
     * @post Returns true iff the list contains element e.
     *   More formally, it satisfies: 
     *   result = exists o | o in this && e.equals(o).
     */
    public boolean contains(T e) {
        int i = 0;
        boolean found = false;
        while(i < numItems && !found) {
            found = e.equals(items[i]);
            i++;
        }    
        return found;
    }
    
    /**
     * @post Appends element e to the end of this list.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    @Override
    public void add(T e) {
        if (numItems == items.length) {
            throw new IllegalStateException("Lista llena");
        }
        items[numItems++] = e;
    }
    
    
    /**
     * @post Removes the first occurrence of e from this list.
     *   If e is not in the list it does not modify the list.
     *   Returns true iff e is removed (result = e in old(list)).
     */
    public boolean remove(T e) {
        int i = 0;
        boolean found = false;
        while(i < numItems && !found) {
            found = e.equals(items[i]);
            if(found){
                int j = i;
                while (j < numItems) {
                items[j] = items[j++];
                j++;
                }
                numItems--;
                return true;
            }
            i++;
        }
        
        return false;
    }
    
    /**
     * @post Removes all of the elements from the list,
     *   More formally, it satisfies: #this = 0.
     */
    public void clear() {
        numItems = 0;
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Returns the element at position index in the list,
     *   More formally, it satisfies: result = this[index].
     */
    public T get(int index) {
        if (index >= 0 && index < size()) {
            return items[index];
        }else {
            throw new IndexOutOfBoundsException("Indice incorrecto");
        }
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Replaces the element at position index with e, and returns
     *   the element that was replaced.
     *   More formally, it satisfies: 
     *     this[index].equals(e) && #this = #old(this) && 
     *     result.equals(old(this)[index]).
     */
    public T set(int index, T e) {
        if (index >= 0 && index < size()) {
            items[index] = e;
            return items[index];
        }else {
            throw new IndexOutOfBoundsException("Indice incorrecto");
        }
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Inserts the element at position index with e.
     *   More formally, it satisfies: 
     *   this[index].equals(e) && #this = #old(this) +1.
     */
    public void add(int index, T e) {
        if (index >= 0 && index < size()) {
            items[index] = e;
        }else {
            throw new IndexOutOfBoundsException("Indice incorrecto");
        }
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Removes the element at position index.
     *   More formally, it satisfies: 
     *   result = old(this)[index] && #this = #old(this) -1.
     */
    public T remove(int index) {
        T aux;
        if (index >= 0 && index < size()) {
            aux = items[index];
            for(int i=index;i<size();i++){
                items[i] = items[i++];
            }
            return aux;
        }
            throw new IndexOutOfBoundsException("Indice incorrecto");

        
    }
    
    /** 
     * @post Returns the index of the first occurrence of e
     *   in the list, or -1 if this list does not contain e.
     *   More formally, it satisfies: 
     *     result = -1 -> !(e in this) && 
     *     result != -1 -> this[result].equals(e).
     */
    public int indexOf(T e) {
        
            int i = 0;
            boolean found = false;
            while(i < numItems && !found) {
                found = e.equals(items[i]);
                if(found){
                    return i;
                }
                i++;
            } 

            return -1;

        //throw new UnsupportedOperationException("method not yet implemented");
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

 
    private class MyIterator implements Iterator<T> {
        private int current = 0;// current es de donde empieza la estructura.

        @Override
        public boolean hasNext() {
            return current < numItems;
            //throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[current++];
            // throw new UnsupportedOperationException("Unimplemented method 'next'");
        }
        
    }
    
}
