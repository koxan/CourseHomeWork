package org.itstep;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by shaptala on 15.05.2017.
 */
public class Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/people", "root", "12345");
            Scanner scanner = new Scanner(System.in);

            String sql = "select * from city";

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                             ResultSet.CONCUR_UPDATABLE);
            statement.execute(sql);
            ResultSet result = statement.getResultSet();

            ResultSetMetaData metaData = result.getMetaData();
            for(int i=1; i<metaData.getColumnCount()+1; i++) {
                System.out.format("%s [%s]  ", metaData.getColumnName(i), metaData.getColumnTypeName(i));
            }
            System.out.println();

            while (result.next()) {
                for(int i=1; i<metaData.getColumnCount() + 1; i++) {
                    System.out.format("%-15s", result.getObject(i).toString());
                }
                System.out.println();
            }

            System.out.print("Type new city: ");
            String city = scanner.nextLine();

            // вместо команды INSERT
            result.moveToInsertRow();
            result.updateString("name", city);
            result.insertRow();

            // вместо команды DELETE
            result.absolute(1);
            result.deleteRow();

            // вместо UPDATE
            result.last();
            result.updateString("name", "UPDATE THOUGHT CURSOR");
            result.updateRow();

            System.out.println("isAfterLast: " + result.isAfterLast());
            result.absolute(2);
            System.out.println("isAfterLast: " + result.isAfterLast());
            result.relative(-2);

            System.out.println("---------------------");
            while (result.next()) {
                result.refreshRow(); // обновить данные из базы если они были изменены
                for(int i=1; i<metaData.getColumnCount() + 1; i++) {
                    System.out.format("%-15s", result.getObject(i).toString());
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert connection != null;
            connection.close();
        }
    }
}
