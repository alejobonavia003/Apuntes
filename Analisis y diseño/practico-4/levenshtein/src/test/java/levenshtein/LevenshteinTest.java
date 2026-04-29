package levenshtein;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 
 * @author vale
 *
 */
public class LevenshteinTest {
	
	
	
	private static Stream<Arguments> levenshteinArgsProvider() { 
		/*
		 * Agregar nuevas entradas de test
		 */
		return Stream.of(
				Arguments.of("hola", "bola", 1), 
				Arguments.of("hola como estas, que lindo dia", "chau como andas, que dia feo", 14) 
		);		
	}
	
	
	@ParameterizedTest(name = "{index}: levenshteinDistanceDC({0}, {1}) = {2}") 
	@MethodSource("levenshteinArgsProvider")
	void levenshteinDCTest(String str1, String str2, int expected ) {
		int result =  Levenshtein.computeLevenshteinDistance(str1,str2);
		assertEquals(expected, result);
	    
	}
	
	
	@ParameterizedTest(name = "{index}: levenshteinDistancePD({0}, {1}) = {2}") 
	@MethodSource("levenshteinArgsProvider")
	void levenshteinPDTest(String str1, String str2, int expected ) {
		int result =  Levenshtein.computeLevenshteinDistancePD(str1,str2);
		assertEquals(expected, result);
	    
	}
	

	@ParameterizedTest(name = "{index}: levenshteinDistanceMemo({0}, {1}) = {2}") 
	@MethodSource("levenshteinArgsProvider")
	void levenshteinMemoTest(String str1, String str2, int expected ) {
		int result =  Levenshtein.computeLevenshteinDistanceMemo(str1,str2);
		assertEquals(expected, result);
	    
	}
	
	
	
	
	
}


