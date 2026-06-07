package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String LOGIN = "postgres";
    public static final String PASSWORD = "postgres";

    public static Connection getConnection() {


        try {
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к БД", e);
        }
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory()
        {

        if (sessionFactory==null){
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.connection.url",URL);
                configuration.setProperty("hibernate.connection.username",LOGIN);
                configuration.setProperty("hibernate.connection.password",PASSWORD);
                configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                configuration.setProperty("hibernate.show_sql", "true");
                configuration.setProperty("hibernate.format_sql", "true");
                configuration.setProperty("hibernate.hbm2ddl.auto", "none");
                configuration.addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();

            }
            catch (Throwable ex){
                throw new ExceptionInInitializerError("Ошибка создания SessionFactory: " + ex);
            }
        }
        return sessionFactory;
    }
}




