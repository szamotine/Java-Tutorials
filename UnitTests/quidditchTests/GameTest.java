package quidditchTests;

import Quidditch.Models.Game;
import Quidditch.Models.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    Game g;
    Team t1;
    Team t2;
    @Before
    public void setup(){
         t1 =  new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[] {"Angelina", "Ginny", "Katie"});

         t2 = new Team("SLYTHERIN", "Vincent",  "Draco",
                new String[] {"Bridget", "Harper", "Malcolm"});
        g = new Game(t1,t2);
    }


    @Test
    public void getPlaceHolderTest(){
        assertEquals("chaser", g.getPlaceholder("<chaser> gets the next pass"));
    }

    @Test
    public void replacePlaceholderTest(){
        assertEquals("Katie gets the next pass", g.replacePlaceholder("<chaser> gets the next pass", "chaser", "Katie"));
    }

    @Test
    public void quaffleScoreTest(){
        Team team = g.getTeam("GRYFFINDOR");
        g.quaffleScore(team);
        g.quaffleScore(team);
        assertEquals(20, g.getScore(team));
    }
    @Test
    public void catchSnitchTest(){
        Team team = g.getTeam("SLYTHERIN");
        g.catchSnitch(team);
        assertEquals(150, g.getScore(team));
    }

}
