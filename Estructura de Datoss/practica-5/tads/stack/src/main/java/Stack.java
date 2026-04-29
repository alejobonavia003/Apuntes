

 
import java.util.Iterator;

/**
 * Stack represents unbounded, last-in-first-out (LIFO) 
 * stack of objects of type T.
 * 
 * A typical Stack is a sequence [o1, o2,..., on]; we 
 * denote this by: this = [o1, o2,..., on].
 * 
 * The methods use equals to determine equality of elements.
 */
public interface Stack<T> extends Iterable<T>
{
    /**
     * @post Returns the number of elements in the stack.
     *   More formally, it satisfies: result = #this.
     */
    public int size();

    /**
     * @post Returns true iff the stack contains no elements.
     *   More formally, it satisfies: result = (this = []).
     */
    public boolean isEmpty(); 
    
    /**
     * @post Adds element e to the top of the stack.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    public void push(T e);
    
    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Removes and returns the item at the top of the stack.
     *   More formally, it satisfies: 
     *     let old(this) = s1 ++ [e] |
     *       this = s1 && result = e.
     */
    public T pop(); 
 
    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Returns the item at the top of the stack.
     *   More formally, it satisfies:
     *     let this = s1 ++ [e] | result = e.
     */
    public T top();
    
    /**
     * @post Returns an iterator for the stack that iterates through 
     *   the items in LIFO order.
     */
    public Iterator<T> iterator();
        
    /**
     * @post Returns a string representation of the stack. Implements
     *   the abstraction function. Hence, it represents the stack as a 
     *   sequence "[o1, o2,..., on]".
     */
    public String toString();



}
