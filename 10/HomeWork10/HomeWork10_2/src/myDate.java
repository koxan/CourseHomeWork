import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Thread.*;

/**
 * Created by Вит on 11.02.2017.
 */

public class myDate {

    public static void main(String[] args) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;
        SimpleDateFormat dateFormat1 = null;
        SimpleDateFormat dateFormat2 = null;
        Scanner scan = new Scanner(System.in);

        System.out.println("Выберите формат выводимого времени .");
        System.out.println("Нажмите 1.        Модель 1");
        System.out.println("Нажмите 2.        Модель 2");
        System.out.println("Нажмите 3.        Model 3");
        System.out.println("Нажмите 4.        Модель 4");
        System.out.println("Нажмите 5.        Модель 5");
        System.out.println("Нажмите 6.        Модель 6");
        int put = scan.nextInt();
        switch(put){
            case 1 :
                dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
                System.out.println("Полная Дата : " + dateFormat.format( currentDate ) );
                break;
            case 2 :
                dateFormat = new SimpleDateFormat("HH:mm:ss");
                System.out.println("Время: " + dateFormat.format( currentDate ) );
                break;
            case 3 :
                dateFormat = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa",Locale.ENGLISH);
                System.out.println("Full Date " + dateFormat.format( currentDate ) );
                break;
            case 4 :
                dateFormat = new SimpleDateFormat("dd MMMMM YYYY  года     HH:mm:ss");
                System.out.println("Constructor 4: " + dateFormat.format( currentDate ) );
                break;
            case 5 :
                dateFormat = new SimpleDateFormat("D");
                dateFormat1 = new SimpleDateFormat("EEEE");
                dateFormat2 = new SimpleDateFormat("HH:mm:ss");
                System.out.println("Количество дней с начала года: " + dateFormat.format( currentDate ) );
                System.out.println("День недели : " + dateFormat1.format( currentDate ) );
                System.out.println("Время : " + dateFormat2.format( currentDate ));
                break;
            case 6 :
                dateFormat = new SimpleDateFormat("YYYY MMMMM  EEEE", Locale.ENGLISH);
                System.out.println("English Date: " + dateFormat.format( currentDate ) );
                break;

        }
    }


}











