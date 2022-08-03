package Section19;

import Section19.Model.Cart;
import Section19.Model.Item;

public class Main {
    public static void main(String[] args){
        Item i1 = new Item("Celery", 0.99);
        Item i2 = new Item("Spinach", 0.95);
        Item i3 = new Item("Coriander", 1.29);

        Cart c = new Cart();
        c.add(i1);
        c.add(i2);
        c.add(i3);
        c.add(i1);
        System.out.println(c.toString());
    }



}
