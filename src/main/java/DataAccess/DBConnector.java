package DataAccess;


import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DBConnector {
    public static final String url ="mongodb://localhost:27017";

    private static final DBConnector instance = new DBConnector();

    public static DBConnector getInstance()
    {
        return instance;
    }

    private DBConnector(){

    }

    public static DB getConnection(){
        try{
            MongoClient mongoClient = new MongoClient(new MongoClientURI(url));
            DB database = mongoClient.getDB("FootballSystem");
            return database;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error connecting to the db",e);
        }
    }
}
