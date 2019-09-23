/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3_4;

import java.util.Scanner;

/**
 *
 * @author Вит
 */
public class HomeWork3_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double d,x1,x2;
        System.out.println("Решение квадратного уравнения");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введем значение а: ");
        double a = scan.nextDouble();
        System.out.println("Введем значение b: ");
        double b = scan.nextDouble();
        System.out.println("Введем значение c: ");
        double c = scan.nextDouble();
        System.out.println(" a = "+ a + " b = "+ b + " c = "+ c);
        
        d = (b*b)-(4*a*c);
       System.out.println("Дискриминант равен : "+ d);
       
       if(d<0){
       System.out.println("Уравнение не имеет действительных корней.");}
       else if(d==0){
       x1 = (-b)/(2*a);
       System.out.println(" x = " +x1);
       }
       else{
       x1= ((-b + Math.sqrt(d))/ (2*a));
       x2= ((-b - Math.sqrt(d))/ (2*a));
       if(x1==x2){
           System.out.println(" x1==x2 " + x1);}
       else{
           System.out.println(" x1 = " +x1 + " x2 = " + x2);}
       }
    }
    
}
