package Section22.Models;

import java.util.Objects;

public class Pants extends Product implements Discountable{
    private int waist;

    public Pants(int waist,double price, String color, String brand) {
        super(price, color, brand);
        this.waist = waist;
    }
    public Pants(Pants source) {
        super(source);
        this.waist = source.waist;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Pants))
            return false;
        Pants pants = (Pants) o;
        return waist == pants.getWaist()
                && super.getBrand().equals(pants.getBrand())
                && super.getColor().equals(pants.getColor())
                && super.getPrice() == pants.getPrice();
    }
    @Override
    public int hashCode() {
        return Objects.hash(waist, super.getBrand(), super.getColor(), super.getPrice());
    }

    @Override
    public String toString() {
        return "{" +
                " waist= '" + waist + "'" +
                super.toString() + "}";
    }

    @Override
    public void fold() {
        System.out.println("Hold pants upright");
        System.out.println("Fold one leg over the other");
        System.out.println("Fold pants from bottom in thirds");
    }
    @Override
    public void discount() {
        super.setPrice(super.getPrice()/2);
    }
}
