package DataAccess;


import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class DBConnector {
    public static final String url ="mongodb://localhost:27017";

    private static final DBConnector instance = new DBConnector();
    private static CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));


    public static DBConnector getInstance()
    {
        return instance;
    }

    /**
     *
     * @return database : MongoDatabase object
     */
    public static MongoDatabase getConnection(){
        try{
            MongoClient mongoClient = new MongoClient(new MongoClientURI(url));
            MongoDatabase database = mongoClient.getDatabase("FootballSystem").withCodecRegistry(pojoCodecRegistry);

            return database;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error connecting to the db",e);
        }
    }
}
