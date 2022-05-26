package DataAccess;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class TeamDAO implements DAO{
    private static final TeamDAO instance = new TeamDAO();
    static DBConnector dbc = DBConnector.getInstance();
    static MongoDatabase database = dbc.getConnection();


    public static TeamDAO getInstance(){
        return instance;
    }


    /**
     *
     * @param id : String of id of the object
     * @param team : Object to set in DB
     */
    @Override
    public void save(String id, Object team) {
        Document newTeam =  new Document("_id",id).append("team",team);
        database.getCollection("teams").insertOne(newTeam);
    }


    /**
     *
     * @param id : String of id of the object
     * @return Document with all the details of the object in DB
     */
    @Override
    public Document get(String id) {
        MongoCollection collection=database.getCollection("teams");
        Document  d = (Document) collection.find(eq("_id", id)).first();
        return d;
    }

    public void update(String id,Object game){
        MongoCollection collection=database.getCollection("teams");
        Bson globalFilter = Filters.eq("_id", id);
        Document newTeam = new Document("team",game);
        collection.replaceOne(globalFilter,newTeam);
    }


    /**
     *
     * @param key : String of the field
     * @param value : String of the value to check if exist in DB
     * @return Boolean : true if value already exist, else false
     */
    public boolean checkIfTeamExists(String key, String value)
    {
        try{
            MongoCollection collection=database.getCollection("teams");
            List<Document> results = new ArrayList<>();
            FindIterable<Document> iterable = collection.find();
            iterable.into(results);
            for(int i=0; i<results.size();i++)
            {
                Document d = results.get(i);
                Document teamD =(Document)d.get("team");
                String  valFromDoc = (String)teamD.get(key);
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
     * Clear the collection in the DB
     */
    public void clearCollection() {
        MongoCollection collection = database.getCollection("teams");
        collection.drop();
    }


}
