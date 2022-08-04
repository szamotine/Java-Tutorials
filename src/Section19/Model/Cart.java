package Section19.Model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;
    private double tax = 0.13;

    public Cart() {
       this.items = new ArrayList<>();
    }

    public void add(Item i){
        if (this.items.contains(i)) {
            System.out.println("Cannot add item, it is already in the cart");
        }else{
            this.items.add(new Item (i));
        }
    }
    //remove
    public void remove(Item i){
       checkCart();
        if (this.items.contains(i)) {
            this.items.remove(i);
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
        taxAmount = subTotal * tax;
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

}
