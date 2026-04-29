package main;

public class Main {

    public static void main(final String[] args) {




        Puntos p = new Puntos();

        p.argegarPuntos(1f, 1f, 0);
        p.argegarPuntos(4f, 1f, 1);
        p.argegarPuntos(2f, 4f, 2);
        p.argegarPuntos(5f, 3f, 3);
        p.argegarPuntos(5f, 6f, 4);

        p.puntosMasCercanos() ;


    }
        
}
