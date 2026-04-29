import java.util.Iterator;
import java.util.Set;
/**
 * SortedSet are unbounded sets of objects of type T. 
 * A typical SortedSet is {o1, . . . , on}.
 *
 * SortedSet requires that the key type T implements the 
 * Comparable interface.
 *
 * The methods use compareTo to determine equality of elements.
 */
public interface SortedMap<K extends Comparable<? super K >, V extends Comparable<? super V>> extends Iterable<K>{
    

    public V put(K key, V value);

    public V removeKey(K key);

    public V get(K key);

    public int size();

    public boolean isEmpty();

    public V min();

    public void removeMin();

    public Set<K> keySet();

    public boolean containsKey(K key);

    public Iterator<K> iterator();

}