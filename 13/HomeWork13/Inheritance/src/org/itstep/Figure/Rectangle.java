package org.itstep.Figure;

import org.itstep.Shape;

/**
 * Created by Вит on 16.02.2017.
 */
 class Rectangle extends Shape {
     public double width;
     public double height;



    Rectangle(String name, double x, double y,double width,double height) {
        super(name, x, y);
        this.width = width;
        this.height=height;
        System.out.println("Rectangle create.");
    }
    @Override
    public void draw(){

        super.draw();
        System.out.println("Width :"+width);
        System.out.println("Height :"+ height);

        //System.out.println("Width Rectangle"+width+"Height Rectangle"+height);

}
    public double getWidth(){
        return width;
    }
    public void  setWidth(){
        this.width=width;
    }
    public double getHeight(){
        return  height;
    }
    public void setHeight(){
        this.height=height;
    }




}


