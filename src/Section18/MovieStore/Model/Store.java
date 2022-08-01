package Section18.MovieStore.Model;

import java.util.ArrayList;

public class Store {
    private ArrayList <Movie> movies;

    public Store() {
        movies = new ArrayList<>();
    }

    public Movie getMovie(int index) {

        return new Movie(movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie){
        movies.add(new Movie(movie));
    }

    public void sellMovie(String movieName){
        Movie m = findByName(movieName);
        if (m != null) {
            movies.remove(m);
            System.out.println(movieName + " Successfully sold");
        }else{
            System.out.println(movieName + " not found, cannot sell");
        }
    }

    public void rentMovie(String movieName){
        Movie m = findByName(movieName);
        m.setAvailable(false);
    }

    public void returnMovie(String movieName){
        Movie m = findByName(movieName);
        m.setAvailable(true);
    }

    public void action(String name, String action){
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Name cannot be null/blank in action");
        }
        if (movies.isEmpty()) {
            throw new IllegalStateException("This store does not contain any movies");
        }
        Movie m = findByName(name);
        if (m!=null){
            switch (action){
                case "rent":
                    System.out.println("Renting out " + name);
                    m.setAvailable(false);
                    break;
                case "sell":
                    if (!m.isAvailable()) {
                        throw new IllegalStateException("Cannot sell " + name + ", it is rented");
                    }
                    System.out.println("Selling" + name);
                    movies.remove(m);
                    break;
                case "return":
                    System.out.println("Returning " + name);
                    m.setAvailable(true);
                    break;
                default:
                   throw new IllegalArgumentException("Invalid action: Action must be rent, buy, or return");
            }
        }else{
            System.out.println(name + " not found, cannot " + action);
        }
    }

    public String toString(){
        String temp = "\n";

        for (Movie m: movies) {
            temp += m.getName()
                    + "\nFormat: " + m.getFormat()
                    + "\nRating: " + m.getRating()
                    + "\nRentingPrice: " + m.getRentingPrice()
                    + "\nSellingPrice: " + m.getSellingPrice() + "\n\n";

        }
        return temp;
    }

    private Movie findByName(String name){
        return movies.stream().filter(m -> name.equals(m.getName())).findFirst().orElse(null);
    }


}
