/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tv8392uu
 */
public class Boardgame {
    private String name, designer;
    private double cost;

    public Boardgame() {
    }

    public Boardgame(String name, String designer, double cost) {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Boardgame{" + "name=" + name + ", designer=" + designer + ", cost=" + cost + '}';
    }
    
    
}
