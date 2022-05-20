//package DataAccess;
//import Domain.Game;
//import Domain.Page;
//import com.mongodb.*;
//import com.mongodb.DB;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//
//
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.Date;
//
//
//public class DateAccessController {
//
//    private static final DateAccessController instance = new DateAccessController();
//    static DBConnector dbc = DBConnector.getInstance();
//    static MongoDatabase database = dbc.getConnection();
//
//
//    public static DateAccessController getInstance(){
//        return instance;
//    }
//
//    public static void main(String[] args) {
//        ArrayList<String> l = new ArrayList<>();
//        l.add("1");
//        l.add("4");
//        Page p = new Page(3,"Liron",l);
//        DateAccessController d = getInstance();
//        d.insertPageToDB("3",p);
//
////
////        ArrayList<String> players0 = new ArrayList<>();
////        players0.add("player0");
////        players0.add("player1");
////        players0.add("player2");
////        ArrayList<String> coaches0 = new ArrayList<>();
////        coaches0.add("coach0");
////        ArrayList<String> teamOwner0 = new ArrayList<>();
////        coaches0.add("teamOwner0");
////        ArrayList<Date> dates0 = new ArrayList<>();
////        Date date0 = new Date("03/01/97");
////        dates0.add(date0);
////        instance.insertTeamToDB("Team", "team0", "macabi tel aviv",players0,coaches0,teamOwner0,dates0);
////
////        ArrayList<String> players1 = new ArrayList<>();
////        players1.add("player3");
////        players1.add("player4");
////        players1.add("player5");
////        ArrayList<String> coaches1 = new ArrayList<>();
////        coaches1.add("coach1");
////        ArrayList<String> teamOwner1 = new ArrayList<>();
////        coaches1.add("teamOwner1");
////        ArrayList<Date> dates1 = new ArrayList<>();
////        Date date1 = new Date("04/01/97");
////        dates1.add(date1);
////        instance.insertTeamToDB("Team", "team1", "hapoel tel aviv",players1,coaches1,teamOwner1,dates1);
////
////        ArrayList<String> players2 = new ArrayList<>();
////        players2.add("player6");
////        players2.add("player7");
////        players2.add("player8");
////        ArrayList<String> coaches2 = new ArrayList<>();
////        coaches2.add("coach2");
////        ArrayList<String> teamOwner2 = new ArrayList<>();
////        coaches2.add("teamOwner2");
////        ArrayList<Date> dates2 = new ArrayList<>();
////        Date date2 = new Date("05/01/97");
////        dates1.add(date2);
////        instance.insertTeamToDB("Team", "team2", "macabi haifa",players2,coaches2,teamOwner2,dates2);
////
////        ArrayList<String> players3 = new ArrayList<>();
////        players3.add("player9");
////        players3.add("player10");
////        players3.add("player11");
////        ArrayList<String> coaches3 = new ArrayList<>();
////        coaches3.add("coach3");
////        ArrayList<String> teamOwner3 = new ArrayList<>();
////        coaches3.add("teamOwner3");
////        ArrayList<Date> dates3 = new ArrayList<>();
////        Date date3 = new Date("06/01/97");
////        dates1.add(date3);
////        instance.insertTeamToDB("Team", "team3", "hapoel haifa",players3,coaches3,teamOwner3,dates3);
////
////        instance.insertGameToDB("Game","game0","team0","team1");
////        instance.insertGameToDB("Game","game1","team1","team2");
////        instance.insertGameToDB("Game","game2","team2","team3");
////
////        ArrayList<String> leagueInSeason = new ArrayList<>();
////        leagueInSeason.add("leagueInSeason0");
////        ArrayList<String> teams = new ArrayList<>();
////        teams.add("team0");
////        teams.add("team1");
////        instance.insertLeagueToDB("League","league0","Super League",teams,leagueInSeason);
////
////
////        Date startDate = new Date("10/05/22");
////        Date endDate = new Date("14/05/22");
////
////        instance.insertSeasonToDB("Season","season0",startDate,endDate,leagueInSeason);
//
//    }
//
//    private DateAccessController() {
//
//    }
//
//
//    public MongoCollection getDBCollection (String collectionName)
//    {
//        try{
//            MongoCollection dbCollection = database.getCollection(collectionName);
//            return dbCollection;
//        }
//        catch (Exception e)
//        {
//            throw new RuntimeException("Error getting the collection",e);
//        }
//    }
//
//    public String getRecordFromDB(String collectionName, String key, String val)
//    {
//        try {
//            DBCollection dbCollection = (DBCollection) getDBCollection(collectionName);
//            DBObject q = new BasicDBObject(key, val);
//            DBCursor c = dbCollection.find(q);
//            DBObject theObj = c.next();
//            String result = theObj.toString();
//            return result;
//        }
//        catch (Exception e)
//        {
//            throw new RuntimeException("id does not exists in DB",e);
//        }
//    }
//
//    public void insertPlayerToDB(String collectionName , String id , String name, String userName, String password, String email, String teamID )
//    {
//        DBObject dbObject = new BasicDBObject();
//        dbObject.put("_id", id);
//        dbObject.put("name", name);
//        dbObject.put("userName", userName);
//        dbObject.put("password", password);
//        dbObject.put("email", email);
//        dbObject.put("teamID", teamID);
//        getDBCollection(collectionName).insertOne(dbObject);
//    }
//
//    public void insertPageToDB(String id,Object page)
//    {
//        Document d =  new Document("_id",id).append("page",page);
//        getDBCollection("pages").insertOne(d);
//    }
//
////    public void insertTeamToDB(String collectionName , String id , String name, ArrayList<String> players, ArrayList<String>coaches, ArrayList<String>teamOwners, ArrayList<Date>datesOfGames)
////    {
////        DBObject dbObject = new BasicDBObject();
////        dbObject.put("_id", id);
////        dbObject.put("name", name);
////        dbObject.put("players", players);
////        dbObject.put("coaches", coaches);
////        dbObject.put("teamOwners", teamOwners);
////        dbObject.put("datesOfGames", datesOfGames);
//////        getDBCollection(collectionName).insert(dbObject);
////    }
////
////    public void insertGameToDB(String collectionName , String id , String hostTeamId, String guestTeamId)
////    {
////        DBObject dbObject = new BasicDBObject();
////        dbObject.put("_id", id);
////        dbObject.put("hostTeamId", hostTeamId);
////        dbObject.put("guestTeamId", guestTeamId);
//////        getDBCollection(collectionName).insert(dbObject);
////    }
////
////    public void insertSeasonToDB(String collectionName , String id , Date startDate, Date endDate, ArrayList<String> LeaguesInSeason)
////    {
////        DBObject dbObject = new BasicDBObject();
////        dbObject.put("_id", id);
////        dbObject.put("startDate", startDate);
////        dbObject.put("endDate", endDate);
////        dbObject.put("LeaguesInSeason", LeaguesInSeason);
////        getDBCollection(collectionName).insert(dbObject);
////    }
////    public void insertLeagueToDB(String collectionName , String id , String name, ArrayList<String> teams, ArrayList<String> LeaguesInSeason)
////    {
////        DBObject dbObject = new BasicDBObject();
////        dbObject.put("_id", id);
////        dbObject.put("startDate", name);
////        dbObject.put("endDate", teams);
////        dbObject.put("LeaguesInSeason", LeaguesInSeason);
////        getDBCollection(collectionName).insert(dbObject);
////    }
////
////    public boolean checkIfIDExistsInDB(String collectionName,String id)
////    {
////        try{
////            getRecordFromDB(collectionName,"_id",id);
////            return true;
////        }
////        catch (Exception e)
////        {
////            return  false;
////        }
////    }
////
////    public boolean checkIfUserNameExists(String userName)
////    {
////        try {
////            DBCollection dbCollection = (DBCollection) getDBCollection("User");
////            DBObject q = new BasicDBObject("userName", userName);
////            DBCursor c = dbCollection.find(q);
////            DBObject theObj = c.next();
////            return true;
////        }
////        catch (Exception e)
////        {
////            return false;
////        }
////
////    }
//}
