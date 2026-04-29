package catalannumber;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 
 * @author vale
 *
 */
public class CatalanNumberTest {

	private static Stream<Arguments> catalanArgsProvider() { 
		return Stream.of(
				Arguments.of(0, 1), 
				Arguments.of(1, 1), 
				Arguments.of(2, 2),
				Arguments.of(3, 5),
				Arguments.of(4, 14),
				Arguments.of(5, 42),
				Arguments.of(6, 132)
				
		);		
	}
	
	@ParameterizedTest(name = "{index}: CatalanNumber({0}) =  {1}") 
	@MethodSource("catalanArgsProvider")
	void catalanNumberTest(int c, long expected) {
    	long result = CatalanNumber.computeCatalanNumber(c);
	    assertEquals(expected, result); 
	}
	

	/**
	 * This test uses the inefficient recursive implementation.
	 * It is expected to fail due to a timeout when computing the 20th Catalan number.
	 * Replacing the method call with a more efficient implementation 
	 * (e.g., dynamic programming or memoization) should make the test pass.
	 */
	@Test
	@Timeout(1)
	public void testEfficient(){
		
		assertEquals(6564120420L, CatalanNumber.computeCatalanNumber(20));
				
	}
	
	/*
	 * Test for Catalan Number Dynamic Programming solution
	 * 
	 * */
	

	@ParameterizedTest(name = "{index}: CatalanNumberPD({0}) =  {1}") 
	@MethodSource("catalanArgsProvider")
	void PDCatalanNumberTest(int c, long expected) {
    	long result = CatalanNumber.computeCatalanNumberPD(c);
	    assertEquals(expected, result); 
	}
	
	
	
	/*
	 * Test to verify that the top-down memoization implementation of Catalan numbers 
	 * produces the same results as the bottom-up dynamic programming approach.
	 */
	
	@ParameterizedTest(name = "{index}: CatalanNumberMemo({0}) =  CatalanNumberPD({0})") 
	@ValueSource(ints = {1, 2, 3, 5, 7, 8, 9, 10, 12, 20, 23, 18})
	void MemoCatalanNumberTest(int c) {
	    assertEquals(CatalanNumber.computeCatalanNumberPD(c), CatalanNumber.computeCatalanNumberMemo(c)); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
