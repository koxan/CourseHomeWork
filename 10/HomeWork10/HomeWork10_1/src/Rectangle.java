import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by Вит on 11.02.2017.
 */
public class Rectangle {

    double width1;
    double width2;
    double height1;
    double height2;



    Rectangle(double A,double B, double C, double D){

        if(A==B&&B==C&&C==D&&A!=0&&B!=0&&C!=0&&D!=0){
            System.out.println("Вы ввели параметры квадрата :");
            height1=A;
            width1=B;
            height2=C;
            width2=D;
        }

        else if(A==C&&B==D&&A!=B&&C!=D||A!=0&&B!=0&&C!=0&&D!=0){
            System.out.println("Ваш прямоугольник равнобедренный :");
            height1=A;
            width1=B;
            height2=C;
            width2=D;
        }

    }
    Rectangle(){
        System.out.println("Default\nВы не ввели данные.");

            width1 = 0;
            width2=0;
            height1 = 0;
            height2=0;


    }
    void rectangleS(double A,double B){

        System.out.println("Площадь прямоугольника S = A*B = "+A*B+" ; ");
    }
    void rectangleP(double A,double B){

        System.out.println("Периметр прямоугольника P = (A+B)*2 = "+(2*(A+B)));
    }

    void recInfo(){
        System.out.println("Сторона А = "+ height1);
        System.out.println("Сторона B = "+width1);
        System.out.println("Сторона C = "+height2);
        System.out.println("Сторона D = "+width2);
    }


}
class MyRectangle{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Для создания прямоугольника необходимо ввести размер сторон A,B,C,D.\nДля создания равнобедренного треугольника A=C и B=D\nЕсли A=B=C=D то данная фигура квадрат.");

        Rectangle rectangle = new Rectangle(20,20,20,20);
        rectangle.width1=20;
        rectangle.height1=20;
        rectangle.width2=20;
        rectangle.height2=20;


       rectangle.recInfo();

        rectangle.rectangleS(20,20);
        rectangle.rectangleP(20,20);





    }
}
