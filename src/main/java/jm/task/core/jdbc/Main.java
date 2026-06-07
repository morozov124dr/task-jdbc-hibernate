package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Света", "Бубнова", (byte) 17);
        System.out.println("User с именем – Света добавлен в базу данных");

        userService.saveUser("Настя", "Воронина", (byte) 37);
        System.out.println("User с именем – Настя добавлен в базу данных");

        userService.saveUser("Галя", "Донцова", (byte) 47);
        System.out.println("User с именем – Галя добавлен в базу данных");

        userService.saveUser("Игнат", "Теплов", (byte) 77);
        System.out.println("User с именем – Игнат добавлен в базу данных");


        List<User> users = userService.getAllUsers();

        for(User user: users){
            System.out.println(users);
        }

        userService.cleanUsersTable();


        userService.dropUsersTable();





    }
}
