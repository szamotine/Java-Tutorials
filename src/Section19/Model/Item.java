package Section19.Model;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
       checkName(name);
       checkPrice(price);
        this.name = name;
        this.price = price;
    }

    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
    }

    public String toString(){
        return name + ": $" + price + " ";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        checkPrice(price);
        this.price = price;
    }
    private void checkName(String name){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }
    private void checkPrice(double price){
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
    }
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item)obj;
        return this.name.equals(item.name) && this.price == item.price;
    }
}
