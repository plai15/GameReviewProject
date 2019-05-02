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

        MongoClient mongoClient = new MongoClient("pkcluster-ok2q6.mongodb.net");
        MongoDatabase database = mongoClient.getDatabase("GameReview" );
        MongoCollection<Document> Login = database.getCollection("Login");

        Document loginDoc = new Document("username", "brandon")
                .append("password", "1234");


        Login.insertOne(loginDoc);
       




    }//end main
}//end class

