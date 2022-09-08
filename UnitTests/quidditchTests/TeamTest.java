package quidditchTests;

import Quidditch.Models.Team;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TeamTest {

    @Test
    public void hasNullTest(){
        String[] chasers = new String[] {null, "Ginny", "Katie"};
        assertTrue(Team.hasNull(chasers));
    }

    @Test
    public void hasBlankTest(){
        String[] chasers = {"    ", "Ginny", "Katie"};
        assertTrue(Team.hasBlank(chasers));

    }


}
