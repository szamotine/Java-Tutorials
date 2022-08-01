package Section18.MovieStore;


import Section18.MovieStore.Model.Movie;
import Section18.MovieStore.Model.Store;

public class Main {

    static public void main(String[] args){
        String name = "Rambo2";
        String format = "dvd";
        int rating = 0;
        Movie m = new Movie("Rambo", "DVD", 5);

        Movie m2 = new Movie(name, format, rating);
        Movie m3 = new Movie("The Shawshank Redemption", "Blue-Ray", 9.2);
        Movie m4 = new Movie("The Godfather", "Blue-ray", 9.1);
        Movie m5 = new Movie("The Godfather: Part 2", "DvD", 9.0);

        Store s = new Store();
        s.addMovie(m);
        s.addMovie(m2);
        s.addMovie(m3);
        s.addMovie(m4);
        s.addMovie(m5);
        s.rentMovie(name);
        s.returnMovie(name);
        //s.setMovie(1,m);
        s.sellMovie(m.getName());
        s.action(m.getName(),"return");
        s.action(m.getName(),"rent");
        s.action(m.getName(),"sell");
        System.out.println(s.toString());





    }
}
