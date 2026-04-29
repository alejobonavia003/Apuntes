package combinatoria;

import java.util.HashMap;
import java.util.Map;

public class Combinatoria {

	static HashMap<Pair, Integer> map = new HashMap<>();

	
	/**
	 * Calculates the binomial coefficient C(n, m), also known as "n choose m",
	 * using a recursive approach.
	 * @param n the total number of items 
	 * @param m the number of items to choose 
	 * @return the number of combinations of n items taken m at a time
	 * @throws IllegalArgumentException if n or m is negative
	 */
	
	public static int combinatoria(int n, int m) {
		if (n<0  || m <0)  
			throw new IllegalArgumentException("error");
		if (m > n) return 0;
		if (m == 0 || n == m) return 1;
		return combinatoria((n-1),(m-1)) + combinatoria((n-1),m);	
	}

	
	/**
	 * This method should be implemented using recursion with caching (memoization)
	 * to avoid redundant calculations and improve performance.
	 *
	 * @param n the total number of items
	 * @param m the number of items to choose
	 * @return the number of combinations of n items taken m at a time
	 * @throws UnsupportedOperationException until the method is implemented
	 */
	public static int memoCombinatoria(int n, int m) {
		if (n<0 || m<0){
			throw new IllegalArgumentException("no pasa paraetro bien ");
		}

		if (m>n) return 0;
		if(m==0 || n == m) return 1;

		Pair p = new Pair<>(n, m);

		//si ya lo calculamos buscamos el resultado y lo retornamos
		if(map.containsKey(p)){
			return map.get(p);
		}

		//si no encontramos el resultado lo calculamos y lo guardamos
		int rez = memoCombinatoria(n-1, m-1) + memoCombinatoria(n-1, m);
		map.put(p, rez);

		return rez;
	}
	
	
	
	/**
	 * This method should use a bottom-up approach to build a table of values
	 * for all combinations up to n and m.
	 *
	 * @param n the total number of items
	 * @param m the number of items to choose
	 * @return the number of combinations of n items taken m at a time
	 * @throws UnsupportedOperationException until the method is implemented
	 */
	public static int PDCombinatoria(int n, int m) {
    	if (n<0 || m<0){
			throw new IllegalArgumentException("no");
		}
		if(m>n){
			return 0;
		}
		int[][] comb = new int[n+1][m+1];
		for (int i=0;i<=n;i++){
			comb[i][0] = 1;
			if (i<=m){
				comb[i][i] = 1;
			}
		}

		for(int i=2;i<=n;i++){
			for(int j=1;j<=m && j<i;j++){
				comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
			}
		}

		return comb[n][m];

	}
	

}

