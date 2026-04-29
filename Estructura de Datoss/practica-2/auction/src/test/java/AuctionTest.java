

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class AuctionTest.
 */
public class AuctionTest
{
    @Test
    public void testHighestBid()
    {
        Auction auction1 = new Auction();
        auction1.enterLot("3 autos");
        Person person1 = new Person("Simeone");
        Person person2 = new Person("Fernandez");
        auction1.makeABid(1, person1, 10);
        auction1.makeABid(1, person2, 5);
        auction1.close();
        assertTrue(auction1.getHighestBid(1).getBidder().equals(person1));
    }
    
    @Test
    public void testUnsoldElements()
    {
        Auction auction1 = new Auction();
        auction1.enterLot("ironía");
        auction1.enterLot("3 autos");
        auction1.enterLot("santo grial");
        Person person1 = new Person("Indiana");
        auction1.makeABid(2, person1, 10);
        ArrayList<Lot> unsold = auction1.getUnsold();
        System.out.println(unsold);
        assertTrue(unsold.contains(auction1.getLot(1)));
        assertFalse(unsold.contains(auction1.getLot(2)));
        assertTrue(unsold.contains(auction1.getLot(3)));
    }
}
