package util.sequences;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


/**
 * Test for  Minimum Sum Subsequence algorithm.
 * It is implemented using JUnit's parameterized tests.
 * 
 * @authors Scilingo
 * @authors Vale Bengolea
 */

public class MinimumSumSubsequenceTest {
	/**
	 * Provides test cases for the minimum subsequence sum problem.  
	 * This method generates a sequence of arguments for parameterized tests.  
	 * @return A stream of arguments, where each argument consists of:
	 *         - An array of integers representing the input sequence.
	 *         - An integer representing the expected minimum subsequence sum.
	 *         - An integer representing the starting index of the subsequence.
	 *         - An integer representing the ending index of the subsequence.
	 */		
      private static Stream<Arguments> minimumSubSeqArgsProvider() { 
		return Stream.of(
				Arguments.of(new Integer[] {}, 0, -1 ,-1), 
				Arguments.of(new Integer[] {1}, 0, -1, -1), 
				Arguments.of(new Integer[] {-2}, -2, 0, 0),				
				Arguments.of(new Integer[] {1, -2}, -2, 1, 1),
				Arguments.of(new Integer[] {1, 2, 3}, 0, -1, -1),
				Arguments.of(new Integer[] {1, -2, 3, -1}, -2, 1, 1),
				Arguments.of(new Integer[] {-2, -1, 1, 2}, -3, 0, 1),
				Arguments.of(new Integer[] {-2, 1, 2, -10, 3, -20}, -27, 3 , 5),
				Arguments.of(new Integer[] {-2, 1, -2, 5, -2, 1, -2}, -3, 4, 6),
				Arguments.of(new Integer[] {-2, 100, -20, 9, 5, -20, 1, 2}, -26, 2, 5)
				
		);		
	}
	
   
    /**
    * Checks whether minimumSumSubsequence implementation correctly compute
    * the minimum Subsequence sum and indexes of the corresponding subsequence for the inputs parameters
    
    * @param seq The input array of integers.  
    * @param expectedSum The expected minimum sum of a subsequence in the array.  
    * @param expectedLowerIndex The expected starting index of the minimum sum subsequence.  
    * @param expectedUpperIndex The expected ending index of the minimum sum subsequence.  
    */
    
    @ParameterizedTest(name = "{index}:  sub Sequences of minimum sum in {0} is ({1},{2},{3})") 
  	@MethodSource("minimumSubSeqArgsProvider")
    public void minimumSubSeqTest(Integer[] seq, int expectedSum, int expectedLowerIndex, int expectedUpperIndex){
    	
        Subseq<Integer> result =  MinimumSumSubsequence.minimumSumSubsequence(seq);    	
       
        int  sum = result.getSum();
        int  lower = result.getLowerIndex();
        int  upper = result.getUpperIndex();
        
        assertEquals(expectedSum,sum);
        assertEquals(expectedLowerIndex, lower);
        assertEquals(expectedUpperIndex, upper);
        
    }
    
}
