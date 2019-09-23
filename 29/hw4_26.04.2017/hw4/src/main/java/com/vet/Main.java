package com.vet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ToDoList toDoList = new ToDoList();
        byte choose = -1;
        Scanner sc = new Scanner(System.in);
        boolean isPlay = true;

        while (isPlay) {
            System.out.println("\n0 - выход");
            System.out.println("1 - вывести все записи таблицы");
            System.out.println("2 - добавить категорию");
            System.out.println("3 - удалить категорию");
            System.out.println("4 - добавить задачу");
            System.out.println("5 - удалить задачу");
            System.out.println("6 - обновить задачу");
            System.out.print("Введите команду:");

            String tempChoose = sc.nextLine();
            try {
                choose = Byte.parseByte(tempChoose);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка! Неверная команда.");
                continue;
            }

            System.out.println();
            switch (choose) {
                case 0:
                    System.out.println("Bye");
                    isPlay = false;
                    break;
                case 1:
                    toDoList.showAllEntries();
                    break;
                case 2:
                    toDoList.addCategory();
                    break;
                case 3:
                    toDoList.deleteCategory();
                    break;
                case 4:
                    toDoList.addTask();
                    break;
                case 5:
                    toDoList.deleteTask();
                    break;
                case 6:
                    toDoList.updateTask();
                    break;
                default:
                    System.err.println("Ошибка! Нет такой команды.");
                    break;
            }
        }

        toDoList.saveDB();
    }
}
