
import java.util.Iterator;

/**
 * Queue represents unbounded, first-in-first-out (FIFO) 
 * queue objects of type T.
 *
 * A typical Queue is a sequence [o1, o2,..., on]; we 
 * denote this by: this = [o1, o2,..., on].
 *
 * The methods use equals to determine equality of elements.
 */
public interface Queue<T> extends Iterable<T>
{
    /**
     * @post Returns the number of elements in the queue.
     *   More formally, it satisfies: result = #this.
     */
    public int size();

    /**
     * @post Returns true iff the queue contains no elements.
     *   More formally, it satisfies: result = #this = 0.
     */
    public boolean isEmpty(); 
    
    /**
     * @post Adds element e to the end of the queue.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    public void enqueue(T e);
    
    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Removes and returns the item at the beggining of the queue. 
     *   More formally, it satisfies: 
     *     let old(this) = [e] ++ s1 |
     *       this = s1 && result = e.
     */
    public T dequeue(); 
 
    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Returns the item at the beggining of the queue.
     *   More formally, it satisfies:
     *     let this = [e] ++ s1 | result = e.
     */
    public T peek();
    
    /**
     * @post Returns an iterator for the queue that iterates through 
     *   the items in FIFO order.
     */
    public Iterator<T> iterator();
    
    /**
     * @post Returns true if and only if the structure is a 
     *   valid queue.
     */
    public boolean repOK();
    
    /**
     * @post Returns a string representation of the queue. Implements
     *   the abstraction function. Hence, it represents the queue as a 
     *   sequence "[o1, o2,..., on]".
     */
    public String toString();
}
