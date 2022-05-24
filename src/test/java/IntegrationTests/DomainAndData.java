package IntegrationTests;

import DataAccess.SubscriberDAO;
import Domain.DomainController;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DomainAndData {
    private DomainController domainController;
    private SubscriberDAO subscriberDAO;

    @Before
    public void initialize() {
        domainController = DomainController.getInstance();
        subscriberDAO = SubscriberDAO.getInstance();
        try{
            FootballAssociationRepresentativeStub footballAssociationRepresentativeStub = new FootballAssociationRepresentativeStub("Representative0", "Maxim", "maxim123","Maxim123!","maxim123@gmail.com");
            subscriberDAO.save(footballAssociationRepresentativeStub.getID(),footballAssociationRepresentativeStub);
            domainController.setConnectedUser(footballAssociationRepresentativeStub);
        }
        catch (Exception e)
        {

        }
    }
    @After
    public void cleanData(){
        subscriberDAO.clearCollection();
    }

    @Test
    public void RegisterReferee(){
        Boolean ifSucceed = domainController.registerReferee("TamarTzubery","tamari123@gmail.com","basic");
        String[] splitName = "TamarTzubery".split(" ");
        String username = splitName[0] + splitName[1].charAt(0);
        String id = subscriberDAO.getIdByUsername(username);
        Document d = subscriberDAO.get(id);
        assertEquals("Register Referee does not successed","TamarTzubery",(String) d.get("fullName"));
    }

}
