package DataAccess;
import Domain.Fan;
import com.mongodb.*;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;


public class MongoDB {

    private static final MongoDB instance = new MongoDB();

    public static MongoDB getInstance(){
        return instance;
    }

    private MongoDB() {
        // users.add(new User("John", "john@domain.com"));
        //users.add(new User("Susan", "susan@domain.com"));
    }
    DBConnector dbc = DBConnector.getInstance();
    DB database = dbc.getConnection();

    public DBCollection getDBCollection (String collectionName)
    {
        try{
            DBCollection dbCollection = database.getCollection(collectionName);
            return dbCollection;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error getting the collection",e);
        }
    }

    public DBCursor getObject(String collectionName, String key, String value)
    {
        DBCollection dbCollection = getDBCollection(collectionName);
        DBObject q = new BasicDBObject(key,value);
        DBCursor c = dbCollection.find(q);
        return c;
    }

//    public void insertDB()
//    {
//        Fan f = new Fan();
//        f.setName("bob");
//        f.setAge(22);
//        test.insert(convert(f));
//    }
//
//    public static DB database;
//    public static DBCollection test;
    public static void main(String[] args) throws UnknownHostException {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("FootballSystem");
        test = database.getCollection("test");
//        Fan f = new Fan();
//        f.setName("bob");
//        f.setAge(22);
//        test.insert(convert(f));
        DBObject q = new BasicDBObject("Fan Name","bob");
        DBCursor c = test.find(q);
        System.out.println(c.one());



    }

//    public static DBObject convert(Fan fan){
//        return new BasicDBObject("Fan Name",fan.getName()).append("Age",fan.getAge());

//    }

}
