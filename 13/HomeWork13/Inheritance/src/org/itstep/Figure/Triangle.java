package org.itstep.Figure;

import org.itstep.Shape;

/**
 * Created by Вит on 17.02.2017.
 */
public class Triangle extends Shape {
    private  double c = 0;

    Triangle(String name,double x,double y,double  c){
        super(name,x,y);
        this.c = c;
        System.out.println("Triangle create .");
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Side c : "+c);
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }


}
