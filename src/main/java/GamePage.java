
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.bson.Document;

/**
 * Assignment: Final Project
 * Author: Brandon Salmon and PK Lai
 * Description: GUI page for individual games
 */
public class GamePage extends javax.swing.JFrame {

    /**
     * Creates new form GamePage
     */
    private boolean isVideoGame;
    private String username, gameName;
    
    
    public GamePage(String gameName, String username) {
        initComponents();

        String name, developer, releaseDate, cost, publisher;
        this.isVideoGame = true;
        this.username = username;
        this.gameName = gameName;

        MongoConnection mongo = new MongoConnection();

        MongoCollection<org.bson.Document> coll = mongo.database.getCollection("VideoGame");

        //figure out if game is a board game or video game
        if (coll.find(eq("Name", gameName)).first() == null) {
            coll = mongo.database.getCollection("BoardGame");
            this.isVideoGame = false;
        }
        org.bson.Document game = coll.find(eq("Name", gameName)).first();
        MongoCollection<org.bson.Document> reviewColl;

        //get game image
        String imagePath = game.get("path").toString();
        imagePath = imagePath.replace('"', ' ');
        imagePath = imagePath.trim();
        imageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
        
        //display game info and some random reviews
        if (this.isVideoGame) {
            name = game.get("Name").toString();
            developer = game.get("Developer").toString();
            cost = game.get("Cost").toString();
            releaseDate = game.get("Release Date").toString();

            Videogame thisGame = new Videogame(name, developer, releaseDate, cost);

            gameTitleLabel.setText(thisGame.getName());

            reviewColl = mongo.database.getCollection("VideoGameReview");
            FindIterable<Document> cursor = reviewColl.find().sort(eq("$natural", -1));
            cursor.sort(new BasicDBObject("$natural", -1));

            ArrayList<Document> reviewList = new ArrayList();

            for (Document doc : cursor) {
                if (doc.get("Game") != null) {
                    String thisGameName = doc.get("Game").toString();
                    if (thisGameName.equalsIgnoreCase(gameName)) {
                        reviewList.add(doc);
                    }
                }
            }

            double totalScore = 0;

            for (int i = 0; i < reviewList.size(); i++) {
                totalScore += Double.parseDouble(reviewList.get(i).get("Score").toString());
            }

            totalScore = (totalScore / reviewList.size()) * 10;
            totalScore = Math.round(totalScore) / 10.0;

            gameInfoArea.setText("Average Review: " + totalScore + "\n" + thisGame.toString());
            Random rand = new Random();
            Review hotReview = new Review();
            Document thisReview;
            String hotReviews = "";
            for (int i = 0; i < 50; i++) {
                thisReview = reviewList.get(rand.nextInt(reviewList.size()));

                hotReview.setUserName(thisReview.get("Reviewing User").toString());
                hotReview.setReview(thisReview.get("Review").toString());
                hotReview.setScore(thisReview.get("Score").toString());

                hotReviews += hotReview.toString() + "\n";
            }

            latestReviews.setText(hotReviews);
        } else {
            name = game.get("Name").toString();
            publisher = game.get("Designer").toString();
            cost = game.get("Cost").toString();

            Boardgame thisGame = new Boardgame(name, publisher, cost);

            gameTitleLabel.setText(thisGame.getName());

            reviewColl = mongo.database.getCollection("BoardGameReview");
            FindIterable<Document> cursor = reviewColl.find().sort(new BasicDBObject("$natural", -1));
            cursor.sort(new BasicDBObject("$natural", -1));

            ArrayList<Document> reviewList = new ArrayList();

            for (Document doc : cursor) {
                if (doc.get("Game") != null) {
                    String thisGameName = doc.get("Game").toString();
                    if (thisGameName.equalsIgnoreCase(gameName)) {
                        reviewList.add(doc);
                    }
                }
            }

            double totalScore = 0;

            for (int i = 0; i < reviewList.size(); i++) {
                totalScore += Double.parseDouble(reviewList.get(i).get("Score").toString());
            }

            totalScore = (totalScore / reviewList.size()) * 10;
            totalScore = Math.round(totalScore) / 10.0;
            

            gameInfoArea.setText("Average Review: " + totalScore + "\n" + thisGame.toString());
            Random rand = new Random();
            Review hotReview = new Review();
            Document thisReview;
            String hotReviews = "";
            for (int i = 0; i < 50; i++) {
                thisReview = reviewList.get(rand.nextInt(reviewList.size()));

                hotReview.setUserName(thisReview.get("Reviewing User").toString());
                hotReview.setReview(thisReview.get("Review").toString());
                hotReview.setScore(thisReview.get("Score").toString());

                hotReviews += hotReview.toString() + "\n";
            }

            latestReviews.setText(hotReviews);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameTitleLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gameInfoArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        latestReviewsLabel = new javax.swing.JLabel();
        reviewButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        latestReviews = new javax.swing.JTextArea();
        imageIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gameTitleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        gameTitleLabel.setText("Game Title");

        gameInfoArea.setEditable(false);
        gameInfoArea.setColumns(20);
        gameInfoArea.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        gameInfoArea.setRows(5);
        jScrollPane2.setViewportView(gameInfoArea);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        latestReviewsLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        latestReviewsLabel.setText("Hot Reviews");

        reviewButton.setText("Write a review");
        reviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewButtonActionPerformed(evt);
            }
        });

        latestReviews.setEditable(false);
        latestReviews.setColumns(20);
        latestReviews.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        latestReviews.setRows(5);
        jScrollPane4.setViewportView(latestReviews);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 130, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(latestReviewsLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton)
                                .addGap(212, 212, 212))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(gameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(imageIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(latestReviewsLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        if (isVideoGame) {
            new VideoGamePage(this.username).setVisible(true);
        } else {
            new BoardGamePage(this.username).setVisible(true);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void reviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewButtonActionPerformed
        // TODO add your handling code here:
        new WriteReview(this.gameName,this.username,this.isVideoGame).setVisible(true);
    }//GEN-LAST:event_reviewButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea gameInfoArea;
    private javax.swing.JLabel gameTitleLabel;
    private javax.swing.JLabel imageIcon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea latestReviews;
    private javax.swing.JLabel latestReviewsLabel;
    private javax.swing.JButton reviewButton;
    // End of variables declaration//GEN-END:variables
}
