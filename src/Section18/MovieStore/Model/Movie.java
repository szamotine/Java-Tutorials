package Section18.MovieStore.Model;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentingPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        if (name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
        this.name = name;
        if (format.isBlank() || !(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("blue-ray")) ) throw new IllegalArgumentException("Format is not an accepted value");
        this.format = format;
        if (rating < 0 || rating > 10) throw new IllegalArgumentException("Rating must be from 0 - 10");
        this.rating = rating;
        isAvailable = true;
        this.sellingPrice = format.equals("DVD")? 2.25 : 4.25;
        this.rentingPrice = format.equals("DVD")? 0.99 : 1.99;
        //System.out.println("\nMovie Created:");
        //printMovie();
    }

    public Movie(Movie m){
        this.name = m.name;
        this.format = m.format;
        this.rating = m.rating;
        isAvailable = true;
        this.sellingPrice = format.equalsIgnoreCase("DVD")? 2.25 : 4.25;
        this.rentingPrice = format.equalsIgnoreCase("DVD")? 0.99 : 1.99;
        //System.out.println("\nMovie Created:");
       // printMovie();

    }

    public void printMovie(){
        System.out.println("\n-----------------Movie details-----------------\n");
        System.out.println("Movie name: " + name);
        System.out.println("Movie format: " + format);
        System.out.println("Movie rating: " + rating);
        System.out.println("Movie available: " + isAvailable);
        System.out.println("Movie selling price: " + sellingPrice);
        System.out.println("Movie rental price: " + rentingPrice);
        System.out.println("\n--------------------------------------------\n");
    }

//region Getters, Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        String dvd = "dvd";
        String blueRay = "blue-ray";
        if (format == null || format.isEmpty()) {
            throw new IllegalArgumentException("SetFormat cannot be null or blank");
        }

        if (!(format.equalsIgnoreCase(dvd)) && !(format.equalsIgnoreCase(blueRay))) {
            throw new IllegalArgumentException("SetFormat is not valid, it must be dvd or blue-ray");
        }
        this.format = format;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("SetRating must be between 0 - 10");
        }
        this.rating = rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getRentingPrice() {
        return rentingPrice;
    }

    private void setRentingPrice(double rentingPrice) {
        this.rentingPrice = rentingPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
//endregion
}
