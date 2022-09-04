package Section19.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Cart {
    private final ArrayList<Item> items;
    private final ArrayList<Item> filteredList;
    private final double tax = 0.13;

    public Cart() {
       this.items = new ArrayList<>();
      this.filteredList = new ArrayList<>();
    }

    public void addItem(Item i){
        if (this.items.contains(i)) {
            System.out.println("Cannot add item, it is already in the cart");
        }else if(i == null) {
            System.out.println("Item not found");
        }else {
            this.items.add(new Item (i));
            System.out.println(i.getName() + " was added to your shopping cart");
        }
    }
    public void clear(){
        this.items.clear();
    }
    public boolean add(Item i){
        if(this.items.contains(i)){
            return false;
        }
        this.items.add(new Item (i));
        return true;
    }

    public boolean contains(Item i){
        return this.items.contains(i);
    }

    public void remove(Item i){
       checkCart();
        if (this.items.contains(i) && i != null) {
            this.items.remove(i);
            System.out.println(i.getName() + " was removed from your shopping cart");
        }else{
            System.out.println("Cannot remove item, it is not in the cart");
        }
    }

    public void removeItem(Item i){
        //TODO Shopping Cart Part 3 removeIF https://www.learnthepart.com/course/2dfda34d-6bbc-4bd5-8f45-d5999de2f514/ad5400b5-ecc0-47b1-be30-79943ad3155c
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

    public double getSubtotal(double[] items){
        double subtotal =0;
        for (double i: items) {
            subtotal += i;
        }
        return subtotal;
    }

    public double getTax(double subtotal){
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(subtotal*tax));
       // return (double)Math.round(subtotal * tax * 100)/100;
    }

    public double getTotal(double subtotal, double taxAmount){
        return subtotal + taxAmount;
    }

    public Item getItems(int index) {
        return new Item (items.get(index));
    }

    public void setItems(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public String toString(){
        StringBuilder temp = new StringBuilder();
        for (Item i: this.items
             ) {
            temp.append(i.toString()).append("\n");
        }
        return temp.toString();
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

    public void filterList(double max){
        this.filteredList.addAll(
                this.items.stream()
                .filter(item -> item.getPrice() < max)
                .collect(Collectors.toList())
                );
        System.out.println(printFilteredList());
    }

    public String printFilteredList(){
        StringBuilder temp = new StringBuilder();
        for (Item i: this.filteredList
        ) {
            temp.append(i.toString()).append("\n");
        }
        return temp.toString();
    }
}
