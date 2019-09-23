package org.itstep.Figure;

/**
 * Created by Вит on 17.02.2017.
 */
class Square extends Rectangle{

    Square(String name,double x,double y, double width, double height) {
        super(name,0,0,width, height);
        if(width==height&&x==0&&y==0){
            System.out.println("Square create.");
        }


    }

    @Override
    public void draw() {
        super.draw();

        System.out.println();
    }
    public void prim(double prim){
        prim = (width+height)*2;
        System.out.println(prim);
    }
    public void sum(double sum){
        sum = width*4;
        System.out.println(sum);
    }
}
