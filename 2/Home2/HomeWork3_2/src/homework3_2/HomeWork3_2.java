/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3_2;

import java.util.Scanner;

/**
 *
 * @author Вит
 */
public class HomeWork3_2 {

    /**
     * однозначное-двузначное-трехзначное
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Узнай разрядность числа!");
        System.out.println("Введите число от 0 до 10000");
        int x = sc.nextInt();
        if(x>=1000&&x<=9999){
        System.out.println("Ваше число "+x+" является четырехзначным.");}
        else if(x==10000){
        System.out.println("Ваше число "+x+" является пятизначным.");
        }
        else if(x>=100&&x<=999){
            System.out.println("Ваше число "+x+" является трехзначным.");
        }
        else if( x>=10&&x<=99){
        System.out.println("Ваше число "+x+" является двухзначным.");}
        else if(x>=0&&x<=9){
        System.out.println("Ваше число "+x+" является однозначным.");}
        else{
        System.out.println("Ваше число заходит за указанный диапозон.Введите верное число.");}
    }
    
    
}
