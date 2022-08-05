package Section19;

import Section19.Model.Cart;
import Section19.Model.Item;
import Section19.Model.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Store s = new Store();
    public static void main(String[] args){

        Cart c = new Cart();
        String file = "products.txt";
        try{
            loadItems(file);
            manageItems();
        }catch(FileNotFoundException e){
            System.out.println("Error: File not Found");
        }finally {
            System.out.println(s.toString());
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
        //TODO Shopping Cart part 8 task 4 case a
        Scanner scan = new Scanner(System.in);
        while (true){
            clearScreen();
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(s);
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String input = scan.nextLine();
            switch (input){
                case "a": System.out.println("Add"); break;
                case "b": System.out.println("Remove"); break;
                case "c": System.out.println("Checkout"); break;

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
        //ArrayList<Item> items = new ArrayList<>();
        int row = 0;
        while(scanFile.hasNextLine()){
            try {
                String line = scanFile.nextLine();
                String[] product = line.split("[;//=]");

                int index=0;

//                for (int i = 0; i < product.length; i+=2) {
//                    items.add(new Item(product[i], Double.parseDouble(product[i+1]) ));
//                }

                for (int i = 0; i < 3; i++) {
                    s.setItems(row,i,new Item(product[index++], Double.parseDouble(product[index++])) );
                }
                row++;

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        //System.out.println(s.toString());

    }

    static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


