
package homework4_2;

import java.util.Scanner;


public class HomeWork4_2 {

        
	public  static void main(String[] args) {
//        System.out.println("Введем число и узнаем является ли оно палиндромом.\nПалиндромом называют число,которое одинаково с любой стороны\nПример:123321,1221,939939...");
//        System.out.println("Если число палиндром вы получите ответ : true,\nесли не палиндром : false.");
//	Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        StringBuilder sb = new StringBuilder(str);
//        System.out.println(str.equals(sb.reverse().toString()));
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Давайте узнаем является ли ваше число палендромом.\nПалендром-это число,которое читается одинаково с обеих сторон.\nПример:121,1221,123454321.\nВведите ваше число от 10 до 99999999:") ;
        
        int n1,n2,n3,n4,n5,n6,n7,n8;
         for(int x=sc.nextInt();x<999999999;x++){
            
         if(x>=10&&x<=99){
            n1=x%10;
            n2=x/10;

            System.out.println(n2);
            System.out.println(n1);
            if(n1==n2){
                System.out.println("Ваше число палендром!Поздравляю!");}
                else{
                    System.out.println("Твое число не палиндром,попробуй еще раз!");
                }
             break;
         }
         if(x>=100&&x<=999){
             n1=x%10;
            n2=(x/10)%10;
            n3=x/100;
          
            System.out.println(n3);
            System.out.println(n2);
            System.out.println(n1);
            if(n1==n3){
                System.out.println("Ваше число палендром!Поздравляю!");}
                else{
                    System.out.println("Твое число не палиндром,попробуй еще раз!");
                }
             break;
         }
         if(x>=1000&&x<=9999){
             n1=x%10;
            n2=(x/10)%10;
            n3=(x/100)%10;
            n4=(x/1000)%10;
            
           
            System.out.println(n4);
            System.out.println(n3);
            System.out.println(n2);
            System.out.println(n1);
            if(n1==n4&&n2==n3){
                System.out.println("Ваше число палендром!Поздравляю!");}
                else{
                    System.out.println("Твое число не палиндром,попробуй еще раз!");
                }
             break;
         }
         if(x>=10000&&x<=99999){
             
            n1=x%10;
            n2=(x/10)%10;
            n3=(x/100)%10;
            n4=(x/1000)%10;
            n5=x/10000;
            
           
            System.out.println(n5);
            System.out.println(n4);
            System.out.println(n3);
            System.out.println(n2);
            System.out.println(n1);
            if(n1==n5&&n2==n4){
                System.out.println("Ваше число палендром!Поздравляю!");}
                else{
                    System.out.println("Твое число не палиндром,попробуй еще раз!");
                }
                break;
         }
         if(x>=100000&&x<=999999){
            n1=x%10;
            n2=(x/10)%10;
            n3=(x/100)%10;
            n4=(x/1000)%10;
            n5=(x/10000)%10;
            n6=x/100000;
           
            System.out.println(n6);
            System.out.println(n5);
            System.out.println(n4);
            System.out.println(n3);
            System.out.println(n2);
            System.out.println(n1);
            if(n1==n6&&n2==n5&&n3==n4){
                System.out.println("Ваше число палендром!Поздравляю!");}
                else{
                    System.out.println("Твое число не палиндром,попробуй еще раз!");
                }
              break;
         }
         if(x>=1000000&&x<=9999999){
             n1=x%10;
            n2=(x/10)%10;
            n3=(x/100)%10;
            n4=(x/1000)%10;
            n5=(x/10000)%10;
            n6=(x/100000)%10;
            n7=x/1000000;
           
            System.out.println(n7);
            System.out.println(n6);
            System.out.println(n5);
            System.out.println(n4);
            System.out.println(n3);
            System.out.println(n2);
            System.out.println(n1);
            
            if(n1==n7&&n2==n6&&n3==n5){
                System.out.println("Ваше число палендром!Поздравляю!");}
                else{
                    System.out.println("Твое число не палиндром,попробуй еще раз!");
                }
              break;
            
         }
         if(x>=10000000&&x<=99999999){
             n1=x%10;
            n2=(x/10)%10;
            n3=(x/100)%10;
            n4=(x/1000)%10;
            n5=(x/10000)%10;
            n6=(x/100000)%10;
            n7=(x/1000000)%10;
            n8=x/10000000;
            
            System.out.println(n8);
            System.out.println(n7);
            System.out.println(n6);
            System.out.println(n5);
            System.out.println(n4);
            System.out.println(n3);
            System.out.println(n2);
            System.out.println(n1);
            
            if(n1==n8&&n2==n7&&n3==n6&&n4==n5){
                System.out.println("Ваше число палендром!Поздравляю!");}
                else{
                    System.out.println("Твое число не палиндром,попробуй еще раз!");
                }
             break;
         }
         System.out.println("Не мухлюй.От 10 до 99999999");
         break;
         
         
         }
         
         }
        
    }  

  

                
       
		
        
    

    

