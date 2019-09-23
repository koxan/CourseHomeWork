/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.util.Scanner;

/**
 *
 * @author Вит
 */
public class Homework2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сумму депозита :");
       
        double x = scan.nextDouble();
        
        System.out.println("Введите годовую ставку %:");
        
        double n = scan.nextDouble();
        
        System.out.println("Введите срок депозита в месяцах:");
        
        double m = scan.nextDouble();
        double dep = (((x/100)*n)/12)*m;
        System.out.println("Ваш депозитный процент составит:"+ dep);
        System.out.println("Ваш депозит состовит:"+(dep+x));
    }
    
}
