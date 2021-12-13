import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс конектится с бд
 */
public class MySQLConnection{

    private static Connection connection;

    static {
        String user = "root";//Логин пользователя
        String password = "Im1230255";//Пароль пользователя
        String url = "jdbc:mysql://localhost/planes_tracking_db";//URL адрес
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException
                | IllegalAccessException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}

