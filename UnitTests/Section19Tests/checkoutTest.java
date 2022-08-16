package Section19Tests;

import Section19.Model.Cart;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class checkoutTest {
    double [] prices = {1.1, 2.2, 3.3};
    Cart c = new Cart();

    @Test
    public void subtotalIsValid(){
        assertEquals(6.6, c.getSubtotal(prices),0);
    }

    @Test
    public void taxisValid(){
        assertEquals(0.86, c.getTax(6.6), 0);
    }

    @Test
    public void totalIsValid(){
        assertEquals(7.46, c.getTotal(6.6, 0.86),0);
    }
}
