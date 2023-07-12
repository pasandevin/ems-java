import java.sql.SQLException;
import java.util.List;

public class EmployeeManagmentSystem {
    public static void main(String[] args) {


        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        //add employee
//        Employee employee1 = new Employee(5, "hello Doe", 30, "IT");
//        employeeDAO.addEmployee(employee1);

        //delete employee
//        employeeDAO.deleteEmployee(5);

        //update employee
//        Employee employee3 = new Employee(10, "John Doe up", 30, "IT");
//        employeeDAO.updateEmployee(employee3);




        //get employee by id
        try {
            Employee employee2;
            employee2 = employeeDAO.getEmployeeById(10);
            System.out.println(employee2.getName());
            System.out.println(employee2.getAge());
            System.out.println(employee2.getDepartment());
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        //get all employees
        try {
            List<Employee> employees;
            employees = employeeDAO.getAllEmployees();
            for (Employee employee : employees) {
                System.out.println(employee.getId());
                System.out.println(employee.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("Done");
    }
}