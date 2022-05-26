package AcceptanceTests;

import DataAccess.GameDAO;
import DataAccess.SubscriberDAO;
import DataAccess.TeamDAO;
import Domain.FootballAssociationRepresentative;
import Domain.Game;
import Domain.Subscriber;
import Domain.Team;
import Service.ServiceController;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test {
    private ServiceController SC = ServiceController.getInstance();
    private static GameDAO gameDAO = GameDAO.getInstance();
    private static SubscriberDAO subscriberDAO = SubscriberDAO.getInstance();
    private static TeamDAO teamDAO = TeamDAO.getInstance();

    @BeforeClass
    public static void initialize(){
        System.out.println("@BeforeClass");
        try{
            subscriberDAO.clearCollection();
            gameDAO.clearCollection();
            teamDAO.clearCollection();
            FootballAssociationRepresentative rep1 = new FootballAssociationRepresentative("1", "Navit Branin", "navitb", "navitb123!", "navitb@post.bgu.ac.il");
            subscriberDAO.save(rep1.getID(), rep1);
            Subscriber subscriber = new Subscriber("2", "Dana Hohenstein", "danah", "danah123!", "danah@post.bgu.ac.il", "Subscriber");
            subscriberDAO.save(subscriber.getID(), subscriber);
            Game game1 = new Game("game1", "team1", "team2");
            Game game2 = new Game("game2", "team1", "team3");
            Game game3 = new Game("game3", "team2", "team3");
            Team hostTeam1 = new Team("team1", "Maccabi Haifa");
            Team guestTeam1 = new Team("team2", "Hapoel Tel-Aviv");
            Team guestTeam2 = new Team("team3", "Hapoel Beer Sheba");
            gameDAO.save("game1", game1);
            gameDAO.save("game2", game2);
            gameDAO.save("game3", game3);
            teamDAO.save("team1", hostTeam1);
            teamDAO.save("team2", guestTeam1);
            teamDAO.save("team3", guestTeam2);
        } catch (Exception e){
        }
    }

    @org.junit.Test
    public void testFlowTrue(){
        boolean successLogin = SC.login("navitb", "navitb123!");
        assertTrue("couldn't login successfully",successLogin);
        boolean successRegister = SC.registerReferee("Stav Keidar", "stavk@post.bgu.ac.il", "basic");
        assertTrue("couldn't register successfully", successRegister);
        LocalDateTime localDateTime0 = LocalDateTime.of(2021, 04, 24, 14, 33, 48, 123456789);
        boolean successGamePlacement = SC.gamePlacement("game1", localDateTime0, "Terner stadium");
        assertTrue("couldn't placement game successfully", successGamePlacement);
    }

    @org.junit.Test
    public void noPermissionToReg(){
        boolean successLogin = SC.login("danah", "danah123!");
        assertTrue("couldn't login successfully",successLogin);
        boolean unsuccessRegister = SC.registerReferee("Dana Hohenstein", "danah@post.bgu.ac.il", "basic");
        assertFalse("expectation no register because there no permission", unsuccessRegister);
    }

    @org.junit.Test
    public void refereeAlreadyExist(){
        boolean successLogin = SC.login("navitb", "navitb123!");
        assertTrue("couldn't login successfully",successLogin);
        boolean unsuccessRegister = SC.registerReferee("Stav Keidar", "stavk@post.bgu.ac.il", "basic");
        assertFalse("expectation no register because referee already exist", unsuccessRegister);
    }

    @org.junit.Test
    public void teamUnavailable() {
        boolean successLogin = SC.login("navitb", "navitb123!");
        assertTrue("couldn't login successfully", successLogin);
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 04, 24, 14, 33, 48, 123456789);
        boolean unsuccessGamePlacement = SC.gamePlacement("game2", localDateTime1, "Teddy stadium");
        assertFalse("expectation no placement because date is unavailable", unsuccessGamePlacement);
    }

    @org.junit.Test
    public void noPermissionToPlace(){
        boolean successLogin = SC.login("danah", "danah123!");
        assertTrue("couldn't login successfully",successLogin);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 05, 24, 14, 33, 48, 123456789);
        boolean unsuccessGamePlacement = SC.gamePlacement("game3", localDateTime2, "Teddy stadium");
        assertFalse("expectation no placement because no permission", unsuccessGamePlacement);
    }

    @org.junit.Test
    public void userNotExist(){
        boolean unsuccessLogin = SC.login("tamart", "tamar123!");
        assertFalse("expectation no login because user not exist",unsuccessLogin);
    }

    @org.junit.Test
    public void incorrectPassword(){
        boolean unsuccessLogin = SC.login("danah", "dana123");
        assertFalse("expectation no login because incorrect password",unsuccessLogin);
    }

    @AfterClass
    public static void endAcceptanceTests(){
        subscriberDAO.clearCollection();
        gameDAO.clearCollection();
        teamDAO.clearCollection();
    }
}

