import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabase {

    private static Connection connection;

    private SQLDatabase() {
    }

    public static Connection getDBConnection() {
        if(connection == null) {
            connection = new SQLDatabase().createDBConnection();
        }
        return connection;
    }

    public Connection createDBConnection()  {
        String jdbcUrl = System.getenv("JDBC_URL");
        String username = System.getenv("USER_NAME");
        String password = System.getenv("PASSWORD");

        if(jdbcUrl == null || username == null || password == null) {
            throw new RuntimeException("Environment variables are not set");
        }

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the SQL database", e);
        }
    }
}
