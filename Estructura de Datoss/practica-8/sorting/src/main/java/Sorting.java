package sorting;


/**
 * Base class for sorting algorithms.
 */
public abstract class Sorting
{
    /**
     * @post Rearranges the array a in ascending order.
     */
    public abstract void sort(Comparable[] a);
    
    
    /**
     * @post Returns true iff v is smaller than w.
     */
    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * @pre {@code 0<=i<a.length && 0<=j<a.length}
     * @post Swaps the elements in positions i and j of a.
     */
    protected static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    /**
     * @post Returns true iff array a is sorted in ascending order.
     */
    protected boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    /**
     * @post Returns true iff positions within lo and hi of a 
     *   are sorted in ascending order.
     */
    protected boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
}
