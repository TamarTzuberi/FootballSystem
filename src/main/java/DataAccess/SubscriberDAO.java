package DataAccess;

import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class SubscriberDAO implements DAO {
    private static final SubscriberDAO instance = new SubscriberDAO();
    static DBConnector dbc = DBConnector.getInstance();
    static MongoDatabase database = dbc.getConnection();

    public static SubscriberDAO getInstance(){
        return instance;
    }


    public static void main(String[] args) {
        getInstance().clearCollection();
    }

    /**
     *
     * @param id : String of id of the object
     * @param subscriber : Object to set in DB
     */
    @Override
    public void save(String id, Object subscriber) {
        Document newUser =  new Document("_id",id).append("subscriber",subscriber);
        database.getCollection("subscribers").insertOne(newUser);
    }
    /**
     *
     * @param id : String of id of the object
     * @return Document with all the details of the object in DB
     */
    @Override
    public Document get(String id) {
        MongoCollection collection=database.getCollection("subscribers");
        Document  d = (Document) collection.find(eq("_id", id)).first();
        return d;
    }

    /**
     *
     * @param key : String of the field
     * @param value : String of the value to check if exist in DB
     * @return Boolean : true if value already exist, else false
     */
    public boolean checkIfSubscriberExists(String key, String value)
    {
        try{
            MongoCollection collection=database.getCollection("subscribers");
            List<Document> results = new ArrayList<>();
            FindIterable<Document> iterable = collection.find();
            iterable.into(results);
            for(int i=0; i<results.size();i++)
            {
                Document d = results.get(i);
                Document subscriberD =(Document)d.get("subscriber");
                String  valFromDoc = (String)subscriberD.get(key);
                if(valFromDoc.equals(value))
                    return true;
            }
        return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     *
     * @param username : String of user name to check if exists in DB and to return the id of him
     * @return String id if the user name exist, else return null
     */
    public String getIdByUsername(String username)
    {
        try{
            MongoCollection collection=database.getCollection("subscribers");
            List<Document> results = new ArrayList<>();
            FindIterable<Document> iterable = collection.find();
            iterable.into(results);
            for(int i=0; i<results.size();i++)
            {
                Document d = results.get(i);
                Document subscriberD =(Document)d.get("subscriber");
                String  valFromDoc = (String)subscriberD.get("userName");
                if(valFromDoc.equals(username))
                    return (String)d.get("_id");
            }
            return null;
        }
        catch (Exception e)
        {
            return null;
        }
    }
    /**
     * Clear the collection in the DB
     */
    public void clearCollection() {
        MongoCollection collection = database.getCollection("subscribers");
        collection.drop();
        }


}
