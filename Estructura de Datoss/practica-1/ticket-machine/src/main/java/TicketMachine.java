/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * @pre 'cost' > 0.
     * @post Create a machine that issues tickets 
     *   with a price of 'cost'.
    */
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }

        /**
     * @post Create a machine that issues tickets 
     *   with a price of 'cost'.
    */
    public TicketMachine()
    {
        price = 1000;
        balance = 0;
        total = 0;
    }

    /**
     * @post Returns the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * @post Returns the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * @pre 'amount' > 0.
     * @post Receives an amount of money from a customer.
     */
    public void insertMoney(int amount)
    {
        balance = balance + amount;
    }

    public void empty(){
        total = 0;
    }
    

    /**
     * @post If enough money has been inserted, print a ticket to the console
     * and reduce the current balance by the ticket price. Returns 'true' if 
     * successful; otherwise, it does nothing and returns 'false'.
     */
    public boolean printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
            return true;
        }
        else {
            return false;  
        }
    }

    /**
     * @post Returns the money in the balance and clears 
     * the balance.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }


    /**
     * @post Returns price 
     */
    void showPrice(){
        System.out.println("The price of a ticket is "+ price +" cents.");
    }
}
