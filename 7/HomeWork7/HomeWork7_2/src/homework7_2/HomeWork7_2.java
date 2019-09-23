
package homework7_2;

import java.util.Scanner;


public class HomeWork7_2 {

    
    public static void main(String[] args) {
        
        // Дана строка, состоящая из слов, разделенных пробелами и знаками препинания.
     //Определить длину самого короткого слова.
     
     
        System.out.println("Введите слова и узнайте какое из них самое маленькое");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine(); 
        String[] strArr = str.split(" "); // тут делим ее на отдельные слова, по пробелу
        String minLen = strArr[0]; 
        



        for (String s : strArr) {
        if (s.length() < minLen.length()) {
        minLen = s;
      
        }
       }
        System.out.println("Самое маленькое слово: "+minLen); 
       
}
    }
    

