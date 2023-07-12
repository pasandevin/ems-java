import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int id);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> getAllEmployees();

}
