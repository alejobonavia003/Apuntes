package MyArrayList;
/**
 * List represents unbounded sequences of objects of type T.
 * 
 * A typical List is a sequence [o1, o2,..., on]; we 
 * denote this by: this = [o1, o2,..., on].
 * 
 * The methods use equals to determine equality of elements.
 */
public interface List<T> {
        
    /**
     * @post Returns the number of elements in the list.
     *   More formally, it satisfies: result = #this.
     */
    public int size();

    /**
     * @post Returns true iff the list contains no elements.
     *   More formally, it satisfies: result = #this = 0.
     */
    public boolean isEmpty();
    
    /**
     * @post Returns true iff the list contains element e.
     *   More formally, it satisfies: 
     *   result = exists o | o in this && e.equals(o).
     */
    public boolean contains(T e);
    
    /**
     * @post Appends element e to the end of this list.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    public void add(T e);
    
    /**
     * @post Removes the first occurrence of e from this list.
     *   If e is not in the list it does not modify the list.
     *   Returns true iff e is removed (result = e in old(list)).
     */
    public boolean remove(T e);
    
    /**
     * @post Removes all of the elements from the list,
     *   More formally, it satisfies: #this = 0.
     */
    public void clear();
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Returns the element at position index in the list,
     *   More formally, it satisfies: result = this[index].
     */
    public T get(int index);
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Replaces the element at position index with e, and returns
     *   the element that was replaced.
     *   More formally, it satisfies: 
     *     this[index].equals(e) && #this = #old(this) && 
     *     result.equals(old(this)[index]).
     */
    public T set(int index, T e);
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Inserts the element at position index with e.
     *   More formally, it satisfies: 
     *   this[index].equals(e) && #this = #old(this) +1.
     */
    public void add(int index, T e);
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Removes the element at position index.
     *   More formally, it satisfies: 
     *   result = old(this)[index] && #this = #old(this) -1.
     */
    public T remove(int index);
    
    /** 
     * @post Returns the index of the first occurrence of e
     *   in the list, or -1 if this list does not contain e.
     *   More formally, it satisfies: 
     *     result = -1 -> !(e in this) && 
     *     result != -1 -> this[result].equals(e).
     */
    public int indexOf(T e);

    public int idexOfLauti();
    
}