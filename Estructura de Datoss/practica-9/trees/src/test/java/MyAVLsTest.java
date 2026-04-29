
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class MyAVLsTest.
 */
public class MyAVLsTest
{
     
  @Test
  public void test1()
  {
        SortedSet<Integer> set = new MyAVLs<Integer>();
        set.add(0);
        set.add(3);
        set.add(1);
        set.add(-1);    
        assertEquals(4, set.size());
        assertEquals(set.contains(0), true);
        assertEquals(set.contains(-2), false);        
        assertEquals(set.contains(3), true);        
        assertEquals(set.contains(1), true);
        assertEquals(set.contains(-1), true);
    }
    
   
    @Test
    public void test2()
    {
        MyAVLs<Integer> set = new MyAVLs<Integer>();
        assertThrows(NoSuchElementException.class, 
          ()-> set.removeMin());
    }

    @Test
    public void test3()
    {
        MyAVLs<Integer> set = new MyAVLs<Integer>();
        set.add(0);
        set.add(-2);
        set.removeMin();
        assertEquals(set.contains(0), true);
        assertEquals(set.contains(-2), false);
        assertEquals(1, set.size());
        assertEquals("{}", set.toString());
    }
 
}
