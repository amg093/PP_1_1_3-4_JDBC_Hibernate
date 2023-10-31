package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("name1", "lastName1", (byte) 1);
        userService.saveUser("name2", "lastName2", (byte) 2);
        userService.saveUser("name3", "lastName3", (byte) 3);
        userService.saveUser("name4", "lastName4", (byte) 4);
        userService.createProcedure();
        userService.removeUserById(1);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
