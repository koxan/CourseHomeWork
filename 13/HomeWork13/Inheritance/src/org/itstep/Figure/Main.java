package org.itstep.Figure;

import org.itstep.Shape;

/**
 * Created by Вит on 17.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape("soul",20,20);
        shape.draw();
        System.out.println();
        Rectangle rec = new Rectangle("lol",20,20,20,40);
        rec.draw();
        Square square = new Square("Square",0,0,20,20);
        square.draw();
        square.prim(20);

        Ellipse ellipse = new Ellipse("ellipse",20,20,40,40);
        ellipse.draw();

        Circle circle = new Circle("circle",20,20,20,20);
        circle.draw();
        Triangle triangle = new Triangle("triangle",20,30,40);
        triangle.draw();


    }
}
