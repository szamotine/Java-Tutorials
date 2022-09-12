package Section22.Models;

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
}
