package com.vet;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date todayDate = new Date(System.currentTimeMillis());
        System.out.println("todayDate = " + todayDate);
//        2017-06-06
        Date date = Date.valueOf("2017-06-05");
        System.out.println("date = " + date);

        System.out.println("compare = " + date.compareTo(todayDate));

//        ToDoList toDoList = new ToDoList();
//        toDoList.showAll();
//        toDoList.deleteTask();
//        toDoList.deleteTask();
//        toDoList.deleteTask();
//        toDoList.showAll();
//        toDoList.close();

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Введите дату:");
//
//        String dateLine = sc.nextLine();
//        Date date = null;
//        try {
//            date = Date.valueOf(dateLine);
//            System.out.println(date);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }

//        String timeLine = sc.nextLine();
//        Timestamp timestamp = null;
//        try {
//            timestamp = Timestamp.valueOf(timeLine);
//            System.out.println(timestamp);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка! Неверный ввод.");
//        }

//        Connection conn = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/to_do_list", "root", "");
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM task");
//            rs.next();
//            Timestamp time = rs.getTimestamp(5);
//            System.out.print(time);
//            Date dateStart = rs.getDate(6);
//            System.out.print(" " + dateStart);
//            Date dateEnd = rs.getDate(7);
//            System.out.println(" " + dateEnd);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
