package sample;

import java.io.IOException;

/**
 * Created by callumgreen on 30/11/2015.
 */
public class Application {

    public static void main(String[] args)throws IOException{

        ShoppingBasket sb = new ShoppingBasket();

        sb.addProduct("Oranges", 2.20, 2);

        sb.saveBasket("Receipt");
        sb.printArray();

    }
}
