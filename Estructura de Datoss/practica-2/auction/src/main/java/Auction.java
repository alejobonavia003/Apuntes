import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que modela una subasta
 */
public class Auction
{
    private ArrayList<Lot> lots;
    private HashMap<Integer, Lot> lots2;
    private Integer id;

    /**
     * @post Una subasta es creada.
     */
    public Auction()
    {
        lots = new ArrayList<>();
        lots2 = new HashMap<>();
        id = 0;
        //lots2.put("1", new Lot(1, "Lote 1"));
    }

    /**
     * @post Un nuevo lote es agregado a la subasta.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(lots.size()+1, description));
        lots2.put(id+1, new Lot(id+1, description));
    }

    /**
     * @post Todos los lotes son mostrados.
     */
    public void showLots()
    {
        lots2.keySet().forEach(key -> {
            System.out.println("Lote numero" + key + ": " + lots2.get(key).getDescription());
        });
        /*
        for (Lot lot : lots)
            System.out.println(lot);
    
        */}
    
    /**
     * @pre {@code 0 < lotNNumber <= lots.size()}.
     * @post Una oferta por el lote es realizada. 
     */
    public boolean makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        Bid bid = new Bid(bidder, value);
        return selectedLot.bidFor(bid);
    }

    /**
     * @pre {@code 0 < lotNumber <= lots.size()}.
     * @post El lote con el número deseado es devuelto.
     */
    public Lot getLot(int lotNumber)
    {
        return lots2.get(lotNumber-1);
    }
    
    /**
     * @post La subasta está cerrada y los lotes vendidos son mostrados por pantalla.
     */
    public void close() {
        //TODO: implementar este método
    }
    
    /**
     * @pre {@code 0 < lotNumber <= lots.size()}.
     * @post La oferta ganadora para el lote 'lotNumber' es retornada.
     */
    public Bid getHighestBid(int lotNumber) {
        return null; //TODO: implementar este método
    }
    
    /**
     * @post Una lista con todos los lotes sin vender es devuelta.
     */
    public ArrayList<Lot> getUnsold() {
        return null; //TODO: implementar este método
    }
    
    /**
     * @pre {@code 0 < lotNumber <= lots.size()}.
     * @post El lote con el número 'lotNumber' ha sido eliminado, este lote es retornado.
     */
    public Lot removeLot(int lotNumber) {
        return null; //TODO: implementar este método
    }
}
