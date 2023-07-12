import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabase implements Database{
    public Connection getDBConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:8889/ems";
        String username = "root";
        String password = "root";


            // Establishing a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);


            return connection;

    }
}
