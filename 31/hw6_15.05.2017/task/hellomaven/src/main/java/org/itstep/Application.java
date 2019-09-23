package org.itstep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by shaptala on 15.05.2017.
 */
public class Application {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/people", "root", "");
            connection.setAutoCommit(false); // отменить автоматические тразакции
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            Statement stm = connection.createStatement();

            String sql1 = "insert into city(name) values ('XXXXXXX');";
            String sql2 = "insert into city(name) values ('DDDDDDD');";
            try {
                stm.executeUpdate(sql1);
                ex();
                stm.executeUpdate(sql2);
            } catch (Exception ex) {
                connection.rollback();
            }finally {
                connection.commit();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void ex() throws Exception {
        throw new Exception("some ex");
    }
}
