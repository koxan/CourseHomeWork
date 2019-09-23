package org.itstep.Figure;

/**
 * Created by Вит on 17.02.2017.
 */
public class Circle extends Ellipse {
    private static double center = 0.0;
    Circle(String name, double x, double y, double width, double height) {
        super(name, x, y, width, height);
        this.center = center;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Circle create .");
        System.out.println("Ctnter circle :" + center);
    }

    public static double getCenter() {
        return center;
    }

    public static void setCenter(double center) {
        Circle.center = center;
    }
}
