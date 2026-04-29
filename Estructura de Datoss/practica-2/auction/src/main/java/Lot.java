/**
 * Representa un lote de artículos en una subasta.
 */
public class Lot
{

    private String description;
    private Bid highestBid;
    private final int number;

    /**
    * @post Un lote es construido.
    */
    public Lot(int number, String description)
    {
        this.number = number;
        this.description = description;
        this.highestBid = null;
    }

    /**
     * @post Si el valor de 'bid' es mayor al de highest bid, actualiza 'highestBid' y devuelve true, de otra forma devuelve false.
     */
    public boolean bidFor(Bid bid)
    {
        if(highestBid == null || 
            bid.getValue() > highestBid.getValue()) {
                highestBid = bid;
                return true;
        }
        return false;
    }
    
 
    /**
    * @post Un string con la información del lote es retornado. 
    */
    public String toString()
    {
        String details = "Lot " + number + ": " + description;
        if(highestBid != null) {
            details += "    Bid: " + 
                       highestBid.getValue() +
                       "    by: " +
                       highestBid.getBidder();
        }
        else {
            details += "    (No bid)";
        }
        return details;
    }
    
    /**
     * @post El número de lote es devuelto.
     */
    public int getNumber() {
        return number;
    }

    /**
     * @post Devuelve la descripción del lote.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @post Devuelve la oferta más alta realizada.
     */
    public Bid getHighestBid()
    {
        return highestBid;
    }
}
