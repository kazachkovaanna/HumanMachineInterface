/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dexample;

import javafx.scene.paint.Color;

/**
 *
 * @author Ann
 */
public class Atom {

    private int diameter;
    private Color color;
    private int valency;
    private String id;

    private double x, y;
    
    public Atom(int d, Color c, int val){
        diameter = d;
        color = c;
        valency = val;
    }
    
    public Atom(){
        diameter = 1;
        color = Color.AZURE;
        valency = 1;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getValency() {
        return valency;
    }

    public void setValency(int valency) {
        this.valency = valency;
    }
}
