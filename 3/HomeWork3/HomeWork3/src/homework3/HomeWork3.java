
package homework3;

import java.util.Scanner;


public class HomeWork3 {

   
    public static void main(String[] args) {
        int a,year,m,day,y,month,days; 
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите дату,чтобы узнать день недели");
        System.out.println("Введите год в формате yyyy: ");
        year = scan.nextInt();
        System.out.println("Введите месяц в формате mm: ");
        month = scan.nextInt();
        System.out.println("Введите день в формате dd: ");
        day = scan.nextInt();
        
        if(year>=1582&&month>=1&&month<=12&&day>=1&&day<=31){
        a =(14-month) / 12;
        y = year - a;
        m = month +12 * a - 2;
        days = (7000 +(day +y +y / 4 - y /100 +y / 400 + (31*m)/12))%7;
        
        if(month==2&&day>=30){
            System.out.println("В феврале не может быть"+ day);}
            else{
                  switch (days) {
    case 0:  System.out.println(year+" год "+month+" месяц "+day+" число"+"= Воскресенье");
             break;
    case 1:  System.out.println(year+" год "+month+" месяц "+day+" число"+"= Понедельник");
             break;
    case 2:  System.out.println(year+" год "+month+" месяц "+day+" число"+"= Вторник");
             break;
    case 3:  System.out.println(year+" год "+month+" месяц "+day+" число"+"= Среда");
             break;
    case 4:  System.out.println(year+" год "+month+" месяц "+day+" число"+"= Четверг");
             break;
    case 5:  System.out.println(year+" год "+month+" месяц "+day+" число"+"= Пятница");
             break;
    case 6:  System.out.println(year+" год "+month+" месяц "+day+" число"+"= Суббота");
             break;
    
    
    default: System.out.println("Ну ты чего?Введи нормально :) ");
             break;

        }  
                    }
        
        

}
        
        else {
        System.out.println("Введите правильно дату");}
    
}
}

