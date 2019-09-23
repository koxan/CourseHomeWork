package org.itstep.Figure;

import org.itstep.Shape;

/**
 * Created by Вит on 17.02.2017.
 */
public class Ellipse extends Shape{
    public double width;
    public double height;

    Ellipse(String name,double x,double y,double width,double height){
        super(name,x,y);
        this.width = width;
        this.height=height;

        System.out.println("Ellipse create.");
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Width :"+width);
        System.out.println("Height :"+ height);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
