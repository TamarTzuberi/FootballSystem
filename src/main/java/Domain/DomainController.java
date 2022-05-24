package Domain;

import DataAccess.GameDAO;
import DataAccess.SubscriberDAO;
import DataAccess.TeamDAO;
import org.bson.Document;

import java.time.LocalDateTime;

public class DomainController {

    private static DomainController DC;
    private Subscriber connectedUser;
    private static DataAccess.SubscriberDAO subscriberDAO = SubscriberDAO.getInstance();
    private static DataAccess.GameDAO gameDAO = GameDAO.getInstance();
    private static DataAccess.TeamDAO teamDAO = TeamDAO.getInstance();
    private static Logger logger = Logger.getInstance("logs");

    private DomainController()
    {
       // connectedUser = ***get from DB and check if correct**
    }

    public static DomainController getInstance()
    {
        if (DC == null)
        {
            DC = new DomainController();
        }
        return DC;
    }

    public void setConnectedUser(Subscriber curUser) {
        connectedUser = curUser;
    }

    private static boolean checkFullName(String fullName) {
        return fullName.matches("[a-zA-Z]+");
    }

    private static boolean checkEmail(String email) {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

    private boolean checkPassword(String password) {
        return password.matches("^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}$");
    }

    public boolean login(String username, String password)
    {
        //check if username exist in DB
        boolean userExists = subscriberDAO.checkIfSubscriberExists("userName",username);
        if(userExists)
        {
            String userId = subscriberDAO.getIdByUsername(username);
            Document subscriber = subscriberDAO.get(userId);
            //get User details from DB
            Subscriber curUser = getTheUser(subscriber);
            //check if password correct
            if(curUser.getPassword().equals(password))
            {
                setConnectedUser(curUser);
                logger.toLog("DC - User connected successfully");
                return true;
            }
            else
            {
                logger.toLog("DC - user " + username + " incorrect Password");
                return false;
            }
        }
        logger.toLog("DC - username " + username + " not exist");
        return false;
    }


    public boolean checkIfRepresentative()
    {
        if (connectedUser != null){
            return (connectedUser.getType().equals("Representative"));
        }
        else{
            return false;
        }
    }

    public Subscriber getTheUser(Document subscriber)
    {
        Document subscriberDetails = (Document) subscriber.get("subscriber");
        String id = (String)subscriberDetails.get("ID");
        String name = (String)subscriberDetails.get("name");
        String userName = (String)subscriberDetails.get("userName");
        String password = (String)subscriberDetails.get("password");
        String email = (String)subscriberDetails.get("email");
        String type = (String)subscriberDetails.get("type");
        return (new Subscriber(id, name, userName, password, email, type));
    }

    public boolean registerReferee(String fullName, String email, String training)
    {
        if (checkFullName(fullName)) {
            if (checkEmail(email)) {
                if(subscriberDAO.checkIfSubscriberExists("email",email)) {
                    logger.toLog("email " + email + " already exist");
                    return false;
                }
                else {
                    String[] splitName = fullName.split(" ");
                    String username = splitName[0] + splitName[1].charAt(0);
                    String password = "Rr" + username;
                    if (checkPassword(password)) {
                        Referee newReferee = new Referee(fullName, username, password, email, training);
                        subscriberDAO.save(newReferee.getID(), newReferee);
                        logger.toLog("DC - Mail with details sent to mail " + email);
                        logger.toLog("DC - Referee " + fullName + " registered successfully");
                        return true;
                    }
                    else{
                        logger.toLog("Invalid password");
                        return false;
                    }
                }
            }
            else
                return false;
        }
        else
            return false;
    }

    public Game getTheGame(Document game)
    {
        Document gameDetails = (Document)game.get("game");
        String gameID = (String)gameDetails.get("gameID");
        String hostTeamID = (String)gameDetails.get("hostTeamID");
        String guestTeamID = (String)gameDetails.get("guestTeamID");
        try{
            return new Game(gameID,hostTeamID,guestTeamID);
        } catch (Exception e) {
            System.out.println("Didn't succeed to create Game object");
            return null;
        }
    }

    public Team getTheTeam(Document team)
    {
        Document teamDetails = (Document) team.get("team");
        String teamID = (String)teamDetails.get("teamID");
        String name = (String)teamDetails.get("name");
        // TODO - Tamar
//        ArrayList<LocalDateTime> datesOfGames = teamDAO.getDatesOfGame(teamID);
        try{
            // newTeam.setDatesOfGames(datesOfGames);
            return new Team(teamID,name);
        } catch (Exception e) {
            System.out.println("Didn't succeed to create Team object");
            return null;
        }
    }


    public boolean gamePlacement(String gameID , LocalDateTime time, String place)
    {
        boolean gameExist = gameDAO.checkIfGameExists("gameId", gameID);
        if (gameExist){
            Document game = gameDAO.get(gameID);
            Game newGame = getTheGame(game);
            String hostTeamId = newGame.getHostTeamID();
            String guestTeamId = newGame.getGuestTeamID();
            boolean team1Exist = teamDAO.checkIfTeamExists("teamId", hostTeamId);
            if (team1Exist)
            {
                Document team1 = teamDAO.get(hostTeamId);
                Team hostTeam = getTheTeam(team1);
                boolean team2Exist = teamDAO.checkIfTeamExists("teamId", guestTeamId);
                if (team2Exist){
                    Document team2 = teamDAO.get(guestTeamId);
                    Team guestTeam = getTheTeam(team2);
                    boolean hostTeamAvailability = hostTeam.checkAvailability(time);
                    boolean guestTeamAvailability = guestTeam.checkAvailability(time);
                    if (!hostTeamAvailability || !guestTeamAvailability){
                        logger.toLog("DC - One of the teams doesn't available in this date");
                        return false;
                    }
                    else {
                        newGame.setTime(time);
                        newGame.setField(place);
                        // send update Game object to DB
                        gameDAO.update(gameID, newGame);
                        logger.toLog("DC - Game assigned successfully");
                        return true;
                    }
                }
                else{
                    logger.toLog("DC - guestTeam " + guestTeamId + " not exist");
                    return false;
                }
            }
            else{
                logger.toLog("DC - hostTeam " + hostTeamId + " not exist");
                return false;
            }
        }
        else{
            logger.toLog("DC - game " + gameID + " already exist");
            return false;
        }
    }
}
