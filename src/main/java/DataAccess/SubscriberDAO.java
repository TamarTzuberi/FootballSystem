package DataAccess;

import Domain.Subscriber;
import Domain.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

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
//        System.out.println(getInstance().checkIfSubscriberExists("userBob"));

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

//    public boolean checkIfSubscriberExists(String userName)
//    {
//        try{
//            MongoCollection collection=database.getCollection("subscribers");
//            Document  d = (Document) collection.find(eq("_id", "1")).first();
//            return true;
//        }
//        catch (Exception e)
//        {
//            return false;
//        }
//    }
}
