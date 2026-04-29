package util.math;


/**
* This class implements several algorithms to solve the Matrix Chain
* Multiplication problem. The goal is to find the optimal way to parenthesize
* a chain of matrices so that the total number of scalar multiplications is minimized.
* 
* Matrix A[i] has dimensions chain[i-1] x chain[i] for i = 1 to n.
*/
public class MatrixChainMultiplication{
	
	
    /** Array containing the dimensions of the matrices. */
	private Integer[] chain;    
		
    /** Table to store the index of the optimal split point*/
    private int [][] splitPoints; 

   
    
    /**
     * Constructs a new MatrixChainMultiplication object with the given matrix dimensions.
     *
     * @param chain an array where matrix A[i] has dimensions chain[i-1] x chain[i]
     */
    public MatrixChainMultiplication(Integer[] chain){
		this.chain = chain;
		this.splitPoints = new int [chain.length][chain.length];
	}
    
    /**
     * Solves the matrix chain multiplication problem using the specified algorithm.
     *
     * @param algorithm the algorithm to use (Divide & Conquer, Dynamic Programming, Memoization)
     * @return an OptimalParenthesization object containing the minimum cost and the optimal parenthesization as a string
     */
    public OptimalParenthesization matrixChainMultiplication(MatrixChainMultAlgorithm algorithm){
		int cost = 0;
		switch (algorithm) {
			case DIVIDEANDCONQUER:
		    	 cost = divideAndConquerMCM(chain,1,chain.length-1);
		    	 break;
  		    case DYNAMICPROGRAMMING:
  		    	  cost = dynamicProgrammingMCM(chain);
  		    	  break;
  		    case MEMOIZATION:
                // Uncomment when memoized version is implemented
  		    	// return matrixChainMultiplicationMEMO(chain,1,chain.length-1);  
  		    	break;
  		    default:
		        throw new UnsupportedOperationException("");
		}
		
		String parenthesized = buildParenthesized(1,chain.length-1);
		
		return new OptimalParenthesization(cost, parenthesized);
		    
	}
    
    
    /**
     * Recursively constructs the optimal parenthesization using the splitPoints table.
     *
     * @param i start index
     * @param j end index
     * @return a string representing the optimal parenthesization from matrix M_i to M_j
     */
    private String buildParenthesized(int i, int j) {
      //si el ultimo indice es igual al primero solo hay una matriz
        if (i == j) {
            return "M" + i;
        }
        int k = splitPoints[i][j]; //guardo el corte en k
        String left = buildParenthesized(i, k); 
        String right = buildParenthesized(k + 1, j);
        return "(" + left + right + ")";
    }


    
    
    
    /**
     * Solves the matrix chain multiplication problem using the Divide & Conquer technique.
     *
     * @param chain the array of matrix dimensions
     * @param i  start index
     * @param j  end index
     * @return the minimum number of scalar multiplications needed
     */
    private int divideAndConquerMCM(Integer[] chain, int i, int j) {
        // Caso base: una sola matriz costo 0
        if (i == j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        int bestK = -1;

        // Probar todos los posibles puntos de corte
        for (int k = i; k < j; k++) {
            // Calcular costo del subproblema izquierdo y derecho
            int costLeft = divideAndConquerMCM(chain, i, k);
            int costRight = divideAndConquerMCM(chain, k + 1, j);

            // Costo de multiplicar los dos resultados parciales
            int costMerge = chain[i - 1] * chain[k] * chain[j];
            int totalCost = costLeft + costRight + costMerge;

            // Guardar el mínimo
            if (totalCost < minCost) {
                minCost = totalCost;
                bestK = k;
            }
        }

        // Registrar el mejor punto de corte
        splitPoints[i][j] = bestK;

        return minCost;
    }

    

    /**
     * Solves the matrix chain multiplication problem using Dynamic Programming.
     *
     * @param chain the array of matrix dimensions
     * @return the minimum number of scalar multiplications needed
     */ 
    private int dynamicProgrammingMCM(Integer[] chain) {
        int n = chain.length; // cantidad de dimensiones, o sea n matrices = n-1
        int[][] m = new int[n][n]; // costos mínimos

        //los casos base son 0 (multiplicar una matriz por si misma)
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        // l = longitud de la cadena (número de matrices en el subproblema)
        for (int l = 2; l < n; l++) { 
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                // probamos todos los posibles puntos de corte k
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + chain[i - 1] * chain[k] * chain[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        splitPoints[i][j] = k;
                    }
                }
            }
        }

        return m[1][n - 1];
    }



}
