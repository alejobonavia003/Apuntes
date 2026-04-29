import java.util.Iterator;
/**
 * SortedSet are unbounded sets of objects of type T. 
 * A typical SortedSet is {o1, . . . , on}.
 *
 * SortedSet requires that the key type T implements the 
 * Comparable interface.
 *
 * The methods use compareTo to determine equality of elements.
 */
public interface SortedSet<T extends Comparable<? super T>> extends Iterable<T>{
    /**
     * @post Adds 'x' to the elements of 'this'.
     *   More formally, it satisfies: this = old(this) U {e}.
     */
    public boolean add(T x);

    /**
     * @post Returns the cardinality of 'this'.
     *   More formally, it satisfies: #this.
     */
    public int size();
    
    /**
     * @pre !isEmpty()
     * @post Deletes the smallest element of 'this'.
     */   
    public void removeMin();


    
    /**
     * @post Returns true iff 'key' is in 'this'.
     */  
    public boolean contains(T key);

    /**
     * @post Returns an iterator for the set that iterates through 
     *   the items in order.
     */
    public Iterator<T> iterator();


}