package Section22;

import Section22.Models.Pants;
import Section22.Models.Shirt;

public class Main {
    public static void main(String[] args){
        Shirt shirt = new Shirt(Shirt.Size.SMALL, 5.99, "blue", "Java Vuitton" );
        Pants pants = new Pants(32, 24.99, "blue", "Java Klein");

        Shirt shirt2 = new Shirt(shirt);
        shirt2.setSize(Shirt.Size.MEDIUM);
        Pants pants2 = new Pants(pants);

        System.out.println(shirt);
        System.out.println(pants);

    }
}

