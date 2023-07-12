import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        //create employee
        Employee employee = new Employee("1", "John Doe", 30, "IT");
        employeeDAO.addEmployee(employee);
    }
}