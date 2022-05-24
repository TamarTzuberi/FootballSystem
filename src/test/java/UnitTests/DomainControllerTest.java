package UnitTests;

import Domain.DomainController;
import Domain.FootballAssociationRepresentative;
import Domain.Subscriber;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomainControllerTest {

    @Test
    void setConnectedUser() {
        DomainController DC = DomainController.getInstance();
        FootballAssociationRepresentative representative = new FootballAssociationRepresentative("rep0","Tamar","TamarUser","Tamar123!","tamar@gmail.com");
        DC.setConnectedUser(representative);
        assertEquals(DC.getConnectedUser(),representative);
    }

    @Test
    void checkIfRepresentative() {
        DomainController DC = DomainController.getInstance();
        FootballAssociationRepresentative representative = new FootballAssociationRepresentative("rep0","Tamar","TamarUser","Tamar123!","tamar@gmail.com");
        DC.setConnectedUser(representative);
        assertEquals(true,DC.checkIfRepresentative());
    }

    @Test
    void checkIfRepresentativeWhileNot() {
        DomainController DC = DomainController.getInstance();
        Subscriber s = new Subscriber("subscriber0","bob","userBob","Bob123!","bob@gmail.com","Subscriber");
        DC.setConnectedUser(s);
        assertEquals(false,DC.checkIfRepresentative());
    }

    @Test
    void registerReferee() {
        DomainController DC = DomainController.getInstance();
        assertEquals(true,DC.registerReferee("Tamar Tzuberi","tamartz@gmail.com","basic"),"register referee failed");
    }
    @Test
    void registerRefereeWithBadFullName() {
        DomainController DC = DomainController.getInstance();
        assertEquals(false,DC.registerReferee("Tamar12","tamartz@gmail.com","basic"),"bad full name");
    }

    @Test
    void registerRefereeWithBadEmail() {
        DomainController DC = DomainController.getInstance();
        assertEquals(false,DC.registerReferee("Tamar Tzuberi","tamartzgmail.com","basic"),"bad full name");
    }

    @Test
    void gamePlacement() {

    }

    @Test
    void login() {

    }
}