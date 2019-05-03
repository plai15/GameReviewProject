
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tv8392uu
 */
public class MongoConnection {
            MongoClient mongo = new MongoClient(); 
            MongoDatabase database = mongo.getDatabase("GameReview");
}
