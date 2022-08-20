package MovieStoreTests;

import Section18.MovieStore.Model.Movie;
import Section18.MovieStore.Model.Store;
import org.junit.Before;
import org.junit.Test;

public class MovieStoreTests {
    Store store = new Store();
    Movie m1 = new Movie("The Shawshank Redemption", "Blue-Ray", 9.2);
    Movie m2 = new Movie("The Godfather", "Blue-Ray", 9.1);
    @Before
    public void setup(){
        store.addMovie(m1);
        store.addMovie(m2);
    }

    @Test
    public void movieAdded(){
        //TODO MovieStore Part 1 Unit Testing https://www.learnthepart.com/course/2dfda34d-6bbc-4bd5-8f45-d5999de2f514/7ad7931e-2baf-4cc1-b6bb-1c095a3bfde1
       // assertTrue(store.contains(new Movie(m1)));
    }
}
