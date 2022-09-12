package Section22.Models;

public class Pants extends Product {
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
}
