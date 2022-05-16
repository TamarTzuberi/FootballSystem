package DataAccess;
import com.mongodb.*;
import com.mongodb.DB;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;


public class DateAccessController {

    private static final DateAccessController instance = new DateAccessController();
    static DBConnector dbc = DBConnector.getInstance();
    static DB database = dbc.getConnection();

    public static DateAccessController getInstance(){
        return instance;
    }

    public static void main(String[] args) throws UnknownHostException {


    }

    private DateAccessController() {

    }


    public DBCollection getDBCollection (String collectionName)
    {
        try{
            DBCollection dbCollection =  database.getCollection(collectionName);
            return dbCollection;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error getting the collection",e);
        }
    }

    public String getRecordFromDB(String collectionName, String key, String val)
    {
        try {
            DBCollection dbCollection = (DBCollection) getDBCollection(collectionName);
            DBObject q = new BasicDBObject(key, val);
            DBCursor c = dbCollection.find(q);
            DBObject theObj = c.next();
            String result = theObj.toString();
            return result;
        }
        catch (Exception e)
        {
            throw new RuntimeException("id does not exists in DB",e);
        }
    }

    public void insertPlayerToDB(String collectionName , String id , String name, String userName, String password, String email, String teamID )
    {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("_id", id);
        dbObject.put("name", name);
        dbObject.put("userName", userName);
        dbObject.put("password", password);
        dbObject.put("email", email);
        dbObject.put("teamID", teamID);
        getDBCollection(collectionName).insert(dbObject);
    }

    public void insertTeamToDB(String collectionName , String id , String name, ArrayList<String> players, ArrayList<String>coaches, ArrayList<String>teamOwners, ArrayList<Date>datesOfGames)
    {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("_id", id);
        dbObject.put("name", name);
        dbObject.put("players", players);
        dbObject.put("coaches", coaches);
        dbObject.put("teamOwners", teamOwners);
        dbObject.put("datesOfGames", datesOfGames);
        getDBCollection(collectionName).insert(dbObject);
    }

    public void insertGameToDB(String collectionName , String id , String time, String hostTeamId, String guestTeamId, String field)
    {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("_id", id);
        dbObject.put("time", time);
        dbObject.put("hostTeamId", hostTeamId);
        dbObject.put("guestTeamId", guestTeamId);
        dbObject.put("field", field);
        getDBCollection(collectionName).insert(dbObject);
    }

    public void insertSeasonToDB(String collectionName , String id , Date startDate, Date endDate, ArrayList<String> LeaguesInSeason)
    {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("_id", id);
        dbObject.put("startDate", startDate);
        dbObject.put("endDate", endDate);
        dbObject.put("LeaguesInSeason", LeaguesInSeason);
        getDBCollection(collectionName).insert(dbObject);
    }
    public void insertLeagueToDB(String collectionName , String id , String name, ArrayList<String> teams, ArrayList<String> leagues)
    {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("_id", id);
        dbObject.put("startDate", name);
        dbObject.put("endDate", teams);
        dbObject.put("LeaguesInSeason", leagues);
        getDBCollection(collectionName).insert(dbObject);
    }

    public boolean checkIfIDExistsInDB(String collectionName,String id)
    {
        try{
            getRecordFromDB(collectionName,"_id",id);
            return true;
        }
        catch (Exception e)
        {
            return  false;
        }
    }

    public boolean checkIfUserNameExists(String userName)
    {
        try {
            DBCollection dbCollection = (DBCollection) getDBCollection("User");
            DBObject q = new BasicDBObject("userName", userName);
            DBCursor c = dbCollection.find(q);
            DBObject theObj = c.next();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
}
