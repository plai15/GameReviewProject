/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tv8392uu
 */
public class Videogame {
    
    private String name, developer, releaseDate, cost;


    public Videogame() {
    }

    public Videogame(String name, String developer, String releaseDate, String cost) {
        this.name = name;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Developer: " + developer +  "\n" +  
               "Release Date: " + releaseDate + "\n" + 
               "Cost: " + cost;
    }
    
    
    
}
