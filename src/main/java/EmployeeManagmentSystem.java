import java.sql.SQLException;
import java.util.List;

public class EmployeeManagmentSystem {
    public static void main(String[] args) throws SQLException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        //create employee
//        Employee employee = new Employee("1", "John Doe", 30, "IT");
//        employeeDAO.addEmployee(employee);
        //get employee by id

//        Employee employee = new Employee("1", "John Doe", 30, "IT");
//         employeeDAO.updateEmployee(employee);
        List<Employee> employees = employeeDAO.getAllEmployees();
    }
}