package DataAccess;

import Domain.Game;
import Domain.Subscriber;
import Domain.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


    public void update(String id,Object game){
        MongoCollection collection=database.getCollection("games");
        Bson globalFilter = Filters.eq("_id", id);
        Document newGame = new Document("game",game);
        collection.replaceOne(globalFilter,newGame);
    }

    public boolean checkIfGameExists(String key, String value)
    {
        try{
            MongoCollection collection=database.getCollection("games");
            List<Document> results = new ArrayList<>();
            FindIterable<Document> iterable = collection.find();
            iterable.into(results);
            for(int i=0; i<results.size();i++)
            {
                Document d = results.get(i);
                Document gameD =(Document)d.get("game");
                String valFromDoc = (String)gameD.get(key);
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
    public void clearCollection() {
        MongoCollection collection = database.getCollection("games");
        collection.drop();
    }

    // TODO - Tamar
    public void clearObject(String gameId){

    }


}
