
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tv8392uu
 */
public class MakeReviews {
    public static void main(String[] args) {
        MongoConnection myMongo = new MongoConnection();
        MongoCollection<org.bson.Document> coll = myMongo.database.getCollection("BoardGameReview");
        MongoCollection<org.bson.Document> users = myMongo.database.getCollection("Login");

        
        String[] gameNames = {"5-Minute Dungeon", "Betrayal at House on the Hill", "Sanctum"};
        String[] goodReviews = {"This game is really fun", "Incredible", "A blast to play", "The dedication really shows", "I'm am amazed at the quality", "Potential game of the year right here"};
        String[] mehReviews = {"It's ok", "Good, but kinda overpriced", "Was cool, but got boring quickly", "Cool concept but not a great execution"};
        String[] badReviews = {"Total waste of time", "At least they are quick to give refunds", "The developers are evil cash grabbing monkeys", "I got bored almost immediately", "The premise is just dumb", "I have no friends and it's not that fun alone", "Shipped with missing pieces and got no response from company", "Poorly designed"};
        
        FindIterable<Document> cursor = users.find();
        ArrayList<Document> userList = new ArrayList();
        
        for (Document doc : cursor) {
            userList.add(doc);
        }
        //String[] likedGames;
        String user, game, review = "";
        int randomUser, randomGame, randomReview;
        double reviewScore;         
        String randCharacters = "";
        Random rand = new Random();
        
        for (int i = 0; i < 1000; i++) {
            randomUser = rand.nextInt(1000);
            user = userList.get(randomUser).get("username").toString();
            randomGame = rand.nextInt(gameNames.length);
            game = gameNames[randomGame];
            reviewScore = (rand.nextInt(5) + rand.nextDouble()) * 10;
            reviewScore = Math.round(reviewScore) / 10.0;
            
            if(reviewScore > 4) {
                review = goodReviews[rand.nextInt(goodReviews.length)];
            }
            else if(reviewScore > 2) {
                review = mehReviews[rand.nextInt(mehReviews.length)];
                            }
            else if(reviewScore < 2) {
                review = badReviews[rand.nextInt(badReviews.length)];
            }
            
            org.bson.Document reviewDoc = new org.bson.Document("Reviewing User", user)
                    .append("Game", game)
                    .append("Review", review)
                    .append("Score", reviewScore);
            coll.insertOne(reviewDoc);
        }
    }
}
