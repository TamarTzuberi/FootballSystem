package DataAccess;
import com.mongodb.*;
import com.mongodb.util.JSON;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.bson.types.ObjectId;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;


public class MongoDB{

    private static final MongoDB instance = new MongoDB();
    static DBConnector dbc = DBConnector.getInstance();
    static DB database = dbc.getConnection();

    public static MongoDB getInstance(){
        return instance;
    }

    public static void main(String[] args) throws UnknownHostException {
//        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
//        database = mongoClient.getDB("FootballSystem");
//        test = database.getCollection("test");
//        Fan f = new Fan();
//        f.setName("bob");
//        f.setAge(22);
//        test.insert(convert(f));
//        DBObject q = new BasicDBObject("Fan Name","bob");
//        DBCursor c = test.find(q);
//        System.out.println(c.one());



//        insertDB("test");
//        DBCursor c = getObject("test","_id","2");
//        System.out.println(c.one());
//        DBObject theObj = c.next();
//        BasicDBList checkL = (BasicDBList) theObj.get("key");
//        System.out.println(checkL);
//        ArrayList<String> p = new ArrayList<>();
//        p.add("danP");
//        p.add("itay");
//
////        inserTeamToDB("test","253333","t1",p,p,p,null);
//        System.out.println("this is player" + (getById("test","253333")));

    }

    private MongoDB() {

    }


    public static DBCollection getDBCollection (String collectionName)
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

    public static String getById(String collectionName, String id)
    {
        DBCollection dbCollection = (DBCollection) getDBCollection(collectionName);
        DBObject q = new BasicDBObject("_id",id);
        DBCursor c = dbCollection.find(q);
        DBObject theObj = c.next();
        String result = theObj.toString();

        return result;
    }

    public static void insertPlayerToDB(String collectionName , String id , String name, String userName, String password, String email, String teamID )
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

    public static void inserTeamToDB(String collectionName , String id , String name, ArrayList<String>players, ArrayList<String>coaches, ArrayList<String>teamOwners, ArrayList<Date>datesOfGames)
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

    public static void inserGameToDB(String collectionName , String id , String time, String hostTeamId, String guestTeamId, String field)
    {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("_id", id);
        dbObject.put("time", time);
        dbObject.put("hostTeamId", hostTeamId);
        dbObject.put("guestTeamId", guestTeamId);
        dbObject.put("field", field);
        getDBCollection(collectionName).insert(dbObject);
    }

}
