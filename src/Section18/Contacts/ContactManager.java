package Section18.Contacts;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList <Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public Contact getContacts(int index) {
        return new Contact(this.contacts.get(index));
    }

    public void setContacts(int index, Contact contact) {
        this.contacts.add(index, new Contact(contact));

    }

    public void addContact(Contact contact){
        this.contacts.add(new Contact(contact));
    }

    public void removeContact(String contactName){
        if (this.contacts.isEmpty()) throw new IllegalStateException("Cannot remove contact, List is empty");
        Contact ct = contacts.stream().filter(c -> contactName.equals(c.getName())).findFirst().orElse(null);
        this.contacts.remove(ct);

    }

    public void printContacts(){
        for (Contact c: contacts) {
            System.out.println(c.toString());
        }
    }
}
