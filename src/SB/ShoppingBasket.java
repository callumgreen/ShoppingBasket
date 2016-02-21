package SB;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Holds the products within the shopping basket.
 */
public class ShoppingBasket {

    private int numberOfItems;
    private int numberOfProducts;
    private ArrayList<OrderItem> order;

    /**
     * Creates empty shopping list.
     */
    public ShoppingBasket() {
        order = new ArrayList<>();
    }

    /**
     * Adds product to ArrayList, assuming quantity is one. Replaces product if it already exists.
     * @param name the name of the product being added.
     * @param latestPrice the price of the product being added.
     * */
    public void addProduct(String name, double latestPrice) {
        OrderItem match = null;

        doesProductExist:
        for(OrderItem item : order){
            if(item.getProductName().equals(name)){
                match = item;
                break doesProductExist;
            }
        }
        if(match == null) {addNewItem(name, latestPrice, 1);}

        else{match.setLatestPrice(latestPrice);}
    }
    /**
     * Adds product to arraylist. Replaces product if it already exists.
     * @param name the name of the product being added.
     * @param latestPrice the price of the product being added.
     * @param quantity the amount of items being added.
     * */
    public void addProduct(String name, double latestPrice, int quantity) {
        OrderItem match = null;

        doesProductExist:
        for(OrderItem item : order) {
            if (item.getProductName().equals(name)) {
                match = item;
                break doesProductExist;
            }
        }
        if (match == null) {
            addNewItem(name, latestPrice, quantity);
        } else {
            match.setQuantity(quantity + match.getQuantity());
            match.setLatestPrice(latestPrice);
            numberOfItems += match.getQuantity() - quantity;
        }
    }

    /**
     * Used in add method to stop code repetition.
     * @param name Name of product
     * @param latestPrice Price of product
     * @param quantity Amount to be added
     */
    private void addNewItem(String name, double latestPrice, int quantity){
        order.add(new OrderItem(name, latestPrice, quantity));
        numberOfProducts++;
        numberOfItems += quantity;
    }


    /**
     * Removes a certain amount of items from a project.
     * @param name the name of the product to remove from.
     * @param amountToRemove the amount of items to remove from the product.
     * @throws Exception thrown if product does not exist.
     */
    public void removeProduct(String name, int amountToRemove)throws Exception{
        int index = 0;
        boolean exists = false;

        doesProductExist:
        for (OrderItem item : order){
            if(item.getProductName().equals(name)){
                exists = true;
                index = order.indexOf(item);
                break doesProductExist;
            }
        }
        if(exists == true){
            order.get(index).removeItems(amountToRemove);
            numberOfItems -= amountToRemove;
        } else{throw new Exception("Product does not exist.");}
    }

    /**
     * Removes a whole product from the list.
     * @param name name of the product to be removed.
     * @throws Exception thrown if product does not exist.
     */
    public void removeProduct(String name)throws Exception{
        int index = 0;
        boolean exists = false;

        doesProductExist:
        for(OrderItem item : order){
            if(item.getProductName().equals(name)){
                exists = true;
                numberOfItems -= item.getQuantity();
                index = order.indexOf(item);
                break doesProductExist;
            }
        }
        if(exists == true){
            numberOfProducts--;
            order.remove(index);
        }else{
            throw new Exception("Item does not exist");
        }
    }

    /**
     * Empties the whole basket.
     */
    public void clearBasket() {
        numberOfItems = 0;
        numberOfProducts = 0;
        order.clear();
    }

    /**
     * Gets the array (basket).
     * @return returns the array.
     */
    public ArrayList<OrderItem> getOrder() {
        return order;
    }

    /**
     * Set method for the array list.
     * @param order type of OrderItem
     */
    public void setOrder(ArrayList<OrderItem> order) {
        this.order = order;
    }

    /**
     * Returns the number of products in the basket.
     */
    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    /**
     * Returns the total price of all items in the basket.
     * @return double containing total price.
     */
    public double getBasketTotal() {
        double total = 0;
        for (OrderItem i: order){
            total += i.getTotalOrder();
        }

        return total;
    }

    /**
     * Returns the number of items within the shopping basket.
     */
    public int getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * Returns the price of the name specified.
     * @param name name of the product.
     * @return returns price of product.
     */
    public double getCurrentPrice(String name)throws Exception{
        double price = 0;
        if(isProductInBasket(name)) {
            for (OrderItem i : order) {
                if (i.getProductName().equals(name)) {
                    price = i.getLatestPrice();
                }
            }
        }else{
            throw new Exception("Item not in basket.");
        }
        return price;
    }

    /**
     * Checks the basket to see if specified product exists.
     * @param name name of the product to be searched for.
     * @return returns true if product exists. False if not.
     */
    public boolean isProductInBasket(String name) {
        boolean answer = false;
        for (OrderItem i : order) {
            if (i.getProductName().equals(name)) {
                answer =  true;
            }
        }
        return answer;
    }

    /**
     * Implements toString method to print array contents.
     */
    public void printArray(){
        for (OrderItem ignored : order) toString();
    }

    /**
     * Saves contents of basket to a file.
     * @param file specifies file name to save to.
     * @throws IOException
     */
    public void saveBasket(String file) throws IOException{
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for(OrderItem i : order) {
                bf.write(i.getProductName() + " " + i.getQuantity() + " " + i.getLatestPrice() + "\n");
            }
            bf.write("Total price of order: " + "\n" + String.valueOf(getBasketTotal()));
        } catch (IOException e) {
            System.out.println("Error writing to file " + e);
        }finally{
            bf.close();
        }
    }

    /**
     * Overrides toString to return contents of array.
     * @return returns array items.
     */
    @Override
    public String toString() {
        String answer = "";
        for(OrderItem i : order) {
            answer += i.getProductName() + "       " + i.getQuantity()
                    + "      " + i.getLatestPrice() + "\n";
        }

        System.out.println(answer);
        return answer;
    }

}