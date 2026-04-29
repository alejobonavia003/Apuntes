import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ExperimentoQuickShort {

    public static void main(String[] args) {
        Random rand = new Random();

        // tamaños de los arreglos a probar
        int[] sizes = {1000, 5000, 10000, 20000, 50000, 100000};

        try (FileWriter writer = new FileWriter("resultados.csv")) {
            // cabecera del CSV
            writer.write("n,tiempo_ms\n");

            for (int n : sizes) {
                Integer[] arr = new Integer[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = rand.nextInt(1_000_000); // números aleatorios uniformes
                }

                long start = System.nanoTime();
                rQuickShort(arr, 0, arr.length - 1);
                long end = System.nanoTime();

                double ms = (end - start) / 1e6; // pasar a milisegundos

                // imprimir en consola
                System.out.printf("n = %d → tiempo = %.3f ms%n", n, ms);

                // guardar en archivo CSV
                writer.write(n + "," + ms + "\n");
            }

            System.out.println("\nResultados guardados en resultados.csv ✅");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    	public static <T extends Comparable<T>> int randomPartition(T[] a, int p, int r){
		Random random = new Random();
		int i = random.nextInt(r);
		T aux = a[r];
		a[r] = a[i];
		a[i] = aux;
		return partition(a, p, r);
	}


	private static <T extends Comparable<T>> int partition(T[] a, int p, int r) {
		T x = a[p];
		int i = p -1;
		int j = r + 1;
		while (true) {
        // bajar j hasta encontrar A[j] <= x
        do { j--; } while (a[j].compareTo(x) > 0);

        // subir i hasta encontrar A[i] >= x
        do { i++; } while (a[i].compareTo(x) < 0);
				if ( i<j){
					T aux = a[i];
					a[i] = a[j];
					a[j] = aux;
				} else {
					return j;
				}
			}
		
	}


	public static <T extends Comparable<T>> void rQuickShort(T[] a,int p,int r){
		if (p<r) {
			int q = randomPartition(a, p, r);
			rQuickShort(a, p, q - 1);
			rQuickShort(a, q+1, r);
		}
	}
}
