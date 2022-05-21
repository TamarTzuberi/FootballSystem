package DataAccess;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class TeamDAO implements DAO{
    private static final TeamDAO instance = new TeamDAO();
    static DBConnector dbc = DBConnector.getInstance();
    static MongoDatabase database = dbc.getConnection();

    private TeamDAO(){

    }

    public static TeamDAO getInstance(){
        return instance;
    }

    @Override
    public void save(String id, Object team) {
        Document newTeam =  new Document("_id",id).append("team",team);
        database.getCollection("teams").insertOne(newTeam);
    }

    @Override
    public Document get(String id) {
        MongoCollection collection=database.getCollection("teams");
        Document  d = (Document) collection.find(eq("_id", id)).first();
        return d;
    }

//    public ArrayList<LocalDateTime> getDatesOfGame(String teamID){
//        ArrayList<LocalDateTime> arr = new ArrayList<>();
//        return arr;
//    }
}
