package Section18.MovieStore.Model;

import java.util.ArrayList;

public class Store {
    private ArrayList <Movie> movies;

    public Store() {
        movies = new ArrayList<Movie>();
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
        Movie m = findByName(name);
        if (m!=null){
            switch (action){
                case "rent":
                    System.out.println("action: rent");
                    m.setAvailable(false);
                    break;
                case "sell":
                    System.out.println("action: sell");
                    movies.remove(m);
                    break;
                case "return":
                    System.out.println("action: return");
                    m.setAvailable(true);
                    break;
                default:
                    System.out.println("Invalid action: Action must be rent, buy, or return");
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
