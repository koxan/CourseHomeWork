/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

import java.util.Scanner;

/**
 *
 * @author Вит
 */
public class HomeWork1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число x :");
       
        double x = scan.nextDouble();
        
        System.out.println("Введите процент % :");
        
        double n = scan.nextDouble();
        
        System.out.println(n+"% от числа х ,cоставляет число:"+ (x*n)/100);
        
    }
    
}
