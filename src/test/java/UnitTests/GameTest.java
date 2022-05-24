package UnitTests;

import DataAccess.GameDAO;
import DataAccess.SubscriberDAO;
import DataAccess.TeamDAO;
import Domain.DomainController;
import Domain.FootballAssociationRepresentative;
import Domain.Game;
import Domain.Team;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private DomainController domainController;

    @Before
    public void initialize() {
        domainController = DomainController.getInstance();

        try {

        } catch (Exception e) {
        }
    }


    @Test
    void setTimeWithValidTime() {
        Game g = new Game("game0","team0","team1");
        LocalDateTime localDateTime0 = LocalDateTime.of(2022, 04, 24, 14, 33, 48, 123456789);
        g.setTime(localDateTime0);
        assertEquals(localDateTime0,g.getTime(),"The time of the game does not set");
    }

    @Test
    void setTimeWithNull() {

        try {
            Game g = new Game("game0","team0","team1");
            g.setTime(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    void gameConstructorNullValue() {

        try {
            assertNull(new Game(null, "team0", "team1"));
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }


}
