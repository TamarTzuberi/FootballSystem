package IntegrationTests;

import Service.ServiceController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DomainAndService {
    private ServiceController serviceController;

    @Before
    public void initialize() {
        serviceController = ServiceController.getInstance();
    }
    @Test
    public void loginNullValues(){
        Boolean ifSucess = serviceController.login(null,null);
        assertEquals("null values should not move to domain layer ",false,ifSucess);
    }
    @Test
    public void registerRefereeNullValues(){
        Boolean ifSucess = serviceController.registerReferee(null,null,null);

    }

    @Test
    public void gamePlacementNullValues(){
        Boolean ifSucess = serviceController.gamePlacement(null,null,null);

    }


}
