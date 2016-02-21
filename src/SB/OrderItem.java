package SB;


/**
 * Class for adding items to the basket.
 */
public class OrderItem {

    private String productName;
    private double latestPrice;
    private int quantity = 0;

    /**
     * OrderItem Constructor.
     * @param productName name of the product
     * @param latestPrice newest price
     * @param quantity specifies amount
     */
    public OrderItem(String productName, double latestPrice, int quantity) {
        this.productName = productName;
        this.latestPrice = latestPrice;
        this.quantity = quantity;
    }

    /**
     * @return returns the name of the product.
     */
    public String getProductName() {
        System.out.println(productName);
        return productName;
    }

    /**
     * @return returns the latest price of the product.
     */
    public double getLatestPrice() {
        return latestPrice;
    }

    /**
     * Sets the products latest price.
     * @param latestPrice price of product to be assigned.
     */
    public void setLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
    }

    /**
     * @return returns the total quantity of all products.
     */
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return returns the price of all orders.
     */
    public double getTotalOrder() {
        return getQuantity() * getLatestPrice();
    }

    /**
     * Adds a specific amount of items to the order with a price.
     * @param latestPrice price of the item.
     * @param quantity amount to be added.
     * @return returns the total quantity.
     */
    public int addItem(double latestPrice, int quantity){
        this.quantity += quantity;
        this.latestPrice += latestPrice;
        return this.quantity;
    }

    /**
     * Adds specific amount of items to the list.
     * @param quantity amount to be added.
     * @return returns the total quantity.
     */
    public int addItem(int quantity){
        this.quantity += quantity;
        return this.quantity;
    }

    /**
     * Adds one item to the list. Updates quantity by one.
     * @return returns the total quantity.
     */
    public int addItem(){
        quantity++;
        return quantity;
    }

    /**
     * Removes specified amount of items from the list.
     * @param quantity amount to be removed.
     * @return returns the total quantity.
     */
    public int removeItems(int quantity){
        if(quantity < 1){
            System.out.println("Incorrect quantity given");
        }else{
            this.quantity -= quantity;
        }
        return this.quantity;
    }

    /**
     * Removes one item from the list.
     * @return returns the total quantity.
     */
    public int removeItem(){
        if(quantity < 1){
            System.out.println("Can't remove from empty list");
        }else{
            quantity--;
        }
        return quantity;
    }


}
