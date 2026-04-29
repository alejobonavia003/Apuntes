import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 */
public class StockManager
{
    private HashMap<Integer, Product> stock;
    /**
     * @post A StockManager is created.
     */
    public StockManager()
    {
        stock = new HashMap<>();
    }

    /**
     * @post item are added to stock.
     */
    public void addProduct(Product item)
    {
        stock.put(stock.size()+1, item);
        System.out.println("product created.");
    }


    /**
     * @pos return product if exist else null 
     */
    public Product findProductName (String name ){
        for (int key : stock.keySet()) {
            if(stock.get(key).getName().equals(name)){
                return stock.get(key);
            }
        }
        return null;
    }
    
    /**
     * @pre amount > 0 
     * @pos incremente amount al product id
     */
    public void delivery(int id, int amount)
    {
           if(stock.containsKey(id)){
            stock.get(id).increaseQuantity(amount);
            System.out.println("quantity is updated.");
           }else {
            System.out.println("quantity is not updated.");
           }
    }
    
    /**
     * @pos return product or null
     */
    public Product findProduct(int id)
    {
        
        return stock.get(id);
    }
    
    /**
     * @pos retuern quantity (p)
     */
    public int numberInStock(int id)
    {
        return stock.get(id).getQuantity();
    }

    /**
     * @pos print all product detail
     */
    public void printProductDetails()
    {

        Set <Integer> keys = stock.keySet();

        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()){
            int e = it.next();

            stock.get(e).toString();
        }
    }
    

    /**
     * @pre quantity > 0
     * @pos  
     */
    public void minStock (int quantity) {

        Set <Integer> keys = stock.keySet();

        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()){
            int e = it.next();
            if((stock.get(e).getQuantity()) <= quantity){
            stock.get(e).toString();
            }
        }
    }

}
