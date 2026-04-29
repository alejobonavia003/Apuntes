package main;
import java.util.HashMap;

public class Puntos {
    
    private class point{
        private float x;
        private float y;

        public void cpoint(float x, float y){
            this.x = x;
            this.y = y;
        }

        public float getX(){
            return x;
        }
        public float getY(){
            return y;
        }
    }

    private point[] puntos;

    public void argegarPuntos(Float x, Float y, int posicion){
        puntos[posicion].cpoint(x, y);
    }

    public void puntosMasCercanos(){
        Float dmin = Float.MAX_VALUE;
        int index1=0;
        int index2=0;
        Float d=(float) 0;

        for(int i = 1; i<puntos.length; i++ ){
            for (int j = i+1; i<= puntos.length;j++){
                d = (float) Math.sqrt( Math.pow((puntos[i].getX() - puntos[j].getX()), 2) + Math.pow((puntos[i].getY() - puntos[j].getY()), 2));
                if (d < dmin){
                    dmin = d;
                    index1 = i;
                    index2 = j;
                } 
            }
        }
        System.out.println("los puntos mas cercanos son: ("+puntos[index1].getX()+","+puntos[index1].getY()+") y ("+puntos[index2].getX()+", "+puntos[index2].getY()+")");
        System.out.println("Con una distancia de " + d);
    }
}
