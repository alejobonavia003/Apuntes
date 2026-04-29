

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClockDisplayTest
{

    @Test
    public void testGetTime()
    {
        ClockDisplayAmPm clock1 = new ClockDisplayAmPm(12,59,"AM");
        clock1.timeTick();
        assertEquals(clock1.getTime(),"01:00PM");
        clock1.setTime(11, 59, "PM");
        clock1.timeTick();
        assertEquals(clock1.getTime(),"00:00AM");
    }


    @Test
    public void testLimitSeconds()
    {
        ClockDisplay clock = new ClockDisplay();
        clock.setTime(23,59,59, 9, 9);
        clock.timeTick();
        assertEquals(clock.getTime(),"00:00:00:00:00");

    }

    @Test 
    public void testGetTimeNegative(){
        ClockDisplay clock = new ClockDisplay();
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> clock.setTime(-1, -1, -1, -1, -1)
        );
        assertEquals("Invalid time", ex.getMessage());
    }

    
    
}


