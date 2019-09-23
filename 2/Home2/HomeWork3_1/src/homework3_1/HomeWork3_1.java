/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3_1;

import java.util.Scanner;

/**
 *
 * @author Вит
 */
public class HomeWork3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Давайте проверим кратно ли X числу Y.");
        System.out.println("Введите первое целое число X:");
        int x = sc.nextInt();
        System.out.println("Введите второе целое число Y:");
        int y = sc.nextInt();
        if(x%y==0&&x!=0&&y!=0)
            System.out.println("X кратно Y."+"Их кратность равна: "+( x/y));
    
        else {
            System.out.println("X не кратно Y ");}
        
        
        
    }
    
}
