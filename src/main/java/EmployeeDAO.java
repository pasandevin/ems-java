import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int employeeId) throws SQLException, EmployeeNotFoundException;

    void updateEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    List<Employee> getAllEmployees() throws SQLException, EmployeeNotFoundException;

}
