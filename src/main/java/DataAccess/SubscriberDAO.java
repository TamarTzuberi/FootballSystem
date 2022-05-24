package DataAccess;

import Domain.Subscriber;
import Domain.User;
import com.mongodb.Cursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.print.Doc;

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

    private SubscriberDAO(){

    }

    public static void main(String[] args) {
        System.out.println(getInstance().getIdByUsername("userBob"));


    }


    @Override
    public void save(String id, Object subscriber) {
        Document newUser =  new Document("_id",id).append("subscriber",subscriber);
        database.getCollection("subscribers").insertOne(newUser);
    }

    @Override
    public Document get(String id) {
        MongoCollection collection=database.getCollection("subscribers");
        Document  d = (Document) collection.find(eq("_id", id)).first();
        return d;
    }

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

}
