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

        MongoClient mongoClient = new MongoClient(pkcluster-ok2q6.mongodb.net);

        MongoDatabase database = mongoClient.getDatabase("GameReview" );
        MongoCollection<Document> Login = database.getCollection("Login");
        MongoCollection<Document> Tag = database.getCollection("Tag");



        Document loginDoc = new Document("username", "admin")
                .append("password", "gong123");


        Login.insertOne(loginDoc);
       

        //update Beef Pho Soup to Pho Soup Combo
        entree.updateOne(eq("name", "Beef Noodle Soup"),
                new Document("$set", new Document("name", "Pho Soup Combo")));

        //update Fried Banana to Fried Tri-Color
        drinks.updateOne(eq("name", "Fried Banana"),
                new Document("$set", new Document("name", "Fried Tri-Color")));

        //find and print all items from the drinks collection
        MongoCursor<Document> cursor = drinks.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        System.out.println(cursor);

        //delete Fresh Spring Roll
        appetizer.deleteOne(eq("name", "Fresh Spring Roll"));

        //delete everything in appetizer that match 3.20 in price
        DeleteResult deleteResult = appetizer.deleteMany(gte("price", "3.20"));
        System.out.println(deleteResult.getDeletedCount());


    }//end main
}//end class

