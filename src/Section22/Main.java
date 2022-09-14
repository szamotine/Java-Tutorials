package Section22;

import Section22.Models.Pants;
import Section22.Models.Shirt;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        Shirt shirt = new Shirt(Shirt.Size.SMALL, 5.99, "blue", "Java Vuitton" );
        Pants pants = new Pants(32, 24.99, "blue", "Java Klein");

        Shirt shirt2 = new Shirt(shirt);
        shirt2.setSize(Shirt.Size.MEDIUM);
        Pants pants2 = new Pants(pants);
        pants2.setBrand("Jingles");
        Pants pants3 = new Pants(34, 104.99, "red", "Jangler");
        Pants pants4 = new Pants(pants2);
        pants4.setBrand("Googly");

        ArrayList<Pants> PantsList = new ArrayList<Pants>();
        PantsList.add(pants);
        PantsList.add(pants2);
        PantsList.add(pants3);
        PantsList.add(pants4);

        System.out.println(shirt);
        System.out.println(pants);
        System.out.println(pants2.getPrice());
        pants2.discount();
        System.out.println(pants2.getPrice());
        System.out.println("CompareTo(): " + pants.compareTo(pants2));
        System.out.println("CompareTo(): " + pants2.compareTo(pants));


        System.out.println("Before Sorting:\n" + PantsList);
        Collections.sort(PantsList);
        System.out.println("After Sorting:\n" + PantsList);


    }
}

