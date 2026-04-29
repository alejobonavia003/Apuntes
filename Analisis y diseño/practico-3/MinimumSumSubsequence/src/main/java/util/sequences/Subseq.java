package util.sequences;


/**
 * Represents a subsequence with its associated sum and index range.  
 * This class stores the sum of a subsequence along with its lower and upper indices  
 * in an array, providing methods to access and modify these values.  
 * 
 * @param <T> The type of the sum value (e.g., Integer, Double).  
 */

public class Subseq<T>{

	
	private T sum;
	private int lowerIndex;
	private int upperIndex;

	/** 
     * Default constructor.  
     * Initializes the subsequence with a null sum and indices set to -1.  
     */
  	public Subseq() {
	    this.sum = null;
	    this.lowerIndex = -1;
	    this.upperIndex = -1;
	}
  
  	/** 
     * Parameterized constructor.  
     * Initializes the subsequence with the given sum and index range.  
     * 
     * @param sum The sum of the subsequence.  
     * @param lower The starting index of the subsequence.  
     * @param upper The ending index of the subsequence.  
     */
	public Subseq(T sum, int lower, int upper) {
		
		this.sum = sum;
		this.lowerIndex = lower;
		this.upperIndex = upper;
	}

	public T getSum(){
		return sum;
	}

	public void setSum(T sum){
		this.sum = sum;
	}

	public int getLowerIndex(){
		return lowerIndex;
	}

	public void setLowerIndex(int lower){
		this.lowerIndex = lower;
	}

	public int getUpperIndex(){
		return upperIndex;
	}

	public void setUpperIndex(int upper){
		this.upperIndex = upper;
	}

	public static Subseq<Integer> minSeq(Subseq<Integer> a, Subseq<Integer> b ){
		if(a.sum.compareTo(b.sum) < 0){
			return a;
		} else {
			return b;
		}
	}

    /** 
     * Converts the Subseq object to a string representation.  
     * @return A string in the format (sum, lowerIndex, upperIndex).  
     */
	@Override
	public String toString() {
		return ("(" + sum.toString() + "," + lowerIndex + "," + upperIndex + "," + ")");
	}
  
	/** 
     * Compares this Subseq object with another for equality.  
     * Two Subseq objects are equal if they have the same sum, lower index, and upper index.  
     * 
     * @param other The object to compare with.  
     * @return {@code true} if the objects are equal, otherwise {@code false}.  
     */
  	@Override
  	public boolean equals(Object other) {
	    if (other == null) {
	      return false;
	    } 
	    if (!(other instanceof Subseq)) {
	      return false;
	    }
	    Subseq<T> actualOther = (Subseq<T>) other;
	    boolean equals = actualOther.getSum().equals(this.sum);
	    equals &= actualOther.getLowerIndex() == this.lowerIndex;
	    equals &= actualOther.getUpperIndex() == this.upperIndex;
	    return equals;    
	}

}