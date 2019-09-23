package org.itstep;
import java.sql.*;

public class JdbcStart {
    public static void main(String[] args) {
        //
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // строка подключения
            // localhost или 127.0.0.1 - это текущая машина
            String connectionString = "jdbc:mysql://localhost";
            // устанавливаем соединение с базой данных
            Connection connection = DriverManager.getConnection(connectionString, "root", "");
            // Создаем объект для выполнения sql запросов на сервере
            Statement statement = connection.createStatement();

            statement.execute("use people;");
            // sql запрос
//            String sql = "INSERT INTO city(name) VALUES('New York');";
//            // выполенение простого запроса
//            int rows = statement.executeUpdate(sql);
//            if(rows > 0) {
//                System.out.println("Query OK, " + rows + " row affected");
//            }

            // выполнение запроса на выборку данных
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("person_id") + ") " +
                                   resultSet.getString(2) + " " +
                                   resultSet.getString("last_name") + " " +
                                   resultSet.getString("email") + " " +
                                   resultSet.getInt("city_id"));

            }

            System.out.println("OK");
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Бибиотека Connector/J не найдена");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Проблема поключения к базе данных");
            e.printStackTrace();
        }
    }
}
