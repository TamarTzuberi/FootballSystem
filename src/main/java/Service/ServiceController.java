package Service;

import Domain.DomainController;
import Domain.Logger;

import java.time.LocalDateTime;

public class ServiceController {
    private static ServiceController SC;
    private static Logger logger = Logger.getInstance("logs");

    private ServiceController(){
    }

    private static ServiceController getInstance(){
        if (SC == null){
            SC = new ServiceController();
        }
        return SC;
    }

    public boolean login(String username, String password)
    {
        if (username == null || password == null){
            return false;
        }
            try{
                DomainController dc = DomainController.getDC();
                dc.login(username, password);
                return true;
            } catch (Exception e) {
                logger.toLog("SC - Login not succeeded");
                System.out.println("Login not succeeded");
                return false;
            }
    }

    public boolean registerReferee(String id, String repUsername, String repPass, String fullName, String email, String training)
    {
        if (id == null || repUsername == null || repPass == null || fullName == null || email == null || training == null){
            return false;
        }
        try{
            DomainController dc = DomainController.getDC();
            boolean ifUserExist = dc.login(repUsername, repPass);
            boolean ifRep = dc.checkIfRepresentative();
            if(ifRep)
            {
                boolean success = dc.registerReferee(fullName, email, training);
                logger.toLog("SC - Referee registered successfully");
                return true;
            }
            else
            {
                logger.toLog("SC - The current user has no permission");
                System.out.println("no permission");
                return false;
            }
        } catch (Exception e) {
            logger.toLog("SC - Register not succeeded");
            System.out.println("Register not succeeded");
            return false;
        }
    }


    public boolean gamePlacement(String gameId, LocalDateTime time, String place)
    {
        if (gameId == null || time == null || place == null){
            return false;
        }
        try {
            DomainController dc = DomainController.getDC();
            boolean ifRep = dc.checkIfRepresentative();
            if(ifRep)
            {
                boolean success = dc.gamePlacement(gameId, time, place);
                logger.toLog("SC - Game placement successfully");
                return true;
            }
            else
            {
                logger.toLog("SC - The current user has no permission");
                System.out.println("no permission");
                return false;
            }
        } catch (Exception e) {
            logger.toLog("SC - Game placement not succeeded");
            System.out.println("Game placement not succeeded");
            return false;
        }
    }
}
