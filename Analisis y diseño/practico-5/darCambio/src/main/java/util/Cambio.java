package util;

import java.util.ArrayList;

/**
 * Problema de dar cambio
 *
 * @author Alejo Bonavia
 *
 */

public final class Cambio {
   
  public static void main(String[] args){
    int[] monedas = {1,5,7};
    ArrayList<Integer> result = cambio(monedas, 25);
    System.out.print("su vuelto es: ");
    for (int i=0;i<result.size();i++){
      System.out.print(result.get(i) +" ");
    }
    System.out.println("\n");
  }  

  public static ArrayList<Integer> cambio(int[] monedas, int total){
    ArrayList<Integer> resultado = new ArrayList<>();

    while(total > 0){
      int k = monedas.length-1; //3
      while(monedas[k] >= total && k >0){
        k--;
      }
      resultado.add(monedas[k]);
      total -= monedas[k];
    }
    return resultado;
  }
}   
