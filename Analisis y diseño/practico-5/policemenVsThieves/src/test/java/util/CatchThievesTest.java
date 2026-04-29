package util;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests for CatchThieves class.
 * @author sonia
 *
 */
public class CatchThievesTest {
  
  /**
   * Negative test on invalid Thieves and Police sequence.
   */
  @Test
  public void testInvalidSeqTP() {
    CatchThieves catchT = new CatchThieves();
    assertThrows(IllegalArgumentException.class, () -> catchT.maxCatch(null, 0));
    // must break!
  }
  
  /**
   * Negative test on invalid distance.
   */
  @Test
  public void testInvalidDistance() {
    CatchThieves catchT = new CatchThieves();
    char []arr1 = new char[] {'P','T'};
    assertThrows(IllegalArgumentException.class, () -> catchT.maxCatch(arr1, -1));
    // must break!
  }
  
  /**
   * Checks maxCatch for empty sequence.
   */
  @Test
  public void testMaxCatchEmptySeq() {
    CatchThieves catchT = new CatchThieves();
    char []arr1 = new char[] {};
    int output = catchT.maxCatch(arr1, 0);
    assertEquals(0, output);
  }

  /**
   * Checks maxCatch for only thieves.
   */
  @Test
  public void testMaxCatchOnlyThieves() {
    CatchThieves catchT = new CatchThieves();
    char []arr1 = new char[] {'T','T'};
    int output = catchT.maxCatch(arr1, 1);
    assertEquals(0, output);
  }
  
  /**
   * Checks maxCatch for only policemen.
   */
  @Test
  public void testMaxCatchOnlyPol() {
    CatchThieves catchT = new CatchThieves();
    char []arr1 = new char[] {'P','P'};
    int output = catchT.maxCatch(arr1, 1);
    assertEquals(0, output);
  }
  
  /**
   * Checks maxCatch for less Policemen than thieves.
   */
  @Test
  public void testMaxCatchMoreThieves() {
    CatchThieves catchT = new CatchThieves();
    char []arr1 = new char[] {'P','T','T','P','T'};
    int output = catchT.maxCatch(arr1, 1);
    assertEquals(2, output);
  }
  
  /**
   * Checks maxCatch for same number of Police than thieves.
   */
  @Test
  public void testMaxCatchEqTP() {
    CatchThieves catchT = new CatchThieves();
    char []arr1 = new char[] {'T','T','P','P','T','P'};
    int output = catchT.maxCatch(arr1, 2);
    assertEquals(3, output);
  }
  
  /**
   * Checks maxCatch for greater Distance.
   * 
   */
  @Test
  public void testMaxCatchDistance3() {
    CatchThieves catchT = new CatchThieves();
    char []arr1 = new char[] {'P','T','P','T','T','P'};
    int output = catchT.maxCatch(arr1, 3);
    assertEquals(3, output);
  }
  

}
