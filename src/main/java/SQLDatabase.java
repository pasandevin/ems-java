import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabase implements Database{
    public void getDBConnection(){
        String jdbcUrl = "jdbc:mysql://localhost:8889/ems";
        String username = "root";
        String password = "root";

        try {
            // Establishing a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Perform database operations here

            // Closing the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error establishing connection to the database");
        }
    }
}
