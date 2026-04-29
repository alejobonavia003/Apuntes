package util.unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;

import util.ArraySorter;
import util.SortAlgorithm;

/**
 * Checks properties of the insertion sort algorithm, within class ArraySorter.
 * It is implemented using jUnit's parameterized tests. It uses larger inputs,
 * so tests in this class are expected to be more costly.
 * Test inputs in these tests are randomly generated (beware of flaky results).
 * 
 * @author aguirre
 *
 */
@RunWith(Parameterized.class)
public class InsertionSortLargeArraysTest {

	/**
	 * Number of arrays to be used for testing (set of inputs for testing)
	 */
	private static final int NUMARRAYS = 100;

	/**
	 * Increment in the size of arrays to be used for testing.
	 * Test inputs are arrays of size INCREMENT * i, for i in [0..NUMARRAYS-1].
	 */
	private static final int INCREMENT = 100;

	/**
	 * Attribute where the array to sort is stored.
	 */
	private Integer[] array;

	/**
	 * Default constructor for parameterized tests.
	 * Sets elements from Parameters into the array to sort.
	 * @param array is the collection of arrays to sort.
	 */
	public InsertionSortLargeArraysTest(Object [] array) {
		this.array = (Integer[]) array;
	}

	/**
	 * Generates the arrays to use for testing.
	 * This method contains the inputs to be used for testing.
	 * Tests are generated randomly. Values in arrays are randomly
	 * picked from a range proportional to the size of the array.
	 * See test methods in this class, for actual properties
	 * being checked.
	 * @return an array of integer arrays, used as parameters for tests.
	 */
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection biggerArrays() {

		Random random = new Random();

		List<Integer[][]> arrays = new ArrayList<Integer[][]>();
		for (int i = 0; i < NUMARRAYS; i++) {
			Integer[] array = new Integer[INCREMENT * i];
			Arrays.setAll(array, (v) -> random.nextInt() % array.length);
			arrays.add(new Integer[][] {array} );
		}
		return arrays;
	}


	/**
	 * Checks whether insertion sort leaves the output array sorted.
	 * This is a parameterized unit test. See parameters elsewhere in this class.
	 */
	@Test
	public void insertionSortLeavesArraySorted() {

		ArraySorter<Integer> sorter = new ArraySorter<Integer>(array, SortAlgorithm.INSERTIONSORT);

		sorter.sort();

		assertTrue(ArraySorter.isSorted(array));
	}

	/**
	 * Checks whether insertion sort correctly sorts an array.
	 * This test uses differential testing, comparing with the output of
	 * util.Arrays.sort(E[]).
	 * This is a parameterized unit test. See parameters elsewhere in this class.
	 */
	@Test
	public void insertionSortSortsCorrectly() {

		Integer[] clonedArray = array.clone();
        Arrays.sort(clonedArray);

		ArraySorter<Integer> sorter = new ArraySorter<Integer>(array, SortAlgorithm.INSERTIONSORT);

		sorter.sort();

		assertArrayEquals(clonedArray, array);
	}

}
