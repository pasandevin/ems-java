import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int id) throws SQLException;
    void updateEmployee(Employee employee);
    void deleteEmployee(int id) throws SQLException;
    List<Employee> getAllEmployees();

}
