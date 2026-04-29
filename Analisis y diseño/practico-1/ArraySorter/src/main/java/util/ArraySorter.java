package util;

import java.util.Random;

/**
 * Sorts arrays of comparable objects using a variety of options.
 * 
 * @author aguirre
 *
 * @param <E> is the type of the elements of the array.
 */
public class ArraySorter<E extends Comparable<E>> {

	/**
	 * The array to sort.
	 */
	private E[] array;
	
	/**
	 * The algorithm to use for sorting.
	 */
	private SortAlgorithm algorithm = SortAlgorithm.SELECTIONSORT;

	/**
	 * Default constructor. Sets the array to sort and sorting algorithm to INSERTION SORT.
	 * @param array is the array to sort.
	 */
	public ArraySorter(E[] array) {
		if (array == null) throw new IllegalArgumentException("array must be non-null");
		this.array = array;
	}

	/**
	 * Constructor that sets array and sorting algorithm.
	 * @param array is the array to sort.
	 * @param algorithm is the algorithm to use for sorting.
	 */
	public ArraySorter(E[] array, SortAlgorithm algorithm) {
		if (array == null) throw new IllegalArgumentException("array must be non-null");
		this.array = array;
		this.algorithm = algorithm;
	}

	/**
	 * Sets the algorithm to use for sorting.
	 * @param algorithm is the algorithm to set for sorting.
	 */
	public void setAlgorithm(SortAlgorithm algorithm) {
		if (algorithm == null) throw new IllegalArgumentException("algorithm can't be null");
		this.algorithm = algorithm;
	}
	
	/**
	 * Retrieves the (sorted or yet unsorted) array within the ArraySorter.
	 * @return the array stored within the ArraySorter object.
	 */
	public E[] getArray() {
		return this.array;
	}

	/**
	 * Sets the array to be sorted.
	 * @param array is the new array to sort.
	 */
	public void setArray(E[] array) {
		throw new UnsupportedOperationException("method not yet implemented");		
	}

	/**
	 * Sorts the array.
	 * The array can then be retrieved using getArray() method.
	 */
	public void sort() {
		switch (this.algorithm) {
		case INSERTIONSORT: 	
			insertionSort(array); 
			break;
		case BUBBLESORT:
			bubbleSort(array); 
			break;
		case SELECTIONSORT:
			selectionSort(array); 
			break;
		default:
            throw new UnsupportedOperationException("sorting method not yet implemented"); 
		}	
	}

	/**
	 * Sorts an array. Implements the insertion sort algorithm.
	 * @param <T> is the type of the elements in the array.
	 * @param array is the array to be sorted.
	 */
	private static <T extends Comparable<T>> void insertionSort(T[] array) {
		if (array == null) throw new IllegalArgumentException("array is null, can't sort");
		for ( int unsorted = 1; unsorted < array.length; unsorted++){
			T key = array[unsorted];
			int loc = unsorted-1;
			while ((loc >= 0) && (array[loc].compareTo(key) > 0)){
				array[loc+1] = array[loc];
				loc--;
			}
			array[loc+1] = key ;
		}
	}

	/**
	 * Sorts an array. Implements the selection sort algorithm.
	 * @param <T> is the type of the elements in the array.
	 * @param array is the array to be sorted.
	 */
	private static <T extends Comparable<T>> void selectionSort(T[] array) {
		for(int i = 0; i<= array.length -1; i++){
			int min = i;
			for(int j = i+1; j<= array.length; j++){
				if (array[j].compareTo(array[min]) < 0){ // si array[j] < array[min]
					min = j;
				}
			}
			if(min != i){
				T aux = array[i];
				array[i] = array[min];
				array[min] = aux;
			}
		}
	}

	/**
	 * Sorts an array. Implements the bubblesort sort algorithm.
	 * @param <T> is the type of the elements in the array.
	 * @param array is the array to be sorted.
	 */
	private static <T extends Comparable<T>> void bubbleSort(T[] array) {
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j<array.length-1;j++){
				if(array[j].compareTo(array[i]) < 0){
					T aux = array[i];
					array[i] = array[j];
					array[j] = aux;
				}
			}
		}
	}

	/**
	 * Checks if a given array is sorted.
	 * @param <T> is the type of the elements in the array.
	 * @param array is the array to be checked for sortedness.
	 * @return true iff the array is sorted.
	 */
	public static <T extends Comparable<T>> boolean isSorted(T[] array) {
		boolean ordenado = true;
		for(int i=0;i<array.length-1;i++){
			if(array[i].compareTo(array[i+1]) > 0){
				ordenado = false;
			}
		}

		return ordenado;
	}

	public static <T extends Comparable<T>> int randomPartition(T[] a, int p, int r){
		Random random = new Random();
		int i = random.nextInt(r);
		T aux = a[r];
		a[r] = a[i];
		a[i] = aux;
		return partition(a, p, r);
	}


	private static <T extends Comparable<T>> int partition(T[] a, int p, int r) {
		T x = a[p];
		int i = p -1;
		int j = r + 1;
		while (true) {
        // bajar j hasta encontrar A[j] <= x
        do { j--; } while (a[j].compareTo(x) > 0);

        // subir i hasta encontrar A[i] >= x
        do { i++; } while (a[i].compareTo(x) < 0);
				if ( i<j){
					T aux = a[i];
					a[i] = a[j];
					a[j] = aux;
				} else {
					return j;
				}
			}
		
	}


	public static <T extends Comparable<T>> void rQuickShort(T[] a,int p,int r){
		if (p<r) {
			int q = randomPartition(a, p, r);
			rQuickShort(a, p, q - 1);
			rQuickShort(a, q+1, r);
		}
	}

	

}
