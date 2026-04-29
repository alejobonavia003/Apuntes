/**
 * Model some details of a product sold by a company.
 */
public class Product
{
    private int id;
 
    private String name;
 
    private int quantity;

    /**
     * @post A product is created.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @post The ID of the product is returned.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @post return product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @post The quantity of the product in stock is returned.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @post A string containing the product's information is returned.
     */
    public String toString()
    {
        return id + ": " +
               name +
               " stock level: " + quantity;
    }

    /**
     * @pre amount > 0
     * @post quantity is updated with quantity + amount value.
     */
    public void increaseQuantity(int amount)
    {
        
      quantity += amount;
        
    }

    /**
     * @pre getQuantity() > 0
     * @post Sell one of these products, i.e., quantity is decreased by 1. 
     */
    public void sellOne()
    {
        if(quantity > 0) {
            quantity--;
        }
    }
}
