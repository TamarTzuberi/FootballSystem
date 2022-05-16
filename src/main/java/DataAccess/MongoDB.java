package DataAccess;
import Domain.Fan;
import com.mongodb.*;
import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.net.UnknownHostException;


public class MongoDB {
    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection test;
    public static void main(String[] args) throws UnknownHostException {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("FootballSystem");
        test = database.getCollection("test");
        Fan f = new Fan();
        f.setName("bob");
        f.setAge(22);
        test.insert(convert(f));
        DBObject q = new BasicDBObject("Fan Name","bob");
        DBCursor c = test.find(q);
        System.out.println(c.one());



    }

    public static DBObject convert(Fan fan){
        return new BasicDBObject("Fan Name",fan.getName()).append("Age",fan.getAge());

    }

}
