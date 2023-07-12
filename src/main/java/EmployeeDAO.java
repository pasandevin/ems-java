import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int employeeId) throws SQLException, EmployeeNotFoundException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int employeeId) throws SQLException;
    List<Employee> getAllEmployees() throws SQLException;

}
