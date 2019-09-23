package com.company;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String findLine = "";
        File file = null, foundedFile = null;
        byte choose = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("1 - поиск только первого совпадения");
            System.out.println("2 - поиск всех совпадений");
            System.out.print("Введите команду:");

            try {
                choose = Byte.parseByte(sc.nextLine());
                switch (choose) {
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        System.err.println("Ошибка! команда должна быть 1 или 2.");
                        continue;
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.err.println("Ошибка! Неверный ввод.");
            }
        }

        System.out.print("Введите строку поиска:");
        findLine = sc.nextLine();

        try {
            file = FileUtil.getFileFromDialog();
        } catch (CancelOptionChooseException e) {
            System.err.println(e.getMessage());
            choose = -1;
        }

        switch (choose) {
            case 1:
                if (file != null) {
                    foundedFile = FileUtil.searchByContent(file, findLine);
                }

                System.out.println("Искомая строка \"" + findLine + "\" из директории\\файла " + file);
                if (foundedFile != null) {
                    System.out.println("\tнайденно в файле - " + foundedFile);
                } else {
                    System.out.println("\tне найдена");
                }
                break;
            case 2:
                List<File> foundedFiles = FileUtil.searchByContentSecondVariant(file, findLine);
                System.out.println("Искомая строка \"" + findLine + "\" из директории\\файла " + file);
                if (foundedFiles.size() != 0) {
                    for (File current : foundedFiles) {
                        System.out.println("\tнайденно в файле - " + current);
                    }
                } else {
                    System.out.println("\tне найдена");
                }
                break;
            default:
                System.out.println("Конец программы.");
                break;
        }


    }
}
