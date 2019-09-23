/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3_3;

import java.util.Scanner;

/**
 *
 * @author Вит
 */
public class HomeWork3_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc= new Scanner(System.in);
        System.out.println("Давайте найдем самое большое из 4 чисел. ");
        System.out.println("Введите значение числа a:");
        int a = sc.nextInt();
        System.out.println("Введите значение числа b:");
        int b = sc.nextInt();
        System.out.println("Введите значение числа c:");
        int c = sc.nextInt();
        System.out.println("Введите значение числа d:");
        int d = sc.nextInt();
        
       if(a>b&&a>c&&a>d||a>b&&b>c&&b>d||a>c&&c>b&&c>d||a>d&&d>b&&d>c){
       System.out.println("Самое большое число a= "+a);}
       else if(b>a&&b>c&&b>d||b>a&&a>c&&a>d||b>c&&c>a&&c>d||b>d&&d>a&&d>c){
       System.out.println("Самое большое число b= "+b);}  
       else if(c>a&&c>b&&c>d||c>a&&a>c&&a>d||c>b&&b>a&&b>d||c>d&&d>a&&d>b){
       System.out.println("Самое большое число c= "+c);}
       else if(d>a&&d>b&&d>c||d>a&&a>b&&a>c||d>b&&b>a&&b>c||d>c&&c>a&&c>b){
       System.out.println("Самое большое число d= "+d);}
       
      else if(a==b&&b>c&&b>d){
           System.out.println("Числа a и b равны и являются самым большим числом ="+a);
       }
      else if(a==c&&c>b&&c>d){
           System.out.println("Числа a и c равны и являются самым большим числом ="+a);
       }
      else if(a==d&&d>c&&d>b){
           System.out.println("Числа a и d равны и являются самым большим числом ="+a);
       }
      else if(b==c&&c>a&&c>d){
           System.out.println("Числа b и c равны и являются самым большим числом ="+b);
       }
      else if(b==d&&d>a&&d>c){
           System.out.println("Числа b и d равны и являются самым большим числом ="+b);
       }
      else if(c==d&&d>a&&d>b){
           System.out.println("Числа c и d равны и являются самым большим числом ="+c);
       }
      else if(a==b==c>d){
           System.out.println("Числа a,b и c равны и являются самым большим числом ="+a);
       }
      else if(b==c==d>a){
           System.out.println("Числа b,c и d равны и являются самым большим числом ="+b);
       }
      else if(c==d==a>b){
           System.out.println("Числа c,d и a равны и являются самым большим числом ="+c);
       }
      else if(d==a==b>c){
           System.out.println("Числа d,a и b равны и являются самым большим числом ="+d);
       }
       else {
           System.out.println("Все числа равны");
       }
       
    }
       
       
    }
    
    


