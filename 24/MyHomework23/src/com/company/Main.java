package com.company;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // ошибка при вводе "C:\" на моем пк(вопрос)

    public static void main(String[] args) {

        byte choose = -1;
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);

        while (!isValid) {
            try {
                System.out.print("Введите: \n1 - набрать путь файла вручную, \n2 - выбрать файл через меню:");
                choose = sc.nextByte();
                if (choose < 1 || choose > 2) {
                    System.err.println("Ошибка! Ввод должен быть 1 или 2.");
                } else {
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.err.println("Ошибка! Неверные данные.");
            }
        }

        Scanner sc2 = new Scanner(System.in);
        isValid = false;
        String line = "";
        long size = -1;
        switch (choose) {
            case 1:
                while (!isValid) {
                    System.out.print("Введите путь:");
                    line = sc2.nextLine();
                    try {
                        size = FileUtil.directorySize(line);
                        isValid = true;
                        System.out.println(FileUtil.getPathAndSizeMessage(line, size));
                    } catch (WrongPathException e) {
                        System.err.println(e.getMessage());
                    }
                }
                break;
            case 2:
                try {
                    File file = FileUtil.getFileFromDialog();
                    size = FileUtil.directorySize(file);
                    System.out.println(FileUtil.getPathAndSizeMessage(file, size));
                } catch (CancelOptionChooseException e) {
                    System.err.println(e.getMessage());
                }
                break;
        }
    }
}
