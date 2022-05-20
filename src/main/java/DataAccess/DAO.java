package DataAccess;

import org.bson.Document;

public interface DAO {
    void save(String id, Object obj);
    Document get(String id);

}
