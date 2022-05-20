package DataAccess;

import Domain.Subscriber;
import Domain.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;
public class GameDAO implements DAO {
    private static final GameDAO instance = new GameDAO();
    static DBConnector dbc = DBConnector.getInstance();
    static MongoDatabase database = dbc.getConnection();

    private GameDAO(){

    }

    public static GameDAO getInstance(){
        return instance;
    }

    @Override
    public void save(String id, Object game) {
        Document newGame =  new Document("_id",id).append("game",game);
        database.getCollection("games").insertOne(newGame);
    }

    @Override
    public Document get(String id) {
        MongoCollection collection=database.getCollection("games");
        Document  d = (Document) collection.find(eq("_id", id)).first();
        return d;
    }
}
