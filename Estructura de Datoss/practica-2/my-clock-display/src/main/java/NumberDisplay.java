
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be {@code 60}, 
 * resulting in display values from {@code  0} to {@code 59}. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 */
public class NumberDisplay
{
    private int limit;
    private int value;

    /**
     * @pre 'rollOverLimit' &gt; 0
     * @post Constructs a NumberDisplay that starts at 0
     * and resets at the given 'rollOverLimit'.
     */
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
    }

    /**
     * @post Return the current value.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * @post Return the display value, that is, the current value 
     * as a two-digit String.
     */
    public String getDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }

    /**
     * @pre {@code 'replacementValue' <=  0 and 'replacementValue' < 'limit'}.
     * @post Set the value of the display to the new specified value.
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    /**
     * @post Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    public void increment()
    {
        value = (value + 1) % limit;
    }
}
