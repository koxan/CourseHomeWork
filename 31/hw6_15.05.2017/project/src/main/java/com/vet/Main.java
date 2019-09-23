package com.vet;

import java.sql.*;
import java.util.Properties;
import java.util.concurrent.CyclicBarrier;

// результат после работы 100 потоков получаем отличный от предполагаемых 10000
// для решения проблемы потерь данных, нужно соеденить в транзакции три, проводимые операции, расскоментировав
// последующие комментарии в коде

public class Main {
    private final static int COUNT_THREADS = 100;
    static String sqlConnection;
    static Properties prop;

    static {
        sqlConnection = "jdbc:mysql://localhost/hw6";
        prop = new Properties();
        prop.put("user", "root");
        prop.put("pass", "");
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sqlConnection, prop);
            Statement st = conn.createStatement();
            st.execute("UPDATE count SET amount = 10000 WHERE id = 1");
            ResultSet rs = st.executeQuery(MyThread.sqlQuerySelectAmount);
            rs.next();
            System.out.println("amount start = " + rs.getInt("amount"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        CyclicBarrier barrier = new CyclicBarrier(COUNT_THREADS);
        MyThread[] myThreads = new MyThread[COUNT_THREADS];
        Thread[] threads = new Thread[COUNT_THREADS];
        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i] = new MyThread(barrier);
            threads[i] = new Thread(myThreads[i], "Thread " + i);
            threads[i].start();
        }

        try {
            for (int i = 10; i > 0; i--) {
                Thread.sleep(1000);
                System.out.println("wait " + i + " seconds");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(MyThread.sqlQuerySelectAmount);
            rs.next();
            int amount = rs.getInt("amount");
            System.out.println("amount at end = " + amount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
         finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end");
    }
}
