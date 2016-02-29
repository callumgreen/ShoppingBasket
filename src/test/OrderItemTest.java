import org.junit.Before;
import org.junit.Test;
import SB.OrderItem;

import static org.junit.Assert.*;

/**
 * Created by callumgreen on 02/12/2015.
 */
public class OrderItemTest {

    OrderItem banana;
    OrderItem peach;
    OrderItem orange;

    @Before
    public void setUp(){
        banana = new OrderItem("banana", 5, 2);
        peach= new OrderItem("peach", 1, 10);
        orange = new OrderItem("orange", 2.5, 3);
    }

    /**
     * Getting the product name of each object.
     */
    @Test
    public void testGetProductName(){
        assertEquals("banana", banana.getProductName());
        assertEquals("peach", peach.getProductName());
        assertEquals("orange", orange.getProductName());
    }

    /**
     * Getting the latest price of each object.
     */
    @Test
    public void testGetLatestPrice(){
        assertEquals(5, banana.getLatestPrice(), 0.01);
        assertEquals(1, peach.getLatestPrice(), 0.01);
        assertEquals(2.5, orange.getLatestPrice(), 0.01);
    }

    /**
     * Setting the current price of each object.
     */
    @Test
    public void testSetLatestPrice(){
        banana.setLatestPrice(5);
        peach.setLatestPrice(5);
        orange.setLatestPrice(5);
        assertEquals(5, banana.getLatestPrice(), 0.01);
        assertEquals(5, peach.getLatestPrice(), 0.01);
        assertEquals(5, orange.getLatestPrice(), 0.01);
    }

    /**
     * Getting quantity of each object.
     */
    @Test
    public void testGetQuantity(){
        assertEquals(2, banana.getQuantity());
        assertEquals(10, peach.getQuantity());
        assertEquals(3, orange.getQuantity());
    }

    /**
     * Times the quantity by the latest price. Gets the total price of order.
     */
    @Test
    public void testGetTotalOrder(){
        assertEquals(10, banana.getTotalOrder(), 0.01);
        assertEquals(10, peach.getTotalOrder(), 0.01);
        assertEquals(7.5, orange.getTotalOrder(), 0.01);
    }

    /**
     * Adds an item specifying quantity and price.
     */
    @Test
    public void testAddItemWithPrice(){
        banana.addItem(4, 2);
        assertEquals(9, banana.getLatestPrice(), 0.1);
        assertEquals(4, banana.getQuantity());
    }

    /**
     * Checks quantity then adds item using addItem, specifying quantity.
     */
    @Test
    public void testAddItems(){
        assertEquals(2, banana.getQuantity());
        banana.addItem(4);
        assertEquals(6, banana.getQuantity());
        banana.addItem(2);
        assertEquals(8, banana.getQuantity());
    }

    /**
     * Adds one item using addItem.
     */
    @Test
    public void testAddItem(){
        banana.addItem();
        assertEquals(3, banana.getQuantity());
        banana.addItem();
        assertEquals(4, banana.getQuantity());
    }

    /**
     * Removes whole item specifying the whole quantity.
     */
    @Test
    public void testRemoveWholeItem(){
        peach.removeItems(2);
        assertEquals(8, peach.getQuantity());
        peach.removeItems(8);
        assertEquals(0, peach.getQuantity());
    }

    /**
     * Removes individual item using removeItem method.
     */
    @Test
    public void testRemoveItem(){
        assertEquals(10, peach.getQuantity());
        peach.removeItem();
        peach.removeItem();
        assertEquals(8, peach.getQuantity());
    }
}