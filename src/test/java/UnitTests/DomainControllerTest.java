package UnitTests;

import DataAccess.SubscriberDAO;
import Domain.DomainController;
import Domain.FootballAssociationRepresentative;
import Domain.Subscriber;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomainControllerTest {
    DomainController DC = DomainController.getInstance();
    SubscriberDAO subscriberDAO = SubscriberDAO.getInstance();

    @Before
    public void initialize(){
        subscriberDAO.clearCollection();
    }

    @Test
    void setConnectedUser() {
        FootballAssociationRepresentative representative = new FootballAssociationRepresentative("rep0","Tamar","TamarUser","Tamar123!","tamar@gmail.com");
        DC.setConnectedUser(representative);
        assertEquals(DC.getConnectedUser(),representative);
    }

    @Test
    void checkIfRepresentative() {
        FootballAssociationRepresentative representative = new FootballAssociationRepresentative("rep0","Tamar","TamarUser","Tamar123!","tamar@gmail.com");
        DC.setConnectedUser(representative);
        assertTrue(DC.checkIfRepresentative(), "The connected user is not representative");
    }

    @Test
    void checkIfRepresentativeWhileNot() {
        Subscriber s = new Subscriber("subscriber0","bob","userBob","Bob123!","bob@gmail.com","Subscriber");
        DC.setConnectedUser(s);
        assertFalse(DC.checkIfRepresentative(),"The connected user is representative while it's not should be");
    }

    @Test
    void registerReferee() {
        boolean registerReferee = DC.registerReferee("Tamar Tzuberi","tamartz@post.bgu.il","basic");
        assertTrue(registerReferee,"register referee failed");
    }
    @Test
    void registerRefereeWithBadFullName() {
        boolean registerRefereeWithBadFullName = DC.registerReferee("Tamar12","tztamar@gmail.com","basic");
        assertFalse(registerRefereeWithBadFullName,"invalid full name (first name, last name)");
    }

    @Test
    void registerRefereeWithBadEmail() {
        boolean registerRefereeWithBadEmail = DC.registerReferee("Tamar Tzuberi","tamartzgmail.com","basic");
        assertFalse(registerRefereeWithBadEmail,"invalid format mail");
    }

    @After
    public void endUnitTests(){
        subscriberDAO.clearCollection();
    }
}