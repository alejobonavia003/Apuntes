package levenshtein;

import java.util.HashMap;
import java.util.Map;



/**
 * This class provides methods to compute the Levenshtein Distance between two strings.
 * 
 * The Levenshtein Distance is the minimum number of single-character edits
 * (insertions, deletions, or substitutions) required to change one string into the other.
 *
 * Three implementations are provided:
 * - Plain recursion
 * - Dynamic programming (bottom-up)
 * - Memoization 
 */
public class Levenshtein {
	
	
	
	/**
     * Computes the Levenshtein Distance using dynamic programming (bottom-up approach).
     *
     * @param str1 the first string
     * @param str2 the second string
     * @return the Levenshtein distance between str1 and str2
     */
	public static int computeLevenshteinDistancePD(String str1, String str2) {
		throw new UnsupportedOperationException("You MUST implement this method");

	}
	

	private static int minimum(int a, int b, int c) {
		int min =0;
		min = (a<b)? a: b;
		
		if (min>c)min = c;
		
		return min;
	}
	
	 /**
     * Computes the Levenshtein Distance using Divide and Conquer.
     * 
     * This method is inefficient for large strings due to repeated calculations.
     *
     * @param str1 the first string
     * @param str2 the second string
     * @return the Levenshtein distance between str1 and str2
     */
	public static int computeLevenshteinDistance(String str1, String str2) {

		throw new UnsupportedOperationException("You MUST implement this method");

	}


	

    /**
     * Computes the Levenshtein Distance using memoization
     * 
     * @param str1 the first string
     * @param str2 the second string
     * @return the Levenshtein distance between str1 and str2
     */
    public static int computeLevenshteinDistanceMemo(String str1, String str2) {
    
		throw new UnsupportedOperationException("You MUST implement this method");

    }


}
