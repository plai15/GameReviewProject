import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class GameReView {

    public static void  main(String[] args) {

        MongoClient mongo = new MongoClient(); 
        MongoDatabase database = mongo.getDatabase("Game");   
        MongoCollection<org.bson.Document> coll = database.getCollection("VideoGame");
        
        org.bson.Document loginDoc = new org.bson.Document("Name", "brandon")
                .append("Developer", "1234");

        coll.insertOne(loginDoc);
       




    }//end main
}//end class

