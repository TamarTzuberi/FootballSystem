package IntegrationTests;

import DataAccess.GameDAO;
import DataAccess.SubscriberDAO;
import DataAccess.TeamDAO;
import Domain.DomainController;
import Domain.FootballAssociationRepresentative;
import Domain.Game;
import Domain.Team;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class DomainAndData {
    private DomainController domainController = DomainController.getInstance();
    private SubscriberDAO subscriberDAO = SubscriberDAO.getInstance();
    private GameDAO gameDAO = GameDAO.getInstance();
    private TeamDAO teamDAO = TeamDAO.getInstance();

    @Before
    public void initialize() {
        subscriberDAO.clearCollection();
        gameDAO.clearCollection();
        teamDAO.clearCollection();
        try{
            FootballAssociationRepresentative footballAssociationRepresentative = new FootballAssociationRepresentative("Representative0", "Maxim", "maxim123","Maxim123!","maxim123@gmail.com");
            subscriberDAO.save(footballAssociationRepresentative.getID(),footballAssociationRepresentative);
            domainController.setConnectedUser(footballAssociationRepresentative);
            Team team0 = new Team("team0","macabi tel aviv");
            Team team1 = new Team("team1", "hapoel beer sheva");
            teamDAO.save("team0",team0);
            teamDAO.save("team1",team1);
            Game game0 = new Game("game0","team0","team1");
            gameDAO.save("game0",game0);
        }
        catch (Exception e)
        {
        }
    }

    @Test
    public void registerRefereeValidName(){
        domainController.registerReferee("Tamar Tzubery","tamari123@gmail.com","basic");
        String[] splitName = "Tamar Tzubery".split(" ");
        String username = splitName[0] + splitName[1].charAt(0);
        String id = subscriberDAO.getIdByUsername(username);
        Document d = subscriberDAO.get(id);
        Document sub = (Document)d.get("subscriber");
        String fnDB = (String) sub.get("name");
        assertEquals("The name of the referee didn't save properly in the DB","Tamar Tzubery",fnDB);
    }
    @Test
    public void registerRefereeValidEmail(){
        domainController.registerReferee("Tamar Tzubery","tamari123@gmail.com","basic");
        String[] splitName = "Tamar Tzubery".split(" ");
        String username = splitName[0] + splitName[1].charAt(0);
        String id = subscriberDAO.getIdByUsername(username);
        Document d = subscriberDAO.get(id);
        Document sub = (Document)d.get("subscriber");
        String emailDB = (String) sub.get("email");
        assertEquals("The email of the referee didn't save properly in the DB","tamari123@gmail.com",emailDB);
    }
    @Test
    public void registerRefereeValidTraining(){
        domainController.registerReferee("Tamar Tzubery","tamari123@gmail.com","basic");
        String[] splitName = "Tamar Tzubery".split(" ");
        String username = splitName[0] + splitName[1].charAt(0);
        String id = subscriberDAO.getIdByUsername(username);
        Document d = subscriberDAO.get(id);
        Document sub = (Document)d.get("subscriber");
        String trainingDB = (String) sub.get("training");
        assertEquals("The training of the referee didn't save properly in the DB","basic",trainingDB);
    }

    @Test
    public void gamePlacement(){
        LocalDateTime localDateTime0 = LocalDateTime.of(2022, 04, 24, 14, 33, 48, 123456789);
        domainController.gamePlacement("game0",localDateTime0,"Tedi");
        Document d = gameDAO.get("game0");
        Document sub = (Document)d.get("game");
        String placeDB = (String) sub.get("field");
        assertEquals("The place of the game didn't save properly in the DB","Tedi",placeDB);
    }

    @After
    public void endIntegrationTests(){
        subscriberDAO.clearCollection();
        gameDAO.clearCollection();
        teamDAO.clearCollection();
    }
}
