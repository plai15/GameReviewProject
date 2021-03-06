
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.List;


/**
 * Assignment: Final Project
 * Author: Brandon Salmon and PK Lai
 * Description: GUI window for writing a review
 */
public class WriteReview extends javax.swing.JFrame {

    /**
     * Creates new form WriteReview
     */
    private String gameName, username;
    private boolean isVideoGame;

    public WriteReview(String gameName, String username, boolean isVideoGame) {
        initComponents();
        this.gameName = gameName;
        this.username = username;
        this.isVideoGame = isVideoGame;
        this.gameNameField.setText(gameName);
        this.errorLabel.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reviewLabel = new javax.swing.JLabel();
        scoreField = new javax.swing.JTextField();
        gameNameField = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reviewField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        postButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reviewLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        reviewLabel.setText("Write A Review");

        scoreField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreFieldActionPerformed(evt);
            }
        });

        gameNameField.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        gameNameField.setText("Game");

        jLabel2.setText("Score");

        reviewField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        reviewField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewFieldActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        postButton.setText("Post!");
        postButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });

        errorLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reviewField, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scoreField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                                .addComponent(postButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(225, 225, 225)
                        .addComponent(reviewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorLabel)
                    .addComponent(gameNameField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(reviewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(gameNameField)
                        .addGap(18, 18, 18)
                        .addComponent(errorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reviewField, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(scoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(postButton)
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scoreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreFieldActionPerformed

    private void reviewFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reviewFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    //gets the review, and updates user stats based on it
    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButtonActionPerformed
        // TODO add your handling code here:
        String username, review, game;
        double reviewScore;
        MongoConnection myMongo = new MongoConnection();
        MongoCollection<org.bson.Document> coll = myMongo.database.getCollection("VideoGameReview");
        MongoCollection<org.bson.Document> users = myMongo.database.getCollection("Login");
        
        if (this.isVideoGame) {
            coll = myMongo.database.getCollection("VideoGameReview");
        } else {
            coll = myMongo.database.getCollection("BoardGameReview");
        }
        
        //try and retrieve user from the database and buiild their review
        org.bson.Document user = (org.bson.Document) users.find(eq("username", this.username)).first();
        int totalReviews = Integer.parseInt(user.get("totalReviews").toString());
        try {
            username = this.username;
            game = this.gameName;
            review = this.reviewField.getText();
            reviewScore = Double.parseDouble(this.scoreField.getText());
            if(reviewScore < 0.0 || reviewScore > 5.0) {
                errorLabel.setText("Error, review must be between 0.0 and 5.0");
                errorLabel.setVisible(true);
                return;
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("Error, review must be between 0.0 and 5.0");
            errorLabel.setVisible(true);
            return;
        }
        totalReviews ++;
        List<BasicDBObject> likedGames = new ArrayList();
        if(reviewScore > 2.5) {
            likedGames.add(new BasicDBObject("0", gameName));
        }
        //add new review and update user stats
        org.bson.Document reviewDoc = new org.bson.Document("Reviewing User", this.username)
                .append("Game", game)
                .append("Review", review)
                .append("Score", reviewScore);
        coll.insertOne(reviewDoc);
        users.updateOne(eq("username", this.username), set("totalReviews", totalReviews));
        users.updateOne(eq("username", this.username), set("likedGames", likedGames));
        this.dispose();
    }//GEN-LAST:event_postButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel gameNameField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton postButton;
    private javax.swing.JTextField reviewField;
    private javax.swing.JLabel reviewLabel;
    private javax.swing.JTextField scoreField;
    // End of variables declaration//GEN-END:variables
}
