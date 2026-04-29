package util.math;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



/**
 * Unit test class for MatrixChainMultiplication.
 * This class tests the correctness of different algorithms used to solve
 * the Matrix Chain Multiplication problem.
 */
public class MatrixChainMultiplicationTest {
	
	
	private static Stream<Arguments> matrixChainMultArgsProvider() { 
			
		return Stream.of(
				Arguments.of(new Integer[] {13, 5, 89, 3, 34}, 2856, "((M1(M2M3))M4)"), 
				Arguments.of(new Integer[] {10, 30, 5, 60}, 4500, "((M1M2)M3)"), 
				Arguments.of(new Integer[] {10, 30, 5}, 1500,"(M1M2)"),
				Arguments.of(new Integer[] {10, 30}, 0, "M1"),
				Arguments.of(new Integer[] {10, 100, 5, 50}, 7500, "((M1M2)M3)")
				
				
		);		
	}
	
	
	@ParameterizedTest(name = "{index}: divideAndConquerMCM({0}) =  ({1},{2}") 
	@MethodSource("matrixChainMultArgsProvider")
	void divideAndConquerMCMTest(Integer[] chain, int expectedCost, String expectedParenth) {
		
		MatrixChainMultiplication mcm = new MatrixChainMultiplication(chain);
		OptimalParenthesization optimal = mcm.matrixChainMultiplication(MatrixChainMultAlgorithm.DIVIDEANDCONQUER);
		
		Assertions.assertAll(
	            () -> assertEquals(expectedCost, optimal.getCost()),
	            () -> assertEquals(expectedParenth, optimal.getParenthesization())
	    );
		
	    
	}
	
	
	@ParameterizedTest(name = "{index}: dynamicProgrMCM({0}) =  ({1},{2}") 
	@MethodSource("matrixChainMultArgsProvider")
	void dynamicProgrMCMTest(Integer[] chain, int expectedCost, String expectedParenth) {
		
		MatrixChainMultiplication mcm = new MatrixChainMultiplication(chain);
		OptimalParenthesization optimal = mcm.matrixChainMultiplication(MatrixChainMultAlgorithm.DYNAMICPROGRAMMING);
	   
		Assertions.assertAll(
	            () -> assertEquals(expectedCost, optimal.getCost()),
	            () -> assertEquals(expectedParenth, optimal.getParenthesization())
	    );
		
	}
	
	
	

}
