/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tv8392uu
 */
public class Review {
    private String userName, gameName, review;
    private String score;

    public Review() {
    }

    public Review(String userName, String gameName, String review, String score) {
        this.userName = userName;
        this.gameName = gameName;
        this.review = review;
        this.score = score;
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        if(this.gameName == null) {
            this.gameName = "";
        }
        if(this.userName == null) {
            return  gameName + "\n" + review + "\n" + "Score:" + score;
        }
        return  gameName + "\n" + "By: " + userName + "\n" + review + "\n" + "Score:" + score;
    }
}
