import org.junit.Before;
import org.junit.Test;
import SB.ShoppingBasket;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by callumgreen on 02/12/2015.
 */
public class ShoppingBasketTest {

    ShoppingBasket sb = new ShoppingBasket();

    @Before
    public void setUp() {
        sb.addProduct("orange", 5.0, 1);
        sb.addProduct("peach", 5.0, 2);
    }

    @Test
    public void testAddProductQuantity() {
        sb.addProduct("Apple", 5);
        assertEquals(3, sb.getNumberOfProducts());
        sb.addProduct("Grapes", 2);
        assertEquals(4, sb.getNumberOfProducts());
    }

    @Test
    public void testAddProductQuantityAndPrice() {
        sb.addProduct("Apple", 5.0, 2);
        assertEquals(3, sb.getNumberOfProducts());
        assertEquals(5, sb.getNumberOfItems());
        sb.addProduct("pineapple", 3.0, 3);
        assertEquals(4, sb.getNumberOfProducts());
        assertEquals(8, sb.getNumberOfItems());

    }

    /**
     * Removes an item from a product.
     * Tests for product and item amount.
     */
    @Test
    public void testRemoveProductItem() throws Exception{
        sb.removeProduct("peach", 1);
        assertEquals(2, sb.getNumberOfProducts());
        assertEquals(2, sb.getNumberOfItems());
    }

    /**
     * Removes a whole product by specifying whole quantity of item.
     * Tests that product and item amount has decreased.
     */
    @Test
    public void testRemoveAllItems()throws Exception{
        sb.removeProduct("peach", 2);
        assertEquals(1, sb.getNumberOfProducts());
        assertEquals(1, sb.getNumberOfItems());
    }


    @Test
    public void testRemoveWholeProduct()throws Exception{
        sb.removeProduct("orange");
        assertEquals(1, sb.getNumberOfProducts());
        assertEquals(2, sb.getNumberOfItems());
    }

    @Test
    public void testClearBasket() {
        sb.clearBasket();
        assertEquals(0, sb.getNumberOfProducts());
        assertEquals(0, sb.getNumberOfItems());
    }


    @Test
    public void testGetCurrentPrice()throws Exception{
        assertEquals(5, sb.getCurrentPrice("orange"), 0.1);
        assertEquals(5, sb.getCurrentPrice("peach"), 0.1);
    }

    @Test
    public void testGetNumberOfProducts() {
        assertEquals(2, sb.getNumberOfProducts());
        sb.addProduct("test", 4);
        assertEquals(3, sb.getNumberOfProducts());
    }

    @Test
    public void testGetBasketTotal(){
        assertEquals(15, sb.getBasketTotal(), 0.1);
    }

    @Test
    public void testGetNumberOfItems(){
        assertEquals(3, sb.getNumberOfItems());
        sb.addProduct("test", 2.0, 4);
        assertEquals(7, sb.getNumberOfItems());
    }

    @Test
    public void testIsProductInBasketTrue(){
        assertTrue(sb.isProductInBasket("orange"));
    }

    @Test
    public void testIsProductInBasketFalse(){
        assertFalse(sb.isProductInBasket("test"));
    }

    @Test
    public void testSaveBasketFileExists(){
        File file = new File("Receipt");
        assertTrue(file.exists());
    }

    @Test
    public void testSaveBasketFileIsNotEmpty(){
        File file = new File("Receipt");
        assertTrue(file.length() > 0);
    }


}