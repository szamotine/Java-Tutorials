package Section22;

import Section22.Models.Pants;
import Section22.Models.Product;
import Section22.Models.Shirt;

public class Main {
    public static void main(String[] args){
        Product shirt = new Shirt(Shirt.Size.SMALL, 5.99, "blue", "Java Vuitton" );
        Product pants = new Pants(32, 24.99, "blue", "Java Klein");
    }
}

