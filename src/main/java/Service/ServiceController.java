package Service;

import Domain.DomainController;
import Domain.Logger;

import java.time.LocalDateTime;

public class ServiceController {
    private static ServiceController SC;
    private static DomainController DC = DomainController.getInstance();
    private static Logger logger = Logger.getInstance("logs");

    private ServiceController(){
    }

    public static ServiceController getInstance(){
        if (SC == null){
            SC = new ServiceController();
        }
        return SC;
    }

    /**
     *
     * @param username String : the user name to login
     * @param password String : the password to login
     * @return Boolean : true if login success, else false
     */
    public boolean login(String username, String password)
    {
        if (username == null || password == null){
            return false;
        }
            try{
                boolean success = DC.login(username, password);
                logger.toLog("User logged in successfully");
                if (success){
                    return true;
                }
                else{
                    logger.toLog("SC - Login didn't success");
                    return false;
                }
            } catch (Exception e) {
                logger.toLog("SC - Login didn't success");
                return false;
            }
    }

    /**
     *
     * @param fullName String : the full name of the referee
     * @param email String : the email of the referee
     * @param training String : the training of the referee
     * @return Boolean : true if register success, else false
     */
    public boolean registerReferee(String fullName, String email, String training)
    {
        if (fullName == null || email == null || training == null){
            return false;
        }
        try{
            // Assuming a login has been preformed before
            boolean ifRep = DC.checkIfRepresentative();
            if(ifRep)
            {
                boolean registerSuccess = DC.registerReferee(fullName, email, training);
                if (registerSuccess){
                    logger.toLog("SC - Referee registered successfully");
                    return true;
                }
                else{
                    logger.toLog("SC - Registered referee didn't success");
                    return false;
                }
            }
            else
            {
                logger.toLog("SC - The current user " + DC.getCurUserName() + " has no permission");
                return false;
            }
        } catch (Exception e) {
            logger.toLog("SC - Register " + fullName + " didn't success");
            return false;
        }
    }

    /**
     *
     * @param gameId String: the id of the game
     * @param time LocalDateTime : the time of the game
     * @param place String : the place of the game
     * @return Boolean : true if game placement successed, else false
     */
    public boolean gamePlacement(String gameId, LocalDateTime time, String place)
    {
        if (gameId == null || time == null || place == null){
            return false;
        }
        try {
            // Assuming a login has been preformed before
            boolean ifRep = DC.checkIfRepresentative();
            if(ifRep)
            {
                boolean success = DC.gamePlacement(gameId, time, place);
                if (success){
                    logger.toLog("SC - Game placement successfully");
                    return true;
                }
                else{
                    logger.toLog("SC - Game placement didn't success");
                    return false;
                }
            }
            else
            {
                logger.toLog("SC - The current user has no permission");
                return false;
            }
        } catch (Exception e) {
            logger.toLog("SC - Game placement didn't success");
            return false;
        }
    }
}
