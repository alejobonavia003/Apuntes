package sorting;

import java.util.Arrays;

/**
 *  Implements the insertion sort algorithm for
 *  sorting an array.
 */
public class Insertion extends Sorting {

    /**
     * @post Creates an object that encapsulates the selection 
     *   sort algorithm.
     */
    public Insertion() { }

    /**
     * @post Rearranges the array a in ascending order
     *   using the insertion sort algorithm.
     */
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
        // Invariant: a[0...i-1] is sorted
            assert isSorted(a, 0, i-1);
            // Insert a[i] in sorted order in a[0...i]
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            // a[0...i] is now sorted
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

}