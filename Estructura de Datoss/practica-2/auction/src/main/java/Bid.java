/**
 * Clase que modela una oferta en una subasta. 
 */
public class Bid
{
    private final Person bidder;
    private final long value;

    /**
     * @pre {@code value > 0 && bidder != null}.
     * @post Una oferta es creada.
     */
    public Bid(Person bidder, long value)
    {
        this.bidder = bidder;
        this.value = value;
    }

    /**
     * @post La persona que realizó la oferta es devuelta.
     */
    public Person getBidder()
    {
        return bidder;
    }

    /**
     * @post El valor de la oferta es devuelto.
     */
    public long getValue()
    {
        return value;
    }
}
