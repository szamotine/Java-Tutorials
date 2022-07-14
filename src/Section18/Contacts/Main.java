package Section18.Contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static ContactManager cm = new ContactManager();

    public static void main(String[] args){
        //TODO Contacts Part 6 Task 3
        try{
            String fileName = "contacts.txt";
            loadContacts(fileName);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("\nContacts Loaded\n\n");
            cm.printContacts();
        }



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

        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);
        while (scanFile.hasNextLine()){
            try {
                Contact contact = new Contact(scanFile.next(), scanFile.next(), scanFile.next());
                cm.addContact(contact);
            }catch (ParseException e){
                System.out.println(e.getMessage());
            }
        }
        scanFile.close();
    }
}
