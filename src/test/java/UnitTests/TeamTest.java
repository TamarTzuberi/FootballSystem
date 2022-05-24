package UnitTests;

import DataAccess.GameDAO;
import DataAccess.SubscriberDAO;
import DataAccess.TeamDAO;
import Domain.Team;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {



    @Test
    void addGameTimeWithValidTime() {
        Team t = new Team("team0","Hapoel Haifa");
        LocalDateTime localDateTime0 = LocalDateTime.of(2022, 04, 24, 14, 33, 48, 123456789);
        t.addGameTime(localDateTime0);
        ArrayList<LocalDateTime> datesOfGames = t.getDatesOfGames();
        int success = datesOfGames.indexOf(localDateTime0);
        assertTrue(success != -1);
    }
    @Test
    void addGameTimeWithInvalidTime() {
        try {
            Team t = new Team("team0","Hapoel Haifa");
            t.addGameTime(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    void checkAvailabilityValidTime() {
        Team t = new Team("team0","Hapoel Haifa");
        LocalDateTime localDateTime0 = LocalDateTime.of(2022, 04, 24, 14, 33, 48, 123456789);
        assertEquals(true,t.checkAvailability(localDateTime0));
    }

    @Test
    void setName() {
        Team t = new Team("team0","Hapoel Haifa");
        t.setName("Hapoel Beer Sheva");
        assertEquals("Hapoel Beer Sheva",t.getName());
    }

    @Test
    void setTeamId() {
        Team t = new Team("team0","Hapoel Haifa");
        t.setTeamId("team2");
        assertEquals("team2",t.getTeamId());
    }
}