import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabase implements Database{

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
        String jdbcUrl = "jdbc:mysql://localhost:8889/ems";
        String username = "root";
        String password = "root";


        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the SQL database", e);
        }
    }
}
