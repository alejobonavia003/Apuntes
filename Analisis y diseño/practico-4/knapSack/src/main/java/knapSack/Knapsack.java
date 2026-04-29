package knapSack;

import java.util.HashMap;
import java.util.Map;



/**
 * This class implements different versions of the Knapsack problem.
 * 
 * Methods included:
 * - Pure recursive solution
 * - Dynamic Programming (bottom-up tabulation)
 * - Memoization 
 */
public class Knapsack {
	
	
	
	/**
     * Solves the Knapsack problem using plain recursion.
     *
     * @param W the maximum capacity of the knapsack
     * @param itemsWeight array of item weights
     * @param itemsValue array of item values
     * @return the maximum value that can be obtained without exceeding capacity
     */
	public static int knapSack(int W, int [] itemsWeight, int [] itemsValue) {
		return knapSack(W, itemsWeight, itemsValue, itemsWeight.length);
	}
	
	
	/**
     * Recursive helper function for the knapsack problem.
     *
     * @param w remaining capacity
     * @param itemsWeight array of item weights
     * @param itemsValue array of item values
     * @param i number of items to consider
     * @return the maximum value possible
     */
	private static int knapSack(int w, int [] itemsWeight, int [] itemsValue, int i) {
		 if (i == 0 || w == 0)
		       return 0;
		 if (itemsWeight[i-1] > w)
		       return knapSack(w, itemsWeight, itemsValue, i-1);
		 else
		       return Math.max(itemsValue[i-1] + knapSack(w-itemsWeight[i-1], itemsWeight, itemsValue, i-1),
		          knapSack(w, itemsWeight, itemsValue, i-1));
		 
	}
	
	 /**
     * Solves the Knapsack problem using Dynamic Programming (bottom-up).
     *
     * @param W CAPACIDAD MAXIMA DE LA MOCHILA
     * @param itemsWeight ARREGLO CON LOS TAMAÑOS DE LOS ELEMENTOS
     * @param itemsValue ARREGLO CON LOS VALORES DE LOS ELEMENTOS
     * @return RETORNA EL MAYOR VALOR 
     */
	public static int knapSackPD(int W, int [] itemsWeight, int [] itemsValue) {
		if (W <= 0 || itemsWeight.length ==0){
               return 0; 
          }
          // defino una matriz con cantidad de columnas = capacidad de la mochila
          // y cantidad de filas = cantidad de objetos 
          int[][] m = new int[W+1][itemsWeight.length+1];

          // primera fila = mochila vacía
          for (int j = 0; j <= itemsWeight.length; j++) {
               m[0][j] = 0;
          }
          // primera columna = capacidad cero
          for (int i = 0; i <= W; i++) {
               m[i][0] = 0;
          }


          for(int i=1;i<=W;i++){
               for(int j=1;j<=itemsWeight.length;j++){
                    if(itemsWeight[j-1] <=  i){
                         int aux = itemsValue[j-1] + m[i-itemsWeight[j-1]][j-1];
                         if(aux > m[i][j-1]){
                              m[i][j] = aux;
                         }else {
                              m[i][j] = m[i][j-1];
                         }
                    }else {
                         m[i][j] = m[i][j-1];
                    }
               }
          }
          return m[W][itemsWeight.length];
	}
	
	
	/**
     * Solves the Knapsack problem using memoization.
     *
     * @param W maximum capacity
     * @param itemsWeight array of item weights
     * @param itemsValue array of item values
     * @return the maximum achievable value
     */
	public static int knapSackMEMO(int W, int [] itemsWeight, int [] itemsValue) {
		if (W <= 0 || itemsWeight.length ==0){
               return 0; 
          }
          // defino una matriz con cantidad de columnas = capacidad de la mochila
          // y cantidad de filas = cantidad de objetos 
          int[][] m = new int[W+1][itemsWeight.length+1];

          // primera fila = mochila vacía
          for (int j = 0; j <= itemsWeight.length; j++) {
               m[0][j] = 0;
          }
          // primera columna = capacidad cero
          for (int i = 0; i <= W; i++) {
               m[i][0] = 0;
          }


          for(int i=1;i<=W;i++){
               for(int j=1;j<=itemsWeight.length;j++){
                    if(itemsWeight[j-1] <=  i){
                         int aux = itemsValue[j-1] + m[i-itemsWeight[j-1]][j-1];
                         if(aux > m[i][j-1]){
                              m[i][j] = aux;
                         }else {
                              m[i][j] = m[i][j-1];
                         }
                    }else {
                         m[i][j] = m[i][j-1];
                    }
               }
          }
          return m[W][itemsWeight.length];

	}

}

	
	
	
	
	
