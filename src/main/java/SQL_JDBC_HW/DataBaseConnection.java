package SQL_JDBC_HW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    // Змінні для зберігання інформації про з'єднання з БД
    private String url = "jdbc:mysql://localhost:3306/SQL_HM_JDBC";
    // намагався зробити через змінні оточення, але не вдалося чомусь.
    private String username = System.getenv("MYSQL_USER");
    private String password = System.getenv("MYSQL_PASSWORD");

    public DataBaseConnection() {

    }
    // Конструктор класу для ініціалізації змінних
    public DataBaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Метод для підключення до БД та повернення з'єднання
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Unable to connect to database");
            throw e;
        }
        return conn;
    }

    // Метод для закриття з'єднання
    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Unable to close connection");
            }
        }
    }
}
