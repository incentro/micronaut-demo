package movie.list.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.micronaut.context.annotation.Value;
import org.bson.Document;

import javax.inject.Singleton;

@Singleton
public class DbConn {

    @Value("${mongodb.ip}")
    String mongoIp;

    @Value("${mongodb.port}")
    Integer mongoPort;

    @Value("${mongodb.db}")
    String mongoDb;

    @Value("${mongodb.collection}")
    String mongoColl;

    MongoClient mongoClient;
    MongoDatabase database;

    public MongoCollection<Document> getCollection() {
        mongoClient = new MongoClient(mongoIp, mongoPort);
        database = mongoClient.getDatabase(mongoDb);
        return database.getCollection(mongoColl);
    }
}
