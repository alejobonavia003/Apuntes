
  package util.unittest;

  import static org.junit.Assert.*;

  import java.util.Arrays;
  import java.util.Collection;

  import org.junit.Test;
  import org.junit.runner.RunWith;
  import org.junit.runners.Parameterized;

  import util.ArraySorter;
  import util.SortAlgorithm;

  /**
   * Checks properties of the insertion sort algorithm, within class ArraySorter.
   * It is implemented using jUnit's parameterized tests.
   * 
   * @author aguirre
   *
   */
  @RunWith(Parameterized.class)
  public class InsertionSortSmallArraysTest {

    /**
     * Attribute where the array to sort is stored.
     */
    private Integer[] array;

    /**
     * Default constructor for parameterized tests.
     * Sets elements from Parameters into the array to sort.
     * @param params is the collection of arrays to sort.
     */
    public InsertionSortSmallArraysTest(Object [] params) {
      this.array = (Integer[]) params;
    }

    /**
     * Contains the arrays to use for tests.
     * This method contains the inputs to be used for testing.
     * New tests are added by adding new inputs here.
     * See test methods in this class, for actual properties
     * being checked.
     * @return an array of integer arrays, used as parameters for tests.
     */
    @SuppressWarnings("rawtypes")
    @Parameterized.Parameters
    public static Collection smallArrays() {

      return Arrays.asList(new Object[][] {
        { new Integer[] {1, 3, 5, 6, 6, 19, 31} },
        { new Integer[] {11, 3, 5, -6, 6, 19, 31, 0, 0, 33, 9, -15}},
        { new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}},
        { new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}},
        { new Integer[] {1} },
        { new Integer[] {} }
      });

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
