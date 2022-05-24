package AcceptanceTests;

import DataAccess.GameDAO;
import DataAccess.SubscriberDAO;
import DataAccess.TeamDAO;
import Domain.FootballAssociationRepresentative;
import Domain.Game;
import Domain.Subscriber;
import Domain.Team;
import Service.ServiceController;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test {
    private ServiceController SC = ServiceController.getInstance();
    private GameDAO gameDAO = GameDAO.getInstance();
    private SubscriberDAO subscriberDAO = SubscriberDAO.getInstance();
    private TeamDAO teamDAO = TeamDAO.getInstance();

    @Before
    public void initialize(){
        try{
            FootballAssociationRepresentative rep1 = new FootballAssociationRepresentative("1", "Navit Branin", "navitb", "navitb123!", "navitb@post.bgu.ac.il");
            subscriberDAO.save(rep1.getID(), rep1);
            Subscriber subscriber = new Subscriber("2", "Dana Hohenstein", "danah", "danah123!", "danah@post.bgu.ac.il", "Subscriber");
            subscriberDAO.save(subscriber.getID(), subscriber);
            Game game = new Game("game1", "team1", "team2");
            Team hostTeam = new Team("team1", "Maccabi Haifa");
            Team guestTeam = new Team("team2", "Hapoel Tel-Aviv");
            gameDAO.save("game1", game);
            teamDAO.save("team1", hostTeam);
            teamDAO.save("team2", guestTeam);
        } catch (Exception e){
            System.out.println("hi");
        }
    }

    @org.junit.Test
    @DisplayName("Test flow true")
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
    @DisplayName("Test flow false")
    public void testFlowFalse(){
        boolean successLogin = SC.login("danah", "danah123!");
        assertTrue("couldn't login successfully",successLogin);
        boolean unsuccessRegister = SC.registerReferee("Dana Hohenstein", "danah@post.bgu.ac.il", "basic");
        assertFalse("no permission to register", unsuccessRegister);
    }

    @After
    public void endAAcceptanceTests(){
        subscriberDAO.clearCollection();
        gameDAO.clearCollection();
        teamDAO.clearCollection();
    }

}

