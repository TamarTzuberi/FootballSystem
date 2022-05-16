package Domain;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class DomainController {

    private static User connectedUser;
    private static DomainController DC;
    private static DataAccess.DateAccessController DAC;

    private DomainController(String username, String password)
    {
       // connectedUser = ***get from DB and check if correct****
    }


    public static DomainController getDC(String username, String pass)
    {
        if (DC == null)
        {
            DC = new DomainController(username, pass);
        }
        return DC;
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

    public void login(String username, String password)
    {

        //check if username exist in DB
        boolean userExists = DAC.checkIfUserNameExists(username);
        //check if password correct
        //connected user
    }

    public boolean registerReferee(String fullName, String email, String training)
    {
        if (checkFullName(fullName)) {
            if (checkEmail(email)) {
                //if() ****check in DB if email exist**** in data layer

                String[] splitName = fullName.split(" ");
                String username = splitName[0] + splitName[1].charAt(0);
                String password = username + "Referee";
                Referee newReferee = new Referee(fullName, username, password, email, training);
                //add to DB - send string - username:Stav, password:pass, Name:Stav Keidar ***send id from getID
                //send mail to referee
                //write in log
                System.out.println("register successful");
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public boolean gamePlacement(String gameID , LocalDateTime time, String place)
    {
        Date dateOfBirth = new Date("01/01/01");
        Player player0 = new Player("player0", "player0", "player0", "player0@gmail.com", dateOfBirth, "player");
        Player player1 = new Player("player1", "player1", "player1", "player1@gmail.com", dateOfBirth, "player");
        Player player2 = new Player("player2", "player2", "player2", "player2@gmail.com", dateOfBirth, "player");
        Coach coach0 = new Coach("coach0", "coach0", "coach0", "coach0@gmail.com", "basic", "coach");
        Coach coach1 = new Coach("coach1", "coach1", "coach1", "coach1@gmail.com", "basic", "coach");
        ArrayList<Player> playersHosted = new ArrayList<>();
        playersHosted.add(player0);
        playersHosted.add(player1);
        playersHosted.add(player2);
        ArrayList<Coach> coachesHosted = new ArrayList<>();
        coachesHosted.add(coach0);
        coachesHosted.add(coach1);
        ArrayList<TeamOwner> ownersHosted = new ArrayList<>();
        Team hostedTeam = new Team("team0",playersHosted,coachesHosted, ownersHosted);
        player0.setTeam(hostedTeam);
        player1.setTeam(hostedTeam);
        player2.setTeam(hostedTeam);
        coach0.setTeam(hostedTeam);
        coach1.setTeam(hostedTeam);


        Player player3 = new Player("player3", "player3", "player3", "player3@gmail.com", dateOfBirth, "player");
        Player player4 = new Player("player4", "player4", "player4", "player4@gmail.com", dateOfBirth, "player");
        Player player5 = new Player("player5", "player5", "player5", "player5@gmail.com", dateOfBirth, "player");
        Coach coach2 = new Coach("coach2", "coach2", "coach2", "coach2@gmail.com", "basic", "coach");
        Coach coach3 = new Coach("coach3", "coach3", "coach3", "coach3@gmail.com", "basic", "coach");
        ArrayList<Player> playersGuest = new ArrayList<>();
        playersGuest.add(player3);
        playersGuest.add(player4);
        playersGuest.add(player5);
        ArrayList<Coach> coachesGuest = new ArrayList<>();
        coachesGuest.add(coach2);
        coachesGuest.add(coach3);
        ArrayList<TeamOwner> ownersGuest = new ArrayList<>();
        Team guestTeam = new Team("team1",playersGuest,coachesGuest, ownersGuest);
        player3.setTeam(guestTeam);
        player4.setTeam(guestTeam);
        player5.setTeam(guestTeam);
        coach2.setTeam(guestTeam);
        coach3.setTeam(guestTeam);
        Game game1 = new Game(hostedTeam, guestTeam);

        if(guestTeam.checkAvailability(time) && hostedTeam.checkAvailability(time))
        {
            game1.gamePlacement(time, place);
        }

        guestTeam.addGameTime(time);
        hostedTeam.addGameTime(time);
        //update DB with game, team1 team2



        //get game from DB - with game id - and check if exist
        //create  Team 1 from DB
        //create Team 2 from DB
        //create Game with 2 teams
        //check availability of Team 1 in specific date (by list DatesOfGames) from DB
        //check availability of Team 2 in specific date (by list DatesOfGames) from DB
        //if true, set values of date, time, Team 1, Team 2, place on Game object
        //send update Game object to DB

        return true;


    }
}
