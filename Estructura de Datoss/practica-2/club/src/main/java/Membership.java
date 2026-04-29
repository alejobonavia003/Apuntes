/**
 * Store details of a club membership.
 */
public class Membership
{
    // The name of the member.
    private String name;
    // The month in which the membership was taken out.
    private int month;
    // The year in which the membership was taken out.
    private int year;

    /**
     * @pre {@code 1 <= 'month' <= 12 && 'year' >= 1900}.
     * @post Create a Membership whith name, month and year information.
     */
    public Membership(String name, int month, int year)
    {
        this.name = name;
        this.month = month;
        this.year = year;
    }
    
    /**
     * @post Return the member's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @post Return the month in which the member joined.
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * @post Return the year in which the member joined.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @post Return a string representation of this membership.
     */
    public String toString()
    {
        return "Name: " + name +
               " joined in month " +
               month + " of " + year;
    }
    
    /**
     * @post Compares by equal object 'other' with this object.
     *
     */
    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        if ((other instanceof Membership)) {
            Membership elem = (Membership) other;
            return (elem == this ||
                     ((elem.getName()).equals(this.getName()) && 
                      elem.getMonth() == this.month &&
                      elem.getYear() == this.year
                     ) 
                );
        }    
        return false;
    }
}
