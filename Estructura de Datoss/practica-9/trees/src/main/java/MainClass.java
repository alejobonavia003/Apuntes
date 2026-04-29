//import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainClass {
    public static void main (String[] args){
        final int[] arregloRandom = {0,8,8,9,3,7,6};
        boolean esHeapMax = true;

        System.out.println("-------------------------------------------------------------------");
        System.out.println("ejercicio de HEAP TRUE");
        for(int i = 1; i<arregloRandom.length;i++){
            if(i*2 < arregloRandom.length){
                if(arregloRandom[i*2] > arregloRandom[i]){
                    esHeapMax = false;
                }
            }
            if(i*2+1 < arregloRandom.length){
                if(arregloRandom[i*2+1] > arregloRandom[i]){
                    esHeapMax = false;
                }
        }
        }
        System.out.println("es heap : " + esHeapMax);
        System.out.println("-------------------------------------------------------------------");


        System.out.println("-------------------------------------------------------------------");
        System.out.println("ejercicio de HEAP¨SHORT");
        HeapShort test = new HeapShort();
        test.createHeap(arregloRandom);
        System.out.println("-------------------------------------------------------------------");
        test.vaciarHeap();
        
    }
}
