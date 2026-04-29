package sorting;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

/**
 * The test class InsertionTest.
 */
public class InsertionTest
{
    
    
    @Test
    public void test0()
    {
        Integer [] arr = new Integer [] {3,2,1};
        Integer [] expected = new Integer [] {1,2,3};        
        Sorting s = new Insertion();
        s.sort(arr);
        assertTrue(Arrays.equals(arr, expected));
        assertTrue(s.isSorted(arr));
    }
    
    @Test
    public void test1()
    {
        Integer [] arr = new Integer [] {2,3,1,5,6,9,6,3};
        Integer [] expected = new Integer [] {1,2,3,3,5,6,6,9};
        Sorting s = new Insertion();
        s.sort(arr);
        assertTrue(Arrays.equals(arr, expected));
        assertTrue(s.isSorted(arr));
    }
    
    
    @Test
    public void test2()
    {
        Character [] arr = new Character [] {'S','O','R','T','E','X','A','M','P','L','E'};
        Character [] expected = new Character [] {'A','E','E','L','M','O','P','R','S','T','X'};        
        Sorting s = new Insertion();
        s.sort(arr);
        assertTrue(Arrays.equals(arr, expected));
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void test3()
    {
        Character [] arr = new Character [] {'S','S','S','S','S','P'};
        Character [] expected = new Character [] {'P','S','S','S','S','S'}; 
        Sorting s = new Insertion();
        s.sort(arr);
        assertTrue(Arrays.equals(arr, expected));
        assertTrue(s.isSorted(arr));
    }
    
    @Test
    public void test4()
    {
        Integer [] arr = new Integer [] {9,6,5,3,2,1};
        Integer [] expected = new Integer [] {1,2,3,5,6,9};
        Sorting s = new Insertion();
        s.sort(arr);
        assertTrue(Arrays.equals(arr, expected));
        assertTrue(s.isSorted(arr));
    }
    
    @Test
    public void test5() {
        Integer [] arr = new Integer [] {457,    238,    7900,    576,    1890,    777,    158,    914,    476,    15800,    1152,    3780,    1554,    316};
        Integer [] expected = new Integer [] {158,    238,    316,    457,    476,    576,    777,    914,    1152,    1554,    1890,    3780,    7900,    15800};
        Sorting s = new Insertion();
        s.sort(arr);
        assertTrue(Arrays.equals(arr, expected));
        assertTrue(s.isSorted(arr));
    }
    
    @Test
    public void test6() {
        Integer [] arr = new Integer [] {192,    630,    259,    384,    1260,    518,    768,    2520,    1036,    1536,    5040,    2072};
        Integer [] expected = new Integer [] {192,    259,    384,    518,    630,    768,    1036,    1260,    1536,    2072,    2520,    5040};
        Sorting s = new Insertion();
        s.sort(arr);
        assertTrue(Arrays.equals(arr, expected));
        assertTrue(s.isSorted(arr));
    }
    
   
  
}
