/**
 * Assignment: Final Project
 * Author: Brandon Salmon and PK Lai
 * Description: Videogame class definition
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
