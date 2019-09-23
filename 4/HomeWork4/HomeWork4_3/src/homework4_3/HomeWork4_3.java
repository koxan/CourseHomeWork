
package homework4_3;

import java.util.Scanner;

public class HomeWork4_3 {

    
    public static void main(String[] args) {
       
//       n=scan.nextInt();
//       if(n<=9){
//    System.out.println("Введи нормальное целое число");
//       return;
//       }
//       if(n==10|| n==100||n==1000||n==10000||n==100000||n==1000000||n==10000000||n==100000000){
//    System.out.println("Нули сам дорисуешь) ");
//       return;
//       }
//
//        System.out.println("Ты ввел число "+n);
//      n1 = 0;
//while(n != 0){
//    
//     n1 = n1*10 + n%10;
//     n = n/10;
//     }
//
//System.out.println("А я попытался его перевернуть и у меня получилось " + n1);
         Scanner scan = new Scanner(System.in);
         System.out.println("Введите число состоящее не менее,чем из 2 цифр,а я попробую его перевернуть наоборот :) ");
       
         int n1,n2,n3,n4,n5,n6,n7,n8;
         for(int x=scan.nextInt();x<999999999;x++){
            
         if(x>=10&&x<=99){
            n2=x%10;
            n1=x/10;
            
            System.out.print("Твое число в перевернутом виде: ");
            System.out.print(n2);
            System.out.println(n1);
            
             break;
         }
         if(x>=100&&x<=999){
            n3=x%10;
            n2=(x/10)%10;
            n1=x/100;
            System.out.print("Твое число в перевернутом виде: ");
            System.out.print(n3);
            System.out.print(n2);
            System.out.println(n1);
             break;
         }
         if(x>=1000&&x<=9999){
             n4=x%10;
            n3=(x/10)%10;
            n2=(x/100)%10;
            n1=(x/1000)%10;
            
            System.out.print("Твое число в перевернутом виде: ");
            System.out.print(n4);
            System.out.print(n3);
            System.out.print(n2);
            System.out.println(n1);
             break;
         }
         if(x>=10000&&x<=99999){
             
            n5=x%10;
            n4=(x/10)%10;
            n3=(x/100)%10;
            n2=(x/1000)%10;
            n1=x/10000;
            
            System.out.print("Твое число в перевернутом виде: ");
            System.out.print(n5);
            System.out.print(n4);
            System.out.print(n3);
            System.out.print(n2);
            System.out.println(n1);
            
                break;
         }
         if(x>=100000&&x<=999999){
            n6=x%10;
            n5=(x/10)%10;
            n4=(x/100)%10;
            n3=(x/1000)%10;
            n2=(x/10000)%10;
            n1=x/100000;
            System.out.print("Твое число в перевернутом виде: ");
            System.out.print(n6);
            System.out.print(n5);
            System.out.print(n4);
            System.out.print(n3);
            System.out.print(n2);
            System.out.println(n1);
            
              break;
         }
         if(x>=1000000&&x<=9999999){
             n7=x%10;
            n6=(x/10)%10;
            n5=(x/100)%10;
            n4=(x/1000)%10;
            n3=(x/10000)%10;
            n2=(x/100000)%10;
            n1=x/1000000;
            System.out.print("Твое число в перевернутом виде: ");
            System.out.print(n7);
            System.out.print(n6);
            System.out.print(n5);
            System.out.print(n4);
            System.out.print(n3);
            System.out.print(n2);
            System.out.println(n1);
            
            
              break;
            
         }
         if(x>=10000000&&x<=99999999){
            n8=x%10;
            n7=(x/10)%10;
            n6=(x/100)%10;
            n5=(x/1000)%10;
            n4=(x/10000)%10;
            n3=(x/100000)%10;
            n2=(x/1000000)%10;
            n1=x/10000000;
            
            System.out.print("Твое число в перевернутом виде: ");
            System.out.print(n8);
            System.out.print(n7);
            System.out.print(n6);
            System.out.print(n5);
            System.out.print(n4);
            System.out.print(n3);
            System.out.print(n2);
            System.out.println(n1);
            
             break;
         }
         System.out.println("Не мухлюй.От 10 до 99999999");
         break;
         
         
         }
    }
    
}
