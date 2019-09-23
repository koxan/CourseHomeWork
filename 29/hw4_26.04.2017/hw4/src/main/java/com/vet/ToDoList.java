package com.vet;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class ToDoList {
    private ArrayList<Task> tasks;
    private ArrayList<Category> categories;
    private ArrayList<Status> statuses;
//    private ArrayList<Task> deletedTasks;
//    private ArrayList<Category> deletedCategories;
//    private ArrayList<Task> updatedTasks;

    private String connectionString;
    private Properties prop;
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    private SimpleDateFormat sdfFull;
    private SimpleDateFormat sdfLite;

    private final byte NOT_CHANGED = 0;
    private final byte DELETED = 1;
    private final byte UPDATED = 2;
    private final byte DELETED_NEW = 3;

    public ToDoList() {
        tasks = new ArrayList<>();
        categories = new ArrayList<>();
        statuses = new ArrayList<>();
//        deletedTasks = new ArrayList<>();
//        deletedCategories = new ArrayList<>();
//        updatedTasks = new ArrayList<>();

        connectionString = "jdbc:mysql://127.0.0.1:3306/";
        prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "");
        conn = null;
        st = null;
        rs = null;

        sdfFull = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        sdfLite = new SimpleDateFormat("yyyy-mm-dd");

        loadDB();
    }

    public void showAllEntries() {
        System.out.println("Категории:");
        System.out.println("id\tимя");
        for (Category current : categories) {
            if (current.deleted == DELETED || current.deleted == DELETED_NEW) {
                continue;
            }
            System.out.println(current);
        }

        System.out.println("Статусы:");
        System.out.println("id\tимя");
        for (Status current : statuses) {
            System.out.println(current);
        }

        System.out.println("Задачи:");
        System.out.println("id\tназвание\tописание\tкатегория\tдата создания\tдата старта\tдата окончания\tстатус");
        for (Task current : tasks) {
            if (current.deleted == DELETED || current.deleted == DELETED_NEW) {
                continue;
            }
            System.out.println(current);
        }
    }

    public void addCategory() {
        Scanner sc = new Scanner(System.in);
        String categoryName = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Введите имя категории:");
            categoryName = sc.nextLine();

            if (categoryName.isEmpty()) {
                System.err.println("Ошибка! Ввели пустую строку.");
                continue;
            }
            isValid = true;

            boolean isHere = false;
            for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).name.equals(categoryName)) {
                    isHere = true;
                    break;
                }
            }

            if (isHere) {
                System.err.println("Ошибка! Такая категория уже есть.");
            } else {
                int lastCategoryId = -1;
                if (categories.size() > 0) {
                    lastCategoryId = categories.get(categories.size() - 1).id + 1;
                } else {
                    lastCategoryId = 1;
                }
                Category category = new Category(lastCategoryId, categoryName);
                categories.add(category);
                System.out.println(categoryName + " добавлена");
            }
        }
    }

    public void deleteCategory() {
        if (categories.size() < 1) {
            System.err.println("Ошибка! Нету категорий.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int categoryId = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Введите id категории:");
            String inputLine = sc.nextLine();

            if (inputLine.isEmpty()) {
                System.err.println("Ошибка! Ввели пустую строку.");
                continue;
            }

            try {
                categoryId = Integer.parseInt(inputLine);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка! Неверный ввод.");
                continue;
            }

            if (categoryId < 1 || categoryId > categories.size()) {
                System.err.println("Ошибка! Неверный id.");
                continue;
            }
            isValid = true;
        }

        boolean isHere = false;
        for (int i = 0; i < categories.size(); i++) {
            Category current = categories.get(i);
            if (current.id == categoryId) {
                isHere = true;
                System.out.println(current.name + " удален.");
                categories.remove(i);
                break;
            }
        }

        if (!isHere) {
            System.err.println("Ошибка! Такой категории нету.");
        }
    }

    public void addTask() {
        if (categories.size() < 1) {
            System.err.println("Ошибка! Нету категорий");
            return;
        }

        Task task = getTask();
        int id = tasks.size() + 1;
        task.id = id;
        tasks.add(task);
        System.out.println(task.title + " добавлена.");
    }

    private Task getTask() {
        Scanner sc = new Scanner(System.in);

        String title = "";
        String description = "";
        String category = "";
        int category_id = -1;
        Date created = null;
        Date date_start = null;
        Date date_end = null;
        String status = "";
        int status_id = -1;

        boolean isValid = false;

        while (!isValid) {
            System.out.print("Введите название задачи:");
            title = sc.nextLine();

            if (title.isEmpty()) {
                System.err.println("Ошибка! Пустая строка.");
                continue;
            }

            System.out.print("Введите описание задачи(опционально):");
            description = sc.nextLine();

            System.out.print("Введите название категории:");
            category = sc.nextLine();

            if (category.isEmpty()) {
                System.err.println("Ошибка! Пустая строка.");
                continue;
            }

            boolean isHere = false;
            for (int i = 0; i < categories.size(); i++) {
                Category current = categories.get(i);
                if (current.name.equals(category)) {
                    isHere = true;
                    category_id = current.id;
                    break;
                }
            }
            if (!isHere) {
                System.err.println("Ошибка! Нет такой категории.");
                continue;
            }

            created = new Date();

            System.out.print("Введите дату старта задачи:");
            String date_start_line = sc.nextLine();
            if (date_start_line.isEmpty()) {
                System.err.println("Ошибка! Пустая строка.");
                continue;
            }
            try {
                date_start = sdfLite.parse(date_start_line);
            } catch (ParseException e) {
                System.err.println("Ошибка! Неверно введена дата.");
                continue;
            }

            System.out.print("Введите дату окончания задачи:");
            String date_end_line = sc.nextLine();
            if (date_end_line.isEmpty()) {
                System.err.println("Ошибка! Пустая строка.");
                continue;
            }
            try {
                date_end = sdfLite.parse(date_end_line);
            } catch (ParseException e) {
                System.err.println("Ошибка! Неверно введена дата.");
                continue;
            }

            System.out.print("Введите название статуса задачи:");
            status = sc.nextLine();

            if (status.isEmpty()) {
                System.err.println("Ошибка! Пустая строка.");
                continue;
            }

            isHere = false;
            for (int i = 0; i < statuses.size(); i++) {
                Status current = statuses.get(i);
                if (current.name.equals(status)) {
                    isHere = true;
                    status_id = current.id;
                    break;
                }
            }
            if (!isHere) {
                System.err.println("Ошибка! Нет такого статуса.");
                continue;
            }
            isValid = true;
        }

        return new Task(-1, title, description, category_id, created, date_start, date_end, status_id);
    }

    public void deleteTask() {
        if (tasks.size() < 1) {
            System.err.println("Ошибка! Нету задач.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int taskId = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Введите id задачи:");
            String inputLine = sc.nextLine();

            if (inputLine.isEmpty()) {
                System.err.println("Ошибка! Ввели пустую строку.");
                continue;
            }

            try {
                taskId = Integer.parseInt(inputLine);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка! Неверный ввод.");
                continue;
            }

            if (taskId < 1 || taskId > tasks.size()) {
                System.err.println("Ошибка! Неверный id.");
                continue;
            }
            isValid = true;
        }

        boolean isHere = false;
        for (int i = 0; i < tasks.size(); i++) {
            Task current = tasks.get(i);
            if (current.id == taskId) {
                isHere = true;
                System.out.println(current.title + " удален.");
                tasks.remove(i);
                break;
            }
        }

        if (!isHere) {
            System.err.println("Ошибка! Такой задачи нету.");
        }
    }

    public void updateTask() {
        if (tasks.size() < 1) {
            System.err.println("Ошибка! Нету задач.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int id = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Введите id:");
            String inputLine = sc.nextLine();

            if (inputLine.isEmpty()) {
                System.err.println("Ошибка! Пустая строка.");
                continue;
            }

            try {
                id = Integer.parseInt(inputLine);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка! Неверный ввод.");
                continue;
            }
            if (id < 1) {
                System.err.println("Ошибка! Неверный ввод.");
                continue;
            }

            boolean isHere = false;
            for (int i = 0; i < tasks.size(); i++) {
                Task current = tasks.get(i);
                if (current.id == id) {
                    isHere = true;
                    break;
                }
            }

            if (!isHere) {
                System.err.println("Ошибка! Нет такого id.");
                continue;
            }

            isValid = true;
        }

        Task task = getTask();
        task.id = id;
        for (int i = 0; i < tasks.size(); i++) {
            Task current = tasks.get(i);
            if (current.id == id) {
                tasks.set(i, task);
                break;
            }
        }

        System.out.println(task.title + " обновлен.");
    }

    private void loadDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionString, prop);
            st = conn.createStatement();

            String[] structureSql = readStructureSql();
            for (int i = 0; i < structureSql.length; i++) {
                st.addBatch(structureSql[i]);
            }
            st.executeBatch();

            rs = st.executeQuery("SELECT * FROM task");
            loadTask(rs);
            rs = st.executeQuery("SELECT * FROM category");
            loadCategory(rs);
            rs = st.executeQuery("SELECT * FROM status");
            loadStatus(rs);
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

    public void saveDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionString, prop);
            st = conn.createStatement();

            String sqlCommand = "USE to_do_list;";
            st.execute(sqlCommand);

//            for (int i = 0; i < deletedCategories.size(); i++) {
//                Category current = deletedCategories.get(i);
//                String command = "DELETE FROM category WHERE id = " + current.id;
//                st.execute(command);
//            }
//
//            for (int i = 0; i < deletedTasks.size(); i++) {
//                Task current = deletedTasks.get(i);
//                String command = "DELETE FROM task WHERE id = " + current.id;
//                st.execute(command);
//            }
//
//            for (int i = 0; i < updatedTasks.size(); i++) {
//                Task current = updatedTasks.get(i);
//                String command = "UPDATE task SET title = '" + current.title + "', description = '" + current.description
//                               + "', category_id = " + current.category_id + "', created = '"
//                               + sdfFull.format(current.created) + "', date_start = '" + sdfLite.format(current.date_start)
//                               + "', date_end = '" + sdfLite.format(current.date_end) + "', status_id = "
//                               + current.status_id + "' WHERE id = " + current.id;
//                st.execute(command);
//            }

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

    private void loadTask(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Task currentTask = new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6)
                    , rs.getDate(7), rs.getInt(8), (byte) rs.getInt(9));
            tasks.add(currentTask);
        }
    }

    private void loadCategory(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Category currentCategory = new Category(rs.getInt(1), rs.getString(2), (byte) rs.getInt(3));
            categories.add(currentCategory);
        }
    }

    private void loadStatus(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Status currentStatus = new Status(rs.getInt(1), rs.getString(2));
            statuses.add(currentStatus);
        }
    }

    private String[] readStructureSql() {
        String[] resultArray = null;
        List<String> result = new ArrayList<>();
        String sqlLine = "";

        try (InputStream in = new FileInputStream("structure.sql");
             Reader reader = new InputStreamReader(in);
             BufferedReader buffReader = new BufferedReader(reader)) {
            String temp = "";
            while ((temp = buffReader.readLine()) != null) {
                sqlLine += temp;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка! Файл не найден.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        resultArray = sqlLine.split(";");
        return resultArray;
    }


    private class Task implements Comparable<Task> {
        private int id;
        private String title;
        private String description;
        private int category_id;
        private Date created;
        private Date date_start;
        private Date date_end;
        private int status_id;
        private byte deleted;

        public Task(int id, String title, String description, int category_id, Date created, Date date_start, Date date_end, int status_id) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.category_id = category_id;
            this.created = created;
            this.date_start = date_start;
            this.date_end = date_end;
            this.status_id = status_id;
            this.deleted = NOT_CHANGED;
        }

        public Task(int id, String title, String description, int category_id, Date created, Date date_start, Date date_end, int status_id, byte changed) {
            this(id, title, description, category_id, created, date_start, date_end, status_id);
            this.deleted = changed;
        }

        @Override
        public int compareTo(Task o) {
            return this.id - o.id;
        }

        @Override
        public String toString() {
            String category = "";
            String status = "";
            for (int i = 0; i < categories.size(); i++) {
                Category current = categories.get(i);
                if (current.id == category_id) {
                    category = current.name;
                    break;
                }
            }
            for (int i = 0; i < statuses.size(); i++) {
                Status current = statuses.get(i);
                if (current.id == status_id) {
                    status = current.name;
                    break;
                }
            }
            return id + "\t" + title + "\t" + description + "\t" + category + "\t" + sdfFull.format(created) +
                        "\t" + sdfLite.format(date_start) + "\t" + sdfLite.format(date_end) + "\t" + status;
        }
    }

    private class Category implements Comparable<Category> {
        private int id;
        private String name;
        private byte deleted;

        public Category(int id, String name) {
            this.id = id;
            this.name = name;
            this.deleted = NOT_CHANGED;
        }

        public Category(int id, String name, byte changed) {
            this(id, name);
            this.deleted = changed;
        }

        @Override
        public int compareTo(Category o) {
            return this.id - o.id;
        }

        @Override
        public String toString() {
            return id + "\t" + name;
        }
    }

    private class Status implements Comparable<Status> {
        private int id;
        private String name;

        public Status(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(Status o) {
            return this.id - o.id;
        }

        @Override
        public String toString() {
            return id + "\t" + name;
        }
    }
}
