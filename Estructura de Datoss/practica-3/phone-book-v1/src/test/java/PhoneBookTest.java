import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * The test class PhoneBookTest.
 */
public class PhoneBookTest
{
    @Test
    public void testHighestBid()
    {
        PhoneBook listado = new PhoneBook();
        listado.addEntry("alejo", "3385443705");
        assertFalse( listado.addEntry("alejo", "3385443705"));
    }

}