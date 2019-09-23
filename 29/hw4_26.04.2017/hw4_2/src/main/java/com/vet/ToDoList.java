package com.vet;

import com.ibatis.common.jdbc.ScriptRunner;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ToDoList {
    private String sqlConnection;
    private Properties prop;
    private Connection conn;

    private Set<Task> tasks;
    private Set<Status> statuses;
    private Set<Category> categories;

    private final byte NOT_CHANGED = 0;
    private final byte DELETED = 1;
    private final byte UPDATED = 2;

    public ToDoList() {
        sqlConnection = "jdbc:mysql://localhost/";
        prop = new Properties();
        prop.put("user", "root");
        prop.put("pass", "");

        tasks = new TreeSet<>();
        statuses = new TreeSet<>();
        categories = new TreeSet<>();

        loadDB();
    }

    private Date getToday() {
        return new Date(System.currentTimeMillis());
    }

    private void loadDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sqlConnection, prop);

            executeStructureSql(conn);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM task");
            loadTask(rs);
            rs = st.executeQuery("SELECT * FROM status");
            loadStatus(rs);
            rs = st.executeQuery("SELECT * FROM category");
            loadCategory(rs);
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

    private void executeStructureSql(Connection conn) {
        ScriptRunner sr = new ScriptRunner(conn, false, false);
        try(Reader reader = new FileReader("structure.sql");
            Reader reader2 = new FileReader("test_inserts.sql")) {
            sr.runScript(reader);
            System.out.println("executed structure.sql");
            sr.runScript(reader2);
            System.out.println("executed test_inserts.sql");
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTask(ResultSet rs) {
        int id;
        String title;
        String description;
        int category_id;
        Timestamp created;
        Date date_start;
        Date date_end;
        int status_id;
        byte deleted;
        Task task;
        try {
            while (rs.next()) {
                id = rs.getInt("id");
                title = rs.getString("title");
                description = rs.getString("description");
                if (description == null) {
                    description = "";
                }
                category_id = rs.getInt("category_id");
                created = rs.getTimestamp("created");
                date_start = rs.getDate("date_start");
                date_end = rs.getDate("date_end");
                status_id = rs.getInt("status_id");
                deleted = rs.getByte("deleted");
                task = new Task(id, title, description, category_id, created, date_start, date_end,
                        status_id, deleted);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadStatus(ResultSet rs) {
        int id;
        String name;
        Status status;
        try {
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                status = new Status(id, name);
                statuses.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadCategory(ResultSet rs) {
        int id;
        String name;
        byte deleted;
        Category category;
        try {
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                deleted = rs.getByte("deleted");
                category = new Category(id, name, deleted);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAll() {
        showStatuses();
        showCategories();
        showTasks();
    }

    private void showStatuses() {
        int id_l;

        int max_id = -1;

        for (Status current : statuses) {
            id_l = String.valueOf(current.getId()).length();
            if (id_l > max_id) {
                max_id = id_l;
            }
        }

        System.out.println("Статусы:");
        for (Status current : statuses) {
            int id = current.getId();
            String name = current.getName();
            System.out.print(id);
            for (int i = 0; i < max_id + 1; i++) {
                System.out.print(" ");
            }
            System.out.println(name);
        }
        System.out.println();
    }

    private void showCategories() {
        int id_l;

        int max_id = -1;

        for(Category current : categories) {
            if(current.getDeleted() == 0) {
                id_l = String.valueOf(current.getId()).length();

                if (id_l > max_id) {
                    max_id = id_l;
                }
            }

        }

        System.out.println("Категории:");
        for (Category current : categories) {
            if (current.getDeleted() == 0) {
                int id = current.getId();
                String name = current.getName();

                System.out.print(id);
                for (int i = 0; i < max_id - String.valueOf(id).length() + 1; i++) {
                    System.out.print(" ");
                }
                System.out.println(name);
            }
        }
        System.out.println();
    }

    private void showTasks() {
        int id_l;
        int title_l;
        int description_l;
        int category_l;
        int created_l;
        int date_start_l;
        int date_end_l;

        int max_id = -1;
        int max_title = -1;
        int max_description = -1;
        int max_category = -1;
        int max_created = -1;
        int max_date_start = -1;
        int max_date_end = -1;
        for (Task current : tasks) {
            if (current.getDeleted() == 0) {
                id_l = String.valueOf(current.getId()).length();
                title_l = current.getTitle().length();
                description_l = current.getDescription().length();
                int tempCategoryId = current.getCategory_id();
                String tempCategoryName = "";
                for(Category currentInner : categories) {
                    if (current.getId() == tempCategoryId) {
                        tempCategoryName = currentInner.getName();
                        break;
                    }
                }
                category_l = tempCategoryName.length();
                created_l = current.getCreated().toString().length();
                date_start_l = current.getDate_start().toString().length();
                date_end_l = current.getDate_end().toString().length();

                if (id_l > max_id) {
                    max_id = id_l;
                }
                if (title_l > max_title) {
                    max_title = title_l;
                }
                if (description_l > max_description) {
                    max_description = description_l;
                }
                if (category_l > max_category) {
                    max_category = category_l;
                }
                if (created_l > max_created) {
                    max_created = created_l;
                }
                if (date_start_l > max_date_start) {
                    max_date_start = date_start_l;
                }
                if (date_end_l > max_date_end) {
                    max_date_end = date_end_l;
                }
            }
        }

        System.out.println("Задачи:");
        for (Task current : tasks) {
            if (current.getDeleted() == 0) {
                int id = current.getId();
                String title = current.getTitle();
                String description = current.getDescription();
                int category_id = current.getCategory_id();
                String categoryName = "";
                for(Category currentInner : categories) {
                    if (currentInner.getId() == category_id) {
                        categoryName = currentInner.getName();
                        break;
                    }
                }
                Timestamp created = current.getCreated();
                Date date_start = current.getDate_start();
                Date date_end = current.getDate_end();
                int status_id = current.getStatus_id();
                String statusName = "";
                for(Status currentInner : statuses) {
                    if (currentInner.getId() == status_id) {
                        statusName = currentInner.getName();
                        break;
                    }
                }

                System.out.print(id);
                for (int i = 0; i < max_id - String.valueOf(id).length() + 1; i++) {
                    System.out.print(" ");
                }
                System.out.print(title);
                for (int i = 0; i < max_title - title.length() + 1; i++) {
                    System.out.print(" ");
                }
                System.out.print(description);
                for (int i = 0; i < max_description - description.length() + 1; i++) {
                    System.out.print(" ");
                }
                System.out.print(categoryName);
                for (int i = 0; i < max_category - categoryName.length() + 1; i++) {
                    System.out.print(" ");
                }
                System.out.print(created);
                for (int i = 0; i < max_created - created.toString().length() + 1; i++) {
                    System.out.print(" ");
                }
                System.out.print(date_start);
                for (int i = 0; i < max_date_start - date_start.toString().length() + 1; i++) {
                    System.out.print(" ");
                }
                System.out.print(date_end);
                for (int i = 0; i < max_date_end - date_end.toString().length() + 1; i++) {
                    System.out.print(" ");
                }
                System.out.println(statusName);
            }
        }
        System.out.println();
    }

    public void addTask() {
//        id INT PRIMARY KEY AUTO_INCREMENT,
//        title VARCHAR(255) NOT NULL,
//        description TEXT,
//        category_id INT,
//        created TIMESTAMP,
//        date_start DATE,
//        date_end DATE,
//        status_id INT,

        String title = "";
        String description = "";
        String categoryName = "";
        int category_id = -1;
        Timestamp timestamp = null;
        Date date_start = null;
        Date date_end = null;
        String statusName = "";
        int status_id = -1;

        Date todayDate = getToday();

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите название задачи:");
        title = sc.nextLine();
        if (title.isEmpty()) {
            System.err.println("Ошибка! Пустое поле.");
            return;
        }

        System.out.print("Введите описание(опционально):");
        description = sc.nextLine();

        System.out.print("Введите название категории:");
        categoryName = sc.nextLine();
        if (categoryName.isEmpty()) {
            System.err.println("Ошибка! Пустое поле.");
            return;
        }

        boolean isHere = false;
        for (Category current : categories) {
            if (current.getName().equals(categoryName)) {
                isHere = true;
                category_id = current.getId();
                break;
            }
        }
        if (!isHere) {
            System.err.println("Ошибка! Нет такой категории.");
            return;
        }

        System.out.print("Введите дату начала задачи:");
        String date_start_line = sc.nextLine();
        if (date_start_line.isEmpty()) {
            System.err.println("Ошибка! Пустое поле.");
            return;
        }
        try {
            date_start = Date.valueOf(date_start_line);
            if (date_start.compareTo(todayDate) < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка! Неверная дата.");
            return;
        }

        System.out.print("Введите дату окончания задачи:");
        String date_end_line = sc.nextLine();
        if (date_end_line.isEmpty()) {
            System.err.println("Ошибка! Пустое поле.");
            return;
        }
        try {
            date_end = Date.valueOf(date_end_line);
            if (date_end.compareTo(date_start) < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка! Неверная дата.");
            return;
        }

        System.out.print("Введите статус задачи:");
        statusName = sc.nextLine();
        if (statusName.isEmpty()) {
            System.err.println("Ошибка! Пустое поле.");
            return;
        }
        isHere = false;
        for (Status current : statuses) {
            if (current.getName().equals(statusName)) {
                isHere = true;
                status_id = current.getId();
                break;
            }
        }
        if (!isHere) {
            System.err.println("Ошибка! Нет такого статуса.");
            return;
        }

        int id = -1;
        if (tasks.size() == 0) {
            id = 1;
        } else {
            Iterator<Task> iterator = tasks.iterator();
            Task lastTask = null;
            while(iterator.hasNext()) {
                lastTask = iterator.next();
            }
            id = lastTask.getId() + 1;
        }

        timestamp = new Timestamp(System.currentTimeMillis());
        Task task = new Task(id, title, description, category_id, timestamp, date_start, date_end, status_id, (byte) 0);
        tasks.add(task);
    }

    public void addCategory() {
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите название категории:");
        name = sc.nextLine();
        if (name.isEmpty()) {
            System.err.println("Ошибка! Пустая строка");
            return;
        }

        for(Category current : categories) {
            if (current.getName().equals(name)) {
                System.err.println("Ошибка! Такая категория уже есть.");
                return;
            }
        }

        int id = -1;
        if (categories.size() == 0) {
            id = 1;
        } else {
            Iterator<Category> iterator = categories.iterator();
            Category lastCategory = null;
            while(iterator.hasNext()) {
                lastCategory = iterator.next();
            }
            id = lastCategory.getId() + 1;
        }

        Category category = new Category(id, name, (byte) 0);
        categories.add(category);
    }

    public void deleteTask() {
        if (tasks.size() == 0) {
            System.err.println("Ошибка! Нет задач.");
            return;
        }

        int delId;
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите id задачи:");
        try {
            delId = getDelId(sc);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка! Неверно введен id.");
            return;
        }

        boolean isHere = false;
        for (Task current : tasks) {
            if (current.getId() == delId) {
                isHere = true;
                current.setDeleted((byte) 1);
                current.setChanges(DELETED);
                return;
            }
        }
        if (!isHere) {
            System.err.println("Ошибка! Нет такого id.");
        }
    }

    public void deleteCategory() {
        if (categories.size() == 0) {
            System.err.println("Ошибка! Нет категорий.");
            return;
        }

        int delId;
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите id категории:");
        try {
            delId = getDelId(sc);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка! Неверно введен id.");
            return;
        }

        boolean isHere = false;
        for (Category current : categories) {
            if (current.getId() == delId) {
                isHere = true;
                current.setDeleted((byte) 1);
                current.setChanges(DELETED);
                return;
            }
        }
        if (!isHere) {
            System.err.println("Ошибка! Нет такого id.");
        }
    }

    private int getDelId(Scanner sc) throws NumberFormatException {
        int delId = -1;
        String inputLine = sc.nextLine();
        if (inputLine.isEmpty()) {
            throw new NumberFormatException();
        }
        delId = Integer.parseInt(inputLine);
        if (delId < 1) {
            throw new NumberFormatException();
        }
        return delId;
    }

    public void close() {
        saveDB();
    }

    private void saveDB() {
        // del -1 id
        System.out.println("saveDB");
    }

    private class Task implements Comparable<Task> {
        private int id;
        private String title;
        private String description;
        private int category_id;
        private Timestamp created;
        private Date date_start;
        private Date date_end;
        private int status_id;
        private byte deleted;
        private byte changes;

        public Task(int id, String title, String description, int category_id, Timestamp created, Date date_start, Date date_end, int status_id, byte deleted) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.category_id = category_id;
            this.created = created;
            this.date_start = date_start;
            this.date_end = date_end;
            this.status_id = status_id;
            this.deleted = deleted;
            this.changes = NOT_CHANGED;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public int getCategory_id() {
            return category_id;
        }

        public Timestamp getCreated() {
            return created;
        }

        public Date getDate_start() {
            return date_start;
        }

        public Date getDate_end() {
            return date_end;
        }

        public int getStatus_id() {
            return status_id;
        }

        public byte getDeleted() {
            return deleted;
        }

        public byte getChanges() {
            return changes;
        }

        public void setDeleted(byte deleted) {
            this.deleted = deleted;
        }

        public void setChanges(byte changes) {
            this.changes = changes;
        }

        @Override
        public int compareTo(Task o) {
            return this.getId() - o.getId();
        }

        @Override
        public String toString() {
            return getId() + " " + getTitle() + " " + getDescription() + " " + getCategory_id()
                    + " " + getCreated() + " " + getDate_start() + " " + getDate_end()
                    + " " + getStatus_id();
        }
    }

    private class Status implements Comparable<Status> {
        private int id;
        private String name;

        public Status(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Status o) {
            return this.getId() - o.getId();
        }
    }

    private class Category implements Comparable<Category> {
        private int id;
        private String name;
        private byte deleted;
        private byte changes;

        public Category(int id, String name, byte deleted) {
            this.id = id;
            this.name = name;
            this.deleted = deleted;
            this.changes = NOT_CHANGED;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public byte getDeleted() {
            return deleted;
        }

        public byte getChanges() {
            return changes;
        }

        public void setDeleted(byte deleted) {
            this.deleted = deleted;
        }

        public void setChanges(byte changes) {
            this.changes = changes;
        }

        @Override
        public int compareTo(Category o) {
            return this.getId() - o.getId();
        }
    }
}
