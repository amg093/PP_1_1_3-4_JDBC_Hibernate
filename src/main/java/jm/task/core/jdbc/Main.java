package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("name1", "lastName1", (byte) 1);
        userService.saveUser("name2", "lastName2", (byte) 2);
        userService.saveUser("name3", "lastName3", (byte) 3);
        userService.saveUser("name4", "lastName4", (byte) 4);
        userService.removeUserById(1);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
