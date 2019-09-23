
package homework9_2;

import java.util.Scanner;


public class HomeWork9_2 {
static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choose = 0;
        boolean flag = true;
        String[][] contacts = new String[0][3];



        while (flag) {
            System.out.println("Книга контактов");
            System.out.println("1 - просмотреть текущие контакты");
            System.out.println("2 - добавить новый контакт");
            System.out.println("3 - удалить уже существующий контакт");
            System.out.println("0 - выход");
            System.out.print("Введите номер команды:");
            choose = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choose) {
                case 1:
                    if (contacts.length == 0) {
                        System.out.println("Список контактов пуст\n");
                    } else {
                        lookAtBook(contacts);
                    }
                    break;
                case 2:
                    contacts = addNew(contacts);
                    break;
                case 3:
                    int delIdx = -1;
                    boolean cond = false;
                    if (contacts.length == 0) {
                        System.out.println("Список контактов пуст\n");
                    } else {
                        do {
                            System.out.print("Введите индекс удаляемого контакта:");
                            delIdx = sc.nextInt();
                            cond = !(delIdx > 0 && delIdx <= contacts.length);
                            if (cond) {
                                System.out.println("Ошибка! Неверный индекс");
                            }
                        } while(cond);
                        contacts = deleteCont(contacts, (delIdx - 1));
                    }
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Ошибка! Неверно введен номер команды");
                    break;
            }
        }
    }

    public static void lookAtBook(String[][] contacts) {
        
        int max1 = 2, max2 = 4, max3 = 5;

        
        for (int i = 0; i < contacts.length; i++) {
            if (("" + i).length() > max1) {
                max1 = ("" + i).length();
            }
            if (contacts[i][0].length() > max2) {
                max2 = contacts[i][0].length();
            }
            if (contacts[i][1].length() > max3) {
                max3 = contacts[i][1].length();
            }
        }

        System.out.print("№");
        for (int i = 0; i < max1 - "№".length() + 1; i++) {
            System.out.print(" ");
        }
        System.out.print("name");
        for (int i = 0; i < max2 - "name".length() + 1; i++) {
            System.out.print(" ");
        }
        System.out.print("phone");
        for (int i = 0; i < max3 - "phone".length() + 1; i++) {
            System.out.print(" ");
        }
        System.out.println("email");

        for (int i = 0; i < contacts.length; i++) {
            System.out.print((i + 1));
            for (int j = 0; j < max1 - ("" + (i + 1)).length() + 2; j++) {
                System.out.print(" ");
            }
            System.out.print(contacts[i][0]);
            for (int j = 0; j < max2 - contacts[i][0].length() + 1; j++) {
                System.out.print(" ");
            }
            System.out.print(contacts[i][1]);
            for (int j = 0; j < max3 - contacts[i][1].length() + 1; j++) {
                System.out.print(" ");
            }
            System.out.print(contacts[i][2]);
            System.out.println();
        }
        System.out.println();
    }

    public static String[][] addNew(String[][] contacts) {
        String[][] temp = new String[contacts.length + 1][3];
        for (int i = 0; i < contacts.length; i++) {
            temp[i][0] = contacts[i][0];
            temp[i][1] = contacts[i][1];
            temp[i][2] = contacts[i][2];
        }
        contacts = new String[contacts.length + 1][3];
        for (int i = 0; i < contacts.length - 1; i++) {
            contacts[i][0] = temp[i][0];
            contacts[i][1] = temp[i][1];
            contacts[i][2] = temp[i][2];
        }
        contacts[contacts.length - 1][0] = getValidName();
        contacts[contacts.length - 1][1] = getValidPhone();
        contacts[contacts.length - 1][2] = getValidEmail();
        System.out.println("контакт №" + contacts.length + " добавлен\n");
        return  contacts;
    }

    public static String[][] deleteCont(String[][] contacts, int delIdx) {
        String[][] temp = new String[contacts.length - 1][3];
        
        for (int i = 0, j = 0; i < contacts.length; i++, j++) {
            if (i == delIdx) {
                j--;
                continue;
            }
            temp[j][0] = contacts[i][0];
            temp[j][1] = contacts[i][1];
            temp[j][2] = contacts[i][2];
        }
        contacts = new String[contacts.length - 1][3];
        for (int i = 0; i < contacts.length; i++) {
            contacts[i][0] = temp[i][0];
            contacts[i][1] = temp[i][1];
            contacts[i][2] = temp[i][2];
        }
        System.out.println("контакт №" + (delIdx + 1) + " удален\n");
        return contacts;
    }

    public static String getValidName() {
        String temp = "";
        boolean isValid = false;
        do {
            System.out.print("Введите имя:");
            temp = sc.nextLine();
            isValid = validateName(temp);
            if (!isValid) {
                System.out.println("Ошибка! Неправильно введено имя");
            }
        } while(!isValid);
        return temp;
    }

    public static boolean validateName(String line) {
        char[] array = line.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if ((int)array[i] < 65 || (int)array[i] > 90 && (int)array[i] < 97 || (int)array[i] > 122 ) {
                if ((int)array[i] != 32 && (int)array[i] != 45) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String getValidPhone() {
        String temp = "";
        boolean isValid = false;
        do {
            System.out.print("Введите номер телефона:");
            temp = sc.nextLine();
            isValid = validatePhone(temp);
            if (!isValid) {
                System.out.println("Ошибка! Неправильно введен номер телефона");
            }
        } while(!isValid);
        return temp;
    }

    public static boolean validatePhone(String line) {
        char[] array = line.toCharArray();
        char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
        int isDigit = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (array[i] == digits[j]) {
                    isDigit++;
                }
            }
            if (isDigit < 1) {
                return false;
            }
            isDigit = 0;
        }
        if (array.length > 12 || array.length < 10) {
            return false;
        }
        return true;
    }

    public static String getValidEmail() {
        String temp = "";
        boolean isValid = false;
        do {
            System.out.print("Введите email(оставьте пустым, если нету email):");
            temp = sc.nextLine();
            isValid = validateEmail(temp);
            if (!isValid) {
                System.out.println("Ошибка! Неправильно введен email");
            }
        } while(!isValid);
        return temp;
    }

    public static boolean validateEmail(String line) {
    
        if (line.length() == 0) {
            return true;
        }
        char[] array = line.toCharArray();
        String word1 = "", word2 = "", word3 = "";
        int dogIdx = -1, countDog = 0, dotIdx = -1, countDot = 0, notLetterCount = 0;
        for (int i = 0; i < array.length; i++) {
            if ((int)array[i] < 65 || (int)array[i] > 90 && (int)array[i] < 97 || (int)array[i] > 122) {
                notLetterCount++;
            }
            if (array[i] == '@') {
                dogIdx = i;
                countDog++;
            }
            if (array[i] == '.') {
                dotIdx = i;
                countDot++;
            }
        }
        if (countDog > 1 || countDot > 1) {
            return false;
        }
        if (notLetterCount > 2) {
            return false;
        }
        for (int i = 0; i < dogIdx; i++) {
            word1 += array[i];
        }
        for (int i = dogIdx + 1; i < dotIdx; i++) {
            word2 += array[i];
        }
        for (int i = dotIdx + 1; i < array.length; i++) {
            word3 += array[i];
        }
        if (word1.length() == 0 || word2.length() == 0 || word3.length() == 0) {
            return false;
        }
        return true;
    }
}
