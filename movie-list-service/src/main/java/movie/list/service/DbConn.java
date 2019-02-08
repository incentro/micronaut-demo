package movie.list.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.micronaut.context.annotation.Property;
import org.bson.Document;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class DbConn {

    @Property(name = "mongodb")
    Map<String, String> mongoProps;

    MongoClient mongoClient;
    MongoDatabase database;

    public MongoCollection<Document> getCollection() {
        mongoClient = new MongoClient(mongoProps.get("ip"), Integer.parseInt(mongoProps.get("port")));
        database = mongoClient.getDatabase(mongoProps.get("db"));
        return database.getCollection(mongoProps.get("collection"));
    }
}
