/**
 * Assignment: Final Project
 * Author: Brandon Salmon and PK Lai
 * Description: Board Game class definition
 */
public class Boardgame {
    private String name, designer;
    private String cost;

    public Boardgame() {
    }

    public Boardgame(String name, String designer, String cost) {
        this.name = name;
        this.designer = designer;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Designer: " + designer +  "\n" +  
               "Cost: " + cost;
    }
    
    
}
