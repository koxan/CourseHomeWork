
package homework9_1;

import java.util.Scanner;

public class HomeWork9_1 {

    enum whatIsIt {
        NotSelected,
        Letter,
        Digit,
        Space,
        PuncChar,
        SpecChar
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = "";
        int idx = 0;
        boolean cond1 = false, cond2 = false;

        do {
            System.out.print("Введите строку:");
            line = sc.nextLine();
            cond1 = !(line.toCharArray().length != 0);
            if (cond1) {
                System.out.println("Ошибка! Введена пустая строка");
                continue;
            }
            System.out.print("Введите индекс символа из строки:");
            idx = sc.nextInt();
            sc.nextLine(); 
            cond2 = !(idx < line.length() && idx >= 0);
            if (cond2) {
                System.out.println("Ошибка! Неверный индекс");
            }
        } while(cond1 || cond2);

        System.out.println("Символ по данному индексу - " + determineChar(line, idx).toString());

    }

    public static whatIsIt determineChar(String line, int idx) {
        int compare = (int) line.toCharArray()[idx];
        int[] puncArray = {33,34,39,44,46,58,59,63};
        // A-Z, a-z
        if (compare >= 65 && compare <= 90 || compare >= 97 && compare <= 122) {
            return whatIsIt.Letter;
        }
        // 0-9
        if (compare >= 48 && compare <= 57) {
            return whatIsIt.Digit;
        }
        // " "
        if (compare == 32) {
            return  whatIsIt.Space;
        }
        
        for (int i = 0; i < puncArray.length; i++) {
            if (compare == puncArray[i]) {
                return  whatIsIt.PuncChar;
            }
        }
       
        return whatIsIt.SpecChar;
    }

}