package knapSack;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 
 * @author vale
 *
 */

public class KnapsackTest {

	
	private static Stream<Arguments> knapSackArgsProvider() { 
		return Stream.of(
				//Values, weights, Total weight, expected value
				Arguments.of(new int[]{60, 100, 120}, new int[] {10, 20, 30}, 50, 220),
				Arguments.of(new int[]{10, 20, 30}, new int[] {1, 3, 4}, 3, 20),
				Arguments.of(new int[]{100, 200, 300}, new int[] {50, 60, 70}, 10, 0),
				Arguments.of(new int[]{5, 10, 15}, new int[] {1, 2, 3}, 6, 30),
				Arguments.of(new int[]{24, 18, 18, 10}, new int[] {24, 10, 10,7}, 25, 36)
				
		);		
	}
	
	
	@ParameterizedTest(name = "{index}: knapSack({0}, {1}, {2}) =  {3}") 
	@MethodSource("knapSackArgsProvider")
	void knapSackDCTest( int [] itemsValues, int[] itemWeight,int W, int expectedValue) {
		int value = Knapsack.knapSack(W, itemWeight, itemsValues);
		assertEquals(expectedValue,value);
	}
	
	
	
	@ParameterizedTest(name = "{index}: knapSackPD({0}, {1}, {2}) =  {3}") 
	@MethodSource("knapSackArgsProvider")
	void knapSackPDTest( int [] itemsValues, int[] itemWeight,int W, int expectedValue) {
		int value = Knapsack.knapSackPD(W, itemWeight, itemsValues);
		assertEquals(expectedValue,value);
	}
	
	/** 
	@Test(timeout = 40000)//tenia 4000
	public void testEfficient() {

		int [] itemsValues = {60, 100, 120, 60, 30 ,30, 40, 50, 10, 40, 60, 100, 120, 60, 30 ,30, 40, 50, 10, 40, 60, 100, 120, 60, 30 ,30, 40, 50, 10, 40, 60, 100, 120, 60, 30 ,30, 40, 50, 10, 40,60, 100, 120, 60, 30 ,30, 40, 50, 10, 40, 60, 100, 120, 60, 30 ,30, 40, 50, 10, 40, 60, 100, 120, 60, 30 ,30, 40, 50, 10, 40, 60, 100, 120, 60, 30 ,30, 40, 50, 10, 40};
		int [] itemWeigth = {10, 20, 30, 10, 5, 6, 9, 4, 10, 12, 10, 20, 30, 10, 5, 6, 9, 4, 10, 12,10, 20, 30, 10, 5, 6, 9, 4, 10, 12, 10, 20, 30, 10, 5, 6, 9, 4, 10, 12, 10, 20, 30, 10, 5, 6, 9, 4, 10, 12, 10, 20, 30, 10, 5, 6, 9, 4, 10, 12,10, 20, 30, 10, 5, 6, 9, 4, 10, 12, 10, 20, 30, 10, 5, 6, 9, 4, 10, 12};
				
		int W = 100;
 		
		int value = Knapsack.knapSack(W, itemWeigth, itemsValues);
		assertEquals(790,value);
		
	}
	
*/
	
	
	
}
