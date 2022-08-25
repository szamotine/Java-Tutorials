package Section18.MovieStore.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Store {
    private final List<Movie> movies;

    public Store() {
        movies = new ArrayList<>();
    }

    public Movie getMovie(int index) {

        return new Movie(movies.get(index));
    }

    public boolean contains(Movie m){
        return movies.contains(m);
    }
    public boolean contains(String movie){
        return movies.contains(findByName(movie));
    }

    public void setMovie(int index, Movie movie) {
        movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie){
        movies.add(new Movie(movie));
    }

    public void sellMovie(String movieName){
        if (!(findByName(movieName).isAvailable())) {
            throw new IllegalStateException("Cannot sell rented movie");
        }
        movies.removeIf((movie) -> movie.getName().equals(movieName));
    }

    public void rentMovie(String movieName){
        Movie m = findByName(movieName);
        if (m != null) {
            m.setAvailable(false);
        }
    }

    public void returnMovie(String movieName){
        Movie m = findByName(movieName);
        m.setAvailable(true);
    }

    public void action(String name, String action){
        if ( name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null/blank in action");
        }
        if (movies.isEmpty()) {
            throw new IllegalStateException("This store does not contain any movies");
        }
        Movie m = findByName(name);
        if (m!=null){
            switch (action){
                case "rent":
                    if (m.isAvailable()) {
                        System.out.println("\tRenting out " + name);
                        m.setAvailable(false);
                    }else{
                        System.out.println("Sorry, " + name + " is already rented out");
                    }

                    break;
                case "sell":
                    if (!m.isAvailable()) {
                        throw new IllegalStateException("Cannot sell " + name + ", it is rented");
                    }
                    System.out.println("\tSelling " + name);
                    movies.remove(m);
                    break;
                case "return":
                    if (!m.isAvailable()) {
                        System.out.println("\tReturning " + name);
                        m.setAvailable(true);
                    }else{
                        System.out.println("Movie has not been rented yet");
                    }

                    break;
                default:
                   throw new IllegalArgumentException("\tInvalid action: Action must be rent, buy, or return");
            }
        }else if (action.equals("return")) {
            System.out.println("Cannot return a sold movie");
        }
        else{
            System.out.println(name + " not found, cannot " + action);
        }
    }

    public String toString(){
        StringBuilder temp = new StringBuilder("\n ------------Movie List------------\n");
        for (Movie m: movies) {
            temp.append(m.getName()).append("\nFormat: ").append(m.getFormat()).append("\nRating: ").append(m.getRating()).append("\nRentingPrice: ").append(m.getRentingPrice())
                    .append("\nSellingPrice: ").append(m.getSellingPrice()).append("\n\n");

        }
        return temp.toString();
    }

    public Movie findByName(String name){
        return movies.stream().filter(m -> name.equals(m.getName())).findFirst().orElse(null);
    }

    public boolean checkAvailable(String name){
        Movie m = findByName(name);
        return m.isAvailable();
    }

    public int getMovieIndex(String movieName){
        return IntStream.range(0, this.movies.size())
                .filter((index) -> this.movies.get(index).getName().equals(movieName))
                .findFirst()
                .orElse(-1000);
    }




}
