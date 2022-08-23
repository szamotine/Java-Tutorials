package MovieStoreTests;

import Section18.MovieStore.Model.Movie;
import Section18.MovieStore.Model.Store;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MovieStoreTests {
    Store store = new Store();
    Movie m1 = new Movie("The Shawshank Redemption", "Blue-Ray", 9.2);
    Movie m2 = new Movie("The Godfather", "Blue-Ray", 9.1);
    @Before
    public void setup(){
        store.addMovie(m1);
        store.addMovie(m2);
    }
    //TODO MovieStore Part 1 Unit Testing https://www.learnthepart.com/course/2dfda34d-6bbc-4bd5-8f45-d5999de2f514/7ad7931e-2baf-4cc1-b6bb-1c095a3bfde1
    //add movie
    //sell a movie
    //rent a movie
    //return a movie
    @Test
    public void movieAdded(){
        assertTrue(store.contains(store.findByName(m1.getName())));
        assertTrue(store.contains(m1.getName()));


    }

    @Test
    public void movieSold(){
        store.action(m1.getName(), "sell");
        assertFalse(store.contains(m1.getName()));

    }

    @Test
    public void movieRented(){
        store.action(m1.getName(), "rent");
        assertFalse(store.checkAvailable(m1.getName()));

    }

    @Test
    public void movieReturned(){
        store.action(m1.getName(), "rent");
        assertFalse(store.checkAvailable(m1.getName()));
        store.action(m1.getName(), "return");
        assertTrue(store.checkAvailable(m1.getName()));


    }
}
