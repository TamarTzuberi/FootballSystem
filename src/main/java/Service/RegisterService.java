//package Service;
//
//import Domain.*;
//
//import java.time.LocalDateTime;
//
//public class RegisterService {
//
////    private boolean checkFullName(String fullName)
////    {
////        return fullName.matches("[a-zA-Z]+");
////    }
////    private boolean checkEmail(String email)
////    {
////        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
////    }
////    private boolean checkPassword(String password)
////    {
////        return password.matches("^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}$");
////    }
////
////    public void register(String fullName, String email, String username, String password)
////    {
////        //*** check if guest? ***
////        if(checkFullName(fullName))
////        {
////            if(checkE mail(email))
////            {
////                //if() ****check in DB if user exist****
////                if(checkPassword(password))
////                {
////                    Fan newFan = new Fan(fullName, username, password, email);
////                    //****** add to DB ******
////                    System.out.println("The account created successfully");
////                    //****** write to log ******
////                }
////                else
////                {
////                    System.out.println("not a valid password");
////                }
////            }
////            else {
////                System.out.println("not a valid email");
////            }
////        }
////        else
////        {
////            System.out.println("not a valid name");
////        }
////    }
//
////    public DomainController login(String username, String password)
////    {
//////        DomainController dc = DomainController.getDC(username, password);
////        return dc;
////    }
//
//    public void registerReferee(String repUsername, String repPass, String fullName, String email, String training)
//    {
////        check if the connected user is Representative ?? in domain controller
//        DomainController dc = DomainController.getDC();
//        boolean ifUserExist = dc.login(repUsername, repPass);
//
//        //create new domain controller with user
//        boolean success = dc.registerReferee(fullName, email, training);
//    }
//
//    public void gamePlacement(String hostTeam, String guestTeam, LocalDateTime time, String place)
//    {
//
//
//        //check if the connected user is Representative
////        boolean success = DomainController.
//    }
//
//
//
//
//}
