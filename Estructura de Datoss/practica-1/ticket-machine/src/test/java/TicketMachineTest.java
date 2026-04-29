

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicketMachineTest
{
    @Test
    public void testConstructorValidPrice()
    {
        TicketMachine ticketMa1 = new TicketMachine(10);
        assertEquals(10, ticketMa1.getPrice());
    }

    @Test
    public void testPrintTicketOk()
    {
        TicketMachine machine = new TicketMachine(10);
        machine.insertMoney(10);
        boolean res = machine.printTicket();
        assertTrue(res);
        assertEquals(0, machine.getBalance());
    }
    
    @Test
    public void testPrintTicketFails()
    {
        TicketMachine machine = new TicketMachine(10);
        boolean res = machine.printTicket();
        assertFalse(res);
        assertEquals(0, machine.getBalance());
    }
    
}


