
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Assignment: Final Project
 * Author: Brandon Salmon and PK Lai
 * Description: Class for handling connecting to the Mongo database
 */
public class MongoConnection {
            MongoClient mongo = new MongoClient(); 
            MongoDatabase database = mongo.getDatabase("GameReview");
}
