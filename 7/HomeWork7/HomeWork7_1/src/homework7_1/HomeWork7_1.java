
package homework7_1;

import java.util.Scanner;


public class HomeWork7_1 {

    
    public static void main(String[] args) {
  //1. Пользователь вводит слово или словосочетание используя латинские символы.
  //Вывести кол-во гласных и согласных.  
  
  System.out.println("Введите слово или словосочетание используя латинские символы.");
        
        Scanner scanner = new Scanner(System.in);
        char[] string1={'A','a','B','b'};
        char[] string2 = {'A','a','E','e','I','i','O','o','U','u','Y','y'};
        char[] string3={'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z'};
        int glas =0;
        
        string1 = scanner.nextLine().toCharArray();
        
        for(int i =0;i<string1.length;i++){
        for(int j =0;j<string2.length;++j){
            
        if(string1[i]==string2[j]){
        glas++;
        System.out.print(string1[i]+";");
        }
        
       }
      }
        System.out.println();
        System.out.println(glas+" гласных");
        System.out.print(string1.length-glas + " негласных ");
	
    }
    
}
