package org.itstep;

import org.itstep.Figure.*;



import java.awt.*;

/**
 * Created by Вит on 16.02.2017.
 */
public class Shape {
    private String name;
    public double x;
    public double y;



    public Shape(String name,double x,double y){
        System.out.println("Shape create.");
        this.name=name;
        this.x = x;
        this.y=y;

    }
    public Shape(){

    }
    public Shape(String name,double x){
        this(name,x,0);
    }
    public Shape(String name){
        this(name,0,0);
    }
    public String getName(){
     return name;
    }
    public double getX(){
        return  x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY(){
        return  y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void draw(){

        System.out.println(name);
        System.out.println("Point X: "+x);
        System.out.println("Point Y: "+y);
    }


}
