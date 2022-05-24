package IntegrationTests;

import Domain.DomainController;
import org.junit.Before;

public class DomainAndData {
    private DomainController domainController;

    @Before
    public void initialize() {
        domainController = DomainController.getDC();
        try{
            FootballAssociationRepresentativeStub footballAssociationRepresentativeStub = new FootballAssociationRepresentativeStub("Representative0", "Maxim", "maxim123","Maxim123!","maxim123@gmail.com");

            domainController.login("maxim123","Maxim123!");

        }
        catch ()
        {

        }
    }
}
