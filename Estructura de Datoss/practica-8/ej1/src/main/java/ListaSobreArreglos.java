import java.util.NoSuchElementException;

public class ListaSobreArreglos {
    private static final int MAXLIST = 100;
    private int item[];
    private int numItems;


    public ListaSobreArreglos(){
        numItems = 0;
    }

    public void llenar(){
        for (int i = 0; i<15; i++){
            item[i] = i;
            numItems++;
        }
    }

    public Integer buscar(int x){


        if(numItems>0 && item[numItems-1] == x){
            return numItems -1;
        }


        int low = 0; //  O(1)
        int high = numItems -2; //  O(1)
        // sacamos el ultimo elemento por que ya lo comprobamos por eso - 2
        while (low <= high){ //  O(log n)
            int mid = (low + high) >>> 1; //  O(1)
            if(item[mid] == x){ //  O(1)
                return mid; //  O(1)
            } else if(item[mid] < x){ //  O(1)
                low = mid +1; //  O(1)
            } else { //  O(1)
                high = mid -1; //  O(1)
            }
        }
        throw new NoSuchElementException("No existe el elemento.");
    }

    public void insertar(int newItem){
        Boolean from = false;
        int aux = 0;

        for(int i = 0; i<numItems-1; i++){ //  O(n)
            if(from){
                int aux2 = item[i];
                item[i] = aux;
                aux = aux2;
            }
            if(newItem <= item[i] && !from){
                from = true;
                aux = item[i];
                item[i] = newItem;
            }
        }
        item[numItems] = aux;
        numItems++;
    } 


    public void eliminar(int elimItem){
        Boolean from = false;
        for(int i = 0; i<numItems-1; i++){ //  O(n)
            
            if(elimItem == item[i]){
                from = true;
            }
            if (from && i < numItems -1){
                item[i] = item[i+1];
            }
        }
        numItems -= 1;
    } 
} 
