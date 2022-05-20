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
//        SubscriberDAO subscriberDAO = getInstance();
//        Subscriber s = new Subscriber("bob","userBob","123","email1123");
//        subscriberDAO.save("1",s);
//        Document d = subscriberDAO.get("1");
//        System.out.println(((Document)d.get("subscriber")).get("name"));
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
}
