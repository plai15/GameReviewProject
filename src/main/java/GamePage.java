
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
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

        if (coll.find(eq("Name", gameName)).first() == null) {
            coll = mongo.database.getCollection("BoardGame");
            this.isVideoGame = false;
        }
        org.bson.Document game = coll.find(eq("Name", gameName)).first();
        MongoCollection<org.bson.Document> reviewColl;

        if (this.isVideoGame) {
            name = game.get("Name").toString();
            developer = game.get("Developer").toString();
            cost = game.get("Cost").toString();
            releaseDate = game.get("Release Date").toString();

            Videogame thisGame = new Videogame(name, developer, releaseDate, cost);

            gameTitleLabel.setText(thisGame.getName());

            reviewColl = mongo.database.getCollection("VideoGameReview");
            FindIterable<Document> cursor = reviewColl.find();
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
            FindIterable<Document> cursor = reviewColl.find();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        reviewButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        latestReviews = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gameTitleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        gameTitleLabel.setText("Game Title");

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
        latestReviewsLabel.setText("Latest Reviews");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        reviewButton.setText("Write a review");
        reviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewButtonActionPerformed(evt);
            }
        });

        latestReviews.setColumns(20);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(gameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(latestReviewsLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
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
            new VideoGamePage("").setVisible(true);
        } else {
            new BoardGamePage("").setVisible(true);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void reviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewButtonActionPerformed
        // TODO add your handling code here:
        new WriteReview(username, gameName, isVideoGame).setVisible(true);
    }//GEN-LAST:event_reviewButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePage("5-Minute Dungeon", "brandon").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea gameInfoArea;
    private javax.swing.JLabel gameTitleLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea latestReviews;
    private javax.swing.JLabel latestReviewsLabel;
    private javax.swing.JButton reviewButton;
    // End of variables declaration//GEN-END:variables
}
