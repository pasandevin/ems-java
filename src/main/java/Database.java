import java.sql.Connection;

public interface Database {
    Connection createDBConnection();
}
