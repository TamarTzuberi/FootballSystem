package Domain;

import org.bson.Document;

import java.time.LocalDateTime;

public class DomainController {

    private static DomainController DC;
    private Subscriber connectedUser;
    private static DataAccess.SubscriberDAO subscriberDAO;
    private static DataAccess.GameDAO gameDAO;
    private static DataAccess.TeamDAO teamDAO;
    private static Logger logger = Logger.getInstance("logs");

    private DomainController()
    {
       // connectedUser = ***get from DB and check if correct**
    }

    public static DomainController getDC()
    {
        if (DC == null)
        {
            DC = new DomainController();
        }
        return DC;
    }

    public void setConnectedUser(Subscriber curUser) {
//        DomainController.connectedUser = *****get from DB ;
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
        return (connectedUser.getType().equals("Representative"));
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
                    Referee newReferee = new Referee(fullName, username, password, email, training);
                    subscriberDAO.save(newReferee.getID(),newReferee);
                    logger.toLog("DC - Mail with details sent to mail " + email);
                    logger.toLog("DC - Referee " + fullName + " registered successfully");
                    return true;
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
        Document gameDetails = (Document) game.get("game");
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
        //get game from DB - with game id - and check if exist
//        String userId = "";
        Document game = gameDAO.get(gameID);
        if (game.equals("")){
            System.out.println("Game not exist");
            return false;
        }
        else {
            Game newGame = getTheGame(game);
            String hostTeamId = newGame.getHostTeamID();
            String guestTeamId = newGame.getGuestTeamID();
            Document team1 = teamDAO.get(hostTeamId);
            Team hostTeam = getTheTeam(team1);
            Document team2 = teamDAO.get(guestTeamId);
            Team guestTeam = getTheTeam(team2);
            boolean hostTeamAvailability = hostTeam.checkAvailability(time);
            boolean guestTeamAvailability = guestTeam.checkAvailability(time);
            if (!hostTeamAvailability || !guestTeamAvailability){
                System.out.println("One of the teams doesn't available in this date");
                return false;
            }
            else {
                newGame.setTime(time);
                newGame.setField(place);
                // send update Game object to DB
                gameDAO.update(newGame);
                logger.toLog("DC - Game assigned successfully");
                System.out.println("Game assigned successfully");
                return true;
            }
        }
    }

        //create  Team 1 from DB
        //create Team 2 from DB
        //create Game with 2 teams
        //check availability of Team 1 in specific date (by list DatesOfGames) from DB
        //check availability of Team 2 in specific date (by list DatesOfGames) from DB
        //if true, set values of date, time, Team 1, Team 2, place on Game object
        //send update Game object to DB



    }

//        Date dateOfBirth = new Date();
//        Player player0 = new Player("player0","player0", "player0", "player0", "player0@gmail.com", dateOfBirth, "player");
//        Player player1 = new Player("player1","player1", "player1", "player1", "player1@gmail.com", dateOfBirth, "player");
//        Player player2 = new Player("player2", "player2","player2", "player2", "player2@gmail.com", dateOfBirth, "player");
//        Coach coach0 = new Coach("coach0","coach0", "coach0", "coach0", "coach0@gmail.com", "basic", "coach");
//        Coach coach1 = new Coach("coach1","coach1", "coach1", "coach1", "coach1@gmail.com", "basic", "coach");
//        ArrayList<Player> playersHosted = new ArrayList<>();
//        playersHosted.add(player0);
//        playersHosted.add(player1);
//        playersHosted.add(player2);
//        ArrayList<Coach> coachesHosted = new ArrayList<>();
//        coachesHosted.add(coach0);
//        coachesHosted.add(coach1);
//        ArrayList<TeamOwner> ownersHosted = new ArrayList<>();
//        Team hostedTeam = new Team("team0","team0",playersHosted,coachesHosted, ownersHosted);
//        player0.setTeam(hostedTeam);
//        player1.setTeam(hostedTeam);
//        player2.setTeam(hostedTeam);
//        coach0.setTeam(hostedTeam);
//        coach1.setTeam(hostedTeam);
//
//
//        Player player3 = new Player("player3","player3", "player3", "player3", "player3@gmail.com", dateOfBirth, "player");
//        Player player4 = new Player("player4","player4", "player4", "player4", "player4@gmail.com", dateOfBirth, "player");
//        Player player5 = new Player("player5", "player5","player5", "player5", "player5@gmail.com", dateOfBirth, "player");
//        Coach coach2 = new Coach("coach2","coach2", "coach2", "coach2", "coach2@gmail.com", "basic", "coach");
//        Coach coach3 = new Coach("coach3","coach3", "coach3", "coach3", "coach3@gmail.com", "basic", "coach");
//        ArrayList<Player> playersGuest = new ArrayList<>();
//        playersGuest.add(player3);
//        playersGuest.add(player4);
//        playersGuest.add(player5);
//        ArrayList<Coach> coachesGuest = new ArrayList<>();
//        coachesGuest.add(coach2);
//        coachesGuest.add(coach3);
//        ArrayList<TeamOwner> ownersGuest = new ArrayList<>();
//        Team guestTeam = new Team("team1","team1",playersGuest,coachesGuest, ownersGuest);
//        player3.setTeam(guestTeam);
//        player4.setTeam(guestTeam);
//        player5.setTeam(guestTeam);
//        coach2.setTeam(guestTeam);
//        coach3.setTeam(guestTeam);
//        Game game1 = new Game("game1", hostedTeam, guestTeam);
//
//        if(guestTeam.checkAvailability(time) && hostedTeam.checkAvailability(time))
//        {
//            game1.gamePlacement(time, place);
//        }
//
//        guestTeam.addGameTime(time);
//        hostedTeam.addGameTime(time);
//        //update DB with game, team1 team2
//
//