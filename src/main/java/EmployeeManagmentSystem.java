import java.sql.SQLException;
import java.util.List;

public class EmployeeManagmentSystem {
    public static void main(String[] args) throws SQLException {


        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        //add employee
//        Employee employee1 = new Employee(4, "hello Doe", 30, "IT");
//        employeeDAO.addEmployee(employee1);

        //delete employee
//        employeeDAO.deleteEmployee(3);

        //get employee by id
//        try {
//            Employee employee2 = employeeDAO.getEmployeeById(10);
//            System.out.println(employee2.getName());
//            System.out.println(employee2.getAge());
//            System.out.println(employee2.getDepartment());
//        } catch (EmployeeNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        //update employee
//        Employee employee3 = new Employee(2, "John Doe up", 30, "IT");
//        employeeDAO.updateEmployee(employee3);

        //get all employees
        List<Employee> employees = employeeDAO.getAllEmployees();
        for(Employee employee : employees) {
            System.out.println(employee.getId());
            System.out.println(employee.getName());
        }
    }
}