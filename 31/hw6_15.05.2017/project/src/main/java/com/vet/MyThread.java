package com.vet;

import java.sql.*;
import java.util.Properties;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {
    private CyclicBarrier barrier;
    public static String sqlQuerySelectAmount, sqlQueryChangeAmount, sqlConnection;
    private static Properties prop;

    static {
        sqlQuerySelectAmount = "SELECT amount FROM count WHERE id = 1";
        sqlQueryChangeAmount = "UPDATE count SET amount = ? WHERE id = 1";
        sqlConnection = Main.sqlConnection;
        prop = Main.prop;
    }

    public MyThread(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(sqlConnection, prop);
//            conn.setAutoCommit(false);
            Statement st = conn.createStatement();
            PreparedStatement prepSt = conn.prepareStatement(sqlQueryChangeAmount);
            ResultSet rs;
            int amount = -1;

            rs = st.executeQuery(sqlQuerySelectAmount);
            rs.next();
            amount = rs.getInt("amount");

            amount += 1000;
            prepSt.setInt(1, amount);
            prepSt.execute();

            amount -= 1000;
            prepSt.setInt(1, amount);
            prepSt.execute();

        } catch (SQLException e) {
//            try {
//                conn.rollback();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
            e.printStackTrace();
        } finally {
            try {
//                conn.commit();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
