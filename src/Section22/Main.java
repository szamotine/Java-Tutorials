package Section22;

import Section22.Models.Pants;
import Section22.Models.Product;
import Section22.Models.Shirt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Product> product = new ArrayList<>();
    public static void main(String[] args){
        try{
            getData("products.txt");
            System.out.println("Products imported successfully");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Before sort: " + product);
        Collections.sort(product);
        System.out.println("After sort: " + product);
    }

    public static void getData(String filename) throws FileNotFoundException {
        String path = "src\\Section22\\" + filename;

        FileInputStream fis = new FileInputStream(path);
        Scanner scanFile = new Scanner(fis);
        while(scanFile.hasNextLine()){
            try{
                String line = scanFile.nextLine();
                String[] temp = line.split("\\s+");
                String productType = temp[0];
                String sizeOrWaist = temp[1];
                double price = Double.parseDouble(temp[2]);
                String color = temp[3];
                String brand = temp[4];

                if (productType.equalsIgnoreCase("shirt")){
                    Shirt.Size size = Shirt.Size.valueOf(sizeOrWaist);
                    product.add(new Shirt(size, price, color, brand));
                }
                if(productType.equalsIgnoreCase("pants")){
                    int waist = Integer.parseInt(sizeOrWaist);
                    product.add(new Pants(waist, price, color, brand));
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        scanFile.close();
    }
}

