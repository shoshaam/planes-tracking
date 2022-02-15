package database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс конектится с бд
 */
public class MySQLConnection{

    private static Connection connection;

    private MySQLConnection(){
    }

    public static Connection getConnection(){
        if (connection == null){
            String url = "jdbc:mysql://localhost/planes_tracking_db";
            String username = "root";
            String password = "Im1230255";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException
                    | IllegalAccessException | NoSuchMethodException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}

