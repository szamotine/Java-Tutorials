package Section22.Models;

import java.util.Objects;

public class Shirt extends Product {
    public enum Size{
        SMALL,
        MEDIUM,
        LARGE
    }
    private Size size;

    public Shirt(Size size, double price, String color, String brand) {
        super( price,  color,  brand);
        this.size = size;
    }

    public Shirt(Shirt source) {
        super(source);
        this.size =source.getSize();
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Shirt))
            return false;
        Shirt shirt = (Shirt) o;
        return size.equals(shirt.size)
                && super.getBrand().equals(shirt.getBrand())
                && super.getColor().equals(shirt.getColor())
                && super.getPrice() == shirt.getPrice();
    }
    @Override
    public int hashCode() {
        return Objects.hash(size, super.getBrand(), super.getColor(), super.getPrice());
    }

    @Override
    public String toString() {
        return "{" +
                " size= '" + size + "'" +
                super.toString() + "}";
    }

    @Override
    public void fold() {
        System.out.println("Lay shirt on flat surface");
        System.out.println("Fold shirt sideways");
        System.out.println("Bring sleeves in");
        System.out.println("Fold from bottom up");
    }
}
