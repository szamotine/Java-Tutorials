package Section19;

import Section19.Model.Cart;
import Section19.Model.Item;
import Section19.Model.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Store s = new Store();
    static Cart c = new Cart();
    public static void main(String[] args){


        String file = "products.txt";
        try{
            loadItems(file);
            manageItems();
        }catch(FileNotFoundException e){
            System.out.println("Error: File not Found");
        }finally {
            System.out.println(s);
            System.out.println(c);
        }


    }

    /**
     * Name: manageItems <------
     * Inside the function:
     *   - 1. Starts a new instance of Scanner;
     *   - 2. Creates an infinite loop:
     *   -        The user can choose to a) add or b) remove c) checkout.
     *   -          case a: asks for the aisle and item number. Then, adds item to cart.
     *   -          case b: asks for the name. Then, removes item from cart.
     *   -          case c: prints the receipt and closes Scanner.
     *   -        Prints the updated shopping cart.
     */
    static void manageItems(){

        Scanner scan = new Scanner(System.in);
        int aisle;
        int itemNumber;
        while (true){

            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(s);
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String input = scan.nextLine();
            switch (input){
                case "a":
                    System.out.println("\nChoose an aisle number between: 1 – 7: ");
                    if(scan.hasNextInt()){
                        aisle = scan.nextInt()-1;
                        scan.nextLine();
                    }else{
                        System.out.println("Must enter number between 1 and 7");
                        scan.nextLine();
                        break;
                    }
                    System.out.println("Choose an item number between: 1 – 3: ");
                    if(scan.hasNextInt()){
                        itemNumber = scan.nextInt()-1;
                        scan.nextLine();
                    }else{
                        System.out.println("Must enter number between 1 and 3");
                        scan.nextLine();
                        break;
                    }
                    Item i = s.getItems(aisle,itemNumber);
                    c.add(i);

                    break;
                case "b":
                    if(c.cartEmpty()){
                        System.out.println("Cannot checkout, cart is empty");
                    }else{
                        System.out.println("Enter the name of the item you'd like to remove: ");
                        String name = scan.nextLine();
                        i = c.findByName(name);
                        c.remove(i);
                    }
                    break;
                case "c":
                    if(c.cartEmpty()){
                        System.out.println("Cannot checkout, cart is empty");
                    }else{
                        System.out.println(c.checkOut());
                    }
                    break;
                case "d":
                    System.out.println(c);
                    break;
                default:
                    scan.close();
                    System.out.println("Exiting Program");
                    System.exit(99);

            }



        }
    }

    /**
     * Name: loadItems
     * @param filename : name of file that contains items
     * @throws FileNotFoundException
     * Inside the function:
     *  *   1. loads items from <fileName>.
     *  *      - while loop runs through every line in <fileName>
     *  *      - scan.nextLine() picks up the entire line.
     *  *      - splits each String using the ";" separator.
     *  *      - splits both fields in each String using the "=" separator.
     *  *      - Parse each price into a Double.
     *  *   2. adds all items to the store object's items field.
     */
    static void loadItems(String filename) throws FileNotFoundException{
        String path = "C:\\Users\\s_zam\\Desktop\\Programming\\Bootcamp\\src\\Section19\\Model\\" + filename;

        FileInputStream fis = new FileInputStream(path);
        Scanner scanFile = new Scanner(fis);
        int row = 0;
        while(scanFile.hasNextLine()){
            try {
                String line = scanFile.nextLine();
                String[] product = line.split("[;//=]");
                int index=0;

                for (int i = 0; i < 3; i++) {
                    s.setItems(row,i,new Item(product[index++], Double.parseDouble(product[index++])) );
                }
                row++;

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}


