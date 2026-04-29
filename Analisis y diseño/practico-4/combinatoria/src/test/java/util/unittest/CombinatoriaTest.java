package util.unittest;



import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import combinatoria.Combinatoria;



/**
 * 
 * @author vale
 *
 */
public class CombinatoriaTest {
	
	
	private static Stream<Arguments> combinatoriaArgsProvider() { 
		return Stream.of(
				Arguments.of(5, 3, 10), 
				Arguments.of(10, 3, 120), 
				Arguments.of(10, 6, 210),
				Arguments.of(8, 5, 56),
				Arguments.of(14, 3, 364)

				
				
		);		
	}
	
	
	@ParameterizedTest(name = "{index}: ({0} /{1}) = {2}") 
	@MethodSource("combinatoriaArgsProvider")
	void combinatoriaTest(int n, int m, int expected) {
    	int result = Combinatoria.combinatoria(n,m);
	    assertEquals(expected, result); 
	}
	
	@ParameterizedTest(name = "{index}: ({0} /{1}) = {2}") 
	@MethodSource("combinatoriaArgsProvider")
	void PDCombinatoriaTest(int n, int m, int expected) {
    	int result = Combinatoria.PDCombinatoria(n,m);
	    assertEquals(expected, result); 
	}
	
	
	
	
	private static Stream<Arguments> combinatoriaArgsProvider2() { 
		return Stream.of(
				Arguments.of(5, 3), 
				Arguments.of(10, 3), 
				Arguments.of(10, 6),
				Arguments.of(8, 5),
				Arguments.of(14, 3)

				
				
		);		
	}
	
	
	
	@ParameterizedTest(name = "{index}: ({0} /{1})") 
	@MethodSource("combinatoriaArgsProvider2")
	void memoCombinatoriaTest(int n, int m) {
	    assertEquals(Combinatoria.memoCombinatoria(n,m), Combinatoria.PDCombinatoria(n,m)); 
	}
	
	 
	
}




