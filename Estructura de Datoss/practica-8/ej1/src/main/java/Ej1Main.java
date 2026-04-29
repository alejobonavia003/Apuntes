
public class Ej1Main {
    public static void main (String[] args){
        long n = 36;
        long inicio = System.nanoTime();
        powTwo0(n);
        long fin = System.nanoTime();

        long duracion = fin - inicio;

        System.out.println("powTwo0("+n+") tardo : " + duracion);

        long inicio1 = System.nanoTime();
        powTwo1(n);
        long fin1 = System.nanoTime();
        long duracion1 = fin1 - inicio1;
        System.out.println("powTwo1("+n+") tardo : " + duracion1);
    }
/**
 * @post calcula potencias de dos.
 */
public static long powTwo0(long n) {
    if (n == 0)
        return 1;
    else
        return 2 * powTwo0(n - 1);
}

/**
 * @post calcula potencias de dos.
 */
public static long powTwo1(long n) {
    if (n == 0)
        return 1;
    else
        return powTwo1(n - 1) + powTwo1(n - 1);
}

}
