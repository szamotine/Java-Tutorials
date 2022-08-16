package Section19.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private ArrayList<Item> items;
    private double tax = 0.13;

    private Scanner scan = new Scanner(System.in);

    public Cart() {
       this.items = new ArrayList<>();
    }

    public void add(Item i){
        if (this.items.contains(i)) {
            System.out.println("Cannot add item, it is already in the cart");
        }else if(i == null) {
            System.out.println("Item not found");
        }else {
            this.items.add(new Item (i));
            System.out.println(i.getName() + " was added to your shopping cart");
        }
    }
    //remove
    public void remove(Item i){
       checkCart();
        if (this.items.contains(i) && i != null) {
            this.items.remove(i);
            System.out.println(i.getName() + " was removed from your shopping cart");
        }else{
            System.out.println("Cannot remove item, it is not in the cart");
        }
    }

    public String checkOut(){
        checkCart();
        double subTotal =0;
        double taxAmount;
        double total;
        for (Item i: this.items) {
            subTotal += i.getPrice();
        }
        taxAmount = (double)Math.round(subTotal * tax*100) / 100;
        total = subTotal + taxAmount;
        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + subTotal + "\n" +
                "\tTax: $" + taxAmount + "\n" +
                "\tTotal: $" + total + "\n";
    }

    public Item getItems(int index) {
        return new Item (items.get(index));
    }

    public void setItems(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public String toString(){
        String temp = "";
        for (Item i: this.items
             ) {
            temp += i.toString() + "\n";
        }
        return temp;
    }

    private void checkCart(){
        if(this.items.isEmpty()){
            throw new IllegalStateException("Error: Cart is empty");
        }
    }

    public boolean cartEmpty() {
        return this.items.isEmpty();
    }

    public Item findByName(String name){
        Item temp = null;
        for (Item i: items) {
            if(i.getName().equalsIgnoreCase(name)){
                temp = new Item(i);
                break;
            }
        }
        if(temp == null){
            System.out.println("Could not find " + name + " in cart");
        }
        return temp;
    }
}
