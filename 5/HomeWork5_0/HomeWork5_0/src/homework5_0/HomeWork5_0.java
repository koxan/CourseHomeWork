
package homework5_0;

import java.util.Scanner;


public class HomeWork5_0 {

   
    public static void main(String[] args) {
        int day = 0, month = 0, year = 0;
        boolean isLeap = false;

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Введите день рождения:");
            day = sc.nextInt();

            System.out.println("Введите месяц рождения(числом):");
            month = sc.nextInt();

            System.out.println("Введите год рождения:");
            year = sc.nextInt();

            
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeap = true;
                    } else {
                        isLeap = false;
                    }
                } else {
                    isLeap = true;
                }
            } else {
                isLeap = false;
            }

            

            if (
                (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) &&
                (day < 1 || day > 31) ||
                (month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30) ||
                month == 2 && (day < 1 || day > 28) && !isLeap ||
                month == 2 && (day < 1 || day > 29) && isLeap ||
                (month < 1 || month > 12) ||
                year < 1900
            ) {
                System.out.println("Дата введена неверно");
            }

        } while(
                (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) &&
                (day < 1 || day > 31) ||
                (month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30) ||
                month == 2 && (day < 1 || day > 28) && !isLeap ||
                month == 2 && (day < 1 || day > 29) && isLeap ||
                (month < 1 || month > 12) ||
                year < 1900
                );

        int dayC = 0, monthC = 1, yearC = 1900, daysFrom = 0;

        while (true) {

            
            if (yearC % 4 == 0) {
                if (yearC % 100 == 0) {
                    if (yearC % 400 == 0) {
                        isLeap = true;
                    } else {
                        isLeap = false;
                    }
                } else {
                    isLeap = true;
                }
            } else {
                isLeap = false;
            }

            dayC++;
            daysFrom++;

            if (
                (monthC == 1 || monthC == 3 || monthC == 5 || monthC == 7 || monthC == 8 || monthC == 10 || monthC == 12) &&
                dayC > 31 ||
                (monthC == 4 || monthC == 6 || monthC == 9 || monthC == 11) && dayC > 30 ||
                monthC == 2 && dayC > 28 && !isLeap ||
                monthC == 2 && dayC > 29 && isLeap
            ) {
                monthC++;
                dayC = 1;
            }

            if (monthC == 13) {
                monthC = 1;
                yearC++;
            }

            if (day == dayC && month == monthC && year == yearC) {
                break;
            }

        }

        System.out.println("Дней с 1.1.1900 по день рождения =  " + daysFrom);

    }
    
}
