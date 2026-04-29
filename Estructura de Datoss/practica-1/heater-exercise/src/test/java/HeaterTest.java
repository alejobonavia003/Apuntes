

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HeaterTest
{
    @Test
    public void testConstructor()
    {
        Heater heater1 = new Heater(0, 20);
        assertEquals(15.0f, heater1.showTemperature());
    }

    @Test
    public void testWarmerMax()
    {
        Heater heater2 = new Heater(0, 20);
        heater2.warmer();
        heater2.warmer();
        assertEquals(20, heater2.showTemperature());
    }

    @Test
    public void testCoolerMin()
    {
        Heater heater3 = new Heater(0, 20);
        heater3.cooler();
        heater3.cooler();
        heater3.cooler();
        assertEquals(0, heater3.showTemperature());
    }

}


