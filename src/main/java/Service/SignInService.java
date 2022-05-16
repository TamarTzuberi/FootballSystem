package Service;
import Domain.*;

import java.time.LocalDateTime;
import java.util.*;


public class SignInService {

    //all users
    private static ArrayList<User> allUsers;

    private boolean checkFullName(String fullName)
    {
        return fullName.matches("[a-zA-Z]+");
    }
    private boolean checkEmail(String email)
    {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }
    private boolean checkPassword(String password)
    {
        return password.matches("^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}$");
    }


    //return void? or log??
    public void signInRepresentative(String fullName, String email)
    {
        if(checkFullName(fullName))
        {
            if(checkEmail(email))
            {
                //if() ****check in DB if email exist****
                String[] splitName = fullName.split(" ");
                String username = splitName[0] + splitName[1].charAt(0);
                String passwordAdmin = "Admin" + username;
                FootballAssociationRepresentative representative = new FootballAssociationRepresentative(fullName, username, passwordAdmin, email);
                //****** add to DB ******
                //****** send email with details ******
                System.out.println("The account created successfully");
                //****** write to log ******

            }
            else {
                System.out.println("not a valid email");
            }
        }
        else
        {
            System.out.println("not a valid name");
        }
    }

    //change name to register
    public void signInGuest(String fullName, String email, String username, String password)
    {
        //*** check if guest? ***
        if(checkFullName(fullName))
        {
            if(checkEmail(email))
            {
                //if() ****check in DB if user exist****
                if(checkPassword(password))
                {
                    Fan newFan = new Fan(fullName, username, password, email);
                    //****** add to DB ******
                    System.out.println("The account created successfully");
                    //****** write to log ******
                }
                else
                {
                    System.out.println("not a valid password");
                }
            }
            else {
                System.out.println("not a valid email");
            }
        }
        else
        {
            System.out.println("not a valid name");
        }
    }

    public void registerRole(String fullName, String email, String role)
    {
        //*** check who sign is representative? ***
        if(checkFullName(fullName))
        {
            if(checkEmail(email))
            {
                //if() ****check in DB if email exist****
                String[] splitName = fullName.split(" ");
                String username = splitName[0] + splitName[1].charAt(0);
                String passwordRole =  username + role;
//                if (role.equals("Coach"))
//                {
//                    Coach newCoach = new Coach(fullName, username, passwordRole, email, );
//                }
//                else if (role.equals("Referee"))
//                {
//                    Referee newReferee = new Referee(fullName, username,passwordRole, email);
//                }
//                else if (role.equals("Player"))
//                {
//                    Player newPlayer = new Player();
//                }
//                else if (role.equals("TeamManager"))
//                {
//                    TeamManager newTeamManager = new TeamManager();
//                }
//                else if (role.equals("TeamOwner"))
//                {
//                    TeamOwner newTeamOwner = new TeamOwner();
//                }
//                else
//                {
//                    System.out.println("not a valid role");
//                }
                //****** add to DB ******
                //****** send email with details ******
                System.out.println("The account created successfully");
                //****** write to log ******

            }
            else {
                System.out.println("not a valid email");
            }
        }
        else
        {
            System.out.println("not a valid name");
        }
    }

    public void login(String username, String password)
    {

    }

    public void addGame(Team hostTeam, Team GuestTeam)
    {
//        Game newGame = new Game()
    }

    public void gamePlacement(Game game, LocalDateTime time, String place)
    {

    }

    public void addFinalScore(Game game)
    {

    }


}



