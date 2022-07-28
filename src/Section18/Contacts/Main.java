package Section18.Contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static ContactManager cm = new ContactManager();

    public static void main(String[] args){

        try{
            String fileName = "contacts.txt";
            loadContacts(fileName);
            System.out.println("\nContacts Loaded\n\n");
            manageContacts();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {

            cm.printContacts();
        }
        System.out.println("Program complete");





        /*
        String[] names = {"Alan Turning", "Bob Hope", "Justin Timberlake" };
        String[] dobs = {"07/24/1989","07/24/1990","07/24/1999"};
        String[] pNs = {"6139874561","111111111","222222222"};

        String name = "Wayne Gretzky";
        String dateBirth = "07/24/1992";
        String phoneNumber = "3333333333";

        try {
            for (int i = 0; i < names.length; i++) {
                cm.addContact(new Contact(names[i], dobs[i], pNs[i]));
            }

            cm.printContacts();
            cm.removeContact("John Walker");
            cm.removeContact(names[0]);
            cm.removeContact(names[1]);
            cm.removeContact(names[2]);

            Contact wayne = new Contact(name,dateBirth,phoneNumber);
            cm.addContact(wayne);
            cm.printContacts();
           //System.out.println(contact.toString());
        }catch (ParseException e){
            System.out.println("ParseException error occurred : " + e.getMessage());
        }finally{
            System.out.println("Process complete");
        }
         */

    }

    /**
     * Name: manageContacts
     * Inside the function:
     *   - 1. Starts a new instance of Scanner;
     *   - 2. In an infinite loop, the user can choose to a) add or b) remove a contact c) exit.
     *   -        case a: ask for the name, phone number and birthDate.
     *   -        case b: ask who they'd like to remove.
     *   -        case c: break the loop.
     *   - 3. call close() from the Scanner object.
     */
    public static void manageContacts(){
        
        Scanner scan = new Scanner(System.in);
        String input;
        while(true){
            System.out.println("Would you like to \n\ta) add another contact \n\tb)remove a contact \n\tc)exit");
            input = scan.nextLine();
            if(input.equals("a")){

                try {
                    Contact c = new Contact();
                    System.out.println("\nPlease enter the name");
                    c.setName(scan.nextLine());
                    System.out.println("\nPlease enter the phone number");
                    c.setPhoneNumber(scan.nextLine());
                    System.out.println("\nPlease enter the birth Date");
                    c.setBirthDate(scan.nextLine());
                    cm.addContact(c);
                    //TODO Part 7 Task 1: blank name, phone number -> remove crash
                } catch (ParseException e){
                    System.out.println(e.getMessage());
                }finally{
                    System.out.println("\nUpdated Contact list: \n");
                    cm.printContacts();
                }

            } else if (input.equals("b")) {
                System.out.println("\nPlease enter the name of the contact you would like to remove");
                cm.removeContact(scan.nextLine());
                cm.printContacts();
            }else{
                System.out.println("Exiting");
                break;
            }
        }
        scan.close();
    }

    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   - 1. loads contacts from <fileName>.txt;
     *   - 2. manager adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     */
    public static void loadContacts(String fileName) throws FileNotFoundException {
        String path = "C:\\Users\\s_zam\\Desktop\\Programming\\Bootcamp\\src\\Section18\\Contacts\\" + fileName;
        //String path = ".\\Section18\\Contacts\\" + fileName;
        FileInputStream fis = new FileInputStream(path);
        Scanner scanFile = new Scanner(fis);
        while (scanFile.hasNextLine()){
            try {
                String name = scanFile.next() + " " + scanFile.next();
                String number = scanFile.next();
                String date = scanFile.next();
                //System.out.println("name: " +  name + "number: " + number + "date: " + date);
                //Contact contact = new Contact(scanFile.next(), scanFile.next(), scanFile.next());
                Contact contact = new Contact(name, date, number);
                cm.addContact(contact);
            }catch (ParseException e){
                System.out.println(e.getMessage());
            }
        }
        scanFile.close();
    }
}
