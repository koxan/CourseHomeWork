package com.vet;

import java.sql.*;
import java.util.Properties;

public class Main {
    private static String sqlConnection;
    private static Properties prop;

    static {
        sqlConnection = "jdbc:mysql://localhost/hw7";
        prop = new Properties();
        prop.put("user", "root");
        prop.put("pass", "");
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sqlConnection, prop);

            CallableStatement prepStProcedure = conn.prepareCall("CALL add_film(?, ?, ?, ?, ?," +
                    "?," +
                    "?, ?, ?, ?," +
                    "?, ?, ?, ?)");
            prepStProcedure.setString(1, "Экстрасенсы");
            prepStProcedure.setString(2, "2017-06-01");
            prepStProcedure.setFloat(3, 6.6f);
            prepStProcedure.setString(4, "Доктор-экстрасенс Джон Клэнси работает вместе со специальным агентом ФБР");
            prepStProcedure.setString(5, "01:20:00");
            prepStProcedure.setString(6, "Драмы");
            prepStProcedure.setString(7, "Энтони");
            prepStProcedure.setString(8, "Хопкинс");
            prepStProcedure.setString(9, "Американец");
            prepStProcedure.setString(10, "1950-01-01");
            prepStProcedure.setString(11, "Афонсо");
            prepStProcedure.setString(12, "Пойарт");
            prepStProcedure.setString(13, "Португалец");
            prepStProcedure.setString(14, "1960-01-01");
            prepStProcedure.execute();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT m.Title, m.ReleaseYear, m.Rating, m.Plot, m.MovieLength, g.GenreName, a.LastName AS Actor, d.LastName AS Director FROM Movies AS m\n" +
                                           "INNER JOIN Genres AS g, Actors AS a, Directors AS d, MovieActor AS ma, MovieGenres AS mg\n" +
                                           "WHERE m.DirectorID = d.DirectorID AND\n" +
                                           "      m.MovieID = mg.MovieID AND g.GenreID = mg.GenreID AND\n" +
                                           "      a.ActorID = ma.ActorID AND m.MovieID = ma.MovieID;\n");
            ResultSetMetaData rsMeta = rs.getMetaData();
            int colCount = rsMeta.getColumnCount();
            for (int i = 1; i <= colCount; i++) {
                System.out.print(rsMeta.getColumnLabel(i) + "   ");
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= colCount; i++) {
                    System.out.print(rs.getObject(i) + "   ");
                }
                System.out.println();
            }

            rs = st.executeQuery("SELECT Birth FROM Actors LIMIT 1");
            rs.next();
            String actorAgeLine = rs.getString(1);

            CallableStatement prepStFunction = conn.prepareCall("{? = CALL calc_age(?)}");
            prepStFunction.setString(2, actorAgeLine);
            prepStFunction.registerOutParameter(1, Types.INTEGER);
            prepStFunction.execute();
            int actorAge = prepStFunction.getInt(1);
            System.out.println("Actor's age = " + actorAge);

            rs = st.executeQuery("SELECT Birth FROM Directors LIMIT 1");
            rs.next();
            String directorAgeLine = rs.getString(1);

            prepStFunction = conn.prepareCall("{? = CALL calc_age(?)}");
            prepStFunction.setString(2, directorAgeLine);
            prepStFunction.registerOutParameter(1, Types.INTEGER);
            prepStFunction.execute();
            int directorAge = prepStFunction.getInt(1);
            System.out.println("Director's age = " + directorAge);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
