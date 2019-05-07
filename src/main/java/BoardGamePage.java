
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComboBox;
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
public class BoardGamePage extends javax.swing.JFrame {

    /**
     * Creates new form BoardGamePage
     */
    
    private String username;

    public BoardGamePage(String username) {
        this.username = username;
        initComponents();MongoConnection myMongo = new MongoConnection();
        MongoCollection<org.bson.Document> coll = myMongo.database.getCollection("BoardGameReview");
        FindIterable<Document> cursor = coll.find().sort(new BasicDBObject("$natural", -1));
        cursor.sort(new BasicDBObject("$natural", -1));
        ArrayList<Document> reviewList = new ArrayList();
        
        
        for (Document doc : cursor) {
            reviewList.add(doc);
        }
        
        Random rand = new Random();
        Review hotReview = new Review();
        Document thisReview;
        String hotReviews = "";
        for(int i = 0; i < 50; i ++) {
            thisReview = reviewList.get(i);
            
            hotReview.setUserName(thisReview.get("Reviewing User").toString());
            hotReview.setGameName(thisReview.get("Game").toString());
            hotReview.setReview(thisReview.get("Review").toString());
            hotReview.setScore(thisReview.get("Score").toString());
            
            hotReviews += hotReview.toString() + "\n\n";
        }
        
        gameReviewArea.setText(hotReviews);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameReviewArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        latestReviewsLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Board Game Board");

        gameReviewArea.setEditable(false);
        gameReviewArea.setColumns(20);
        gameReviewArea.setRows(5);
        gameReviewArea.setAutoscrolls(false);
        jScrollPane1.setViewportView(gameReviewArea);

        jLabel2.setText("Games");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        latestReviewsLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        latestReviewsLabel1.setText("Latest Reviews");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5-Minute Dungeon", "Betrayal at the house on the hill", "Sanctum" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(latestReviewsLabel1)
                        .addGap(645, 645, 645))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(backButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(latestReviewsLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        new MainMenu(username).setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //String gameName = (String)jComboBox2.getSelectedItem();
        String[] games = {"5-Minute Dungeon", "Betrayal at House on the Hill", "Sanctum"};
        String gameName = games[jComboBox2.getSelectedIndex()];
        new GamePage(gameName,this.username).setVisible(true);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea gameReviewArea;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel latestReviewsLabel1;
    // End of variables declaration//GEN-END:variables
}
