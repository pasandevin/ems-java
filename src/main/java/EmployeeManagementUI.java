import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagementUI {

    private final EmployeeDAO employeeDAO;

    public EmployeeManagementUI(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    public void start() {
        int choice = 0;

        while ( choice !=6) {
            printChoices();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            if(choice == 1) {
                System.out.println("Enter Employee ID");
                int id = scanner.nextInt();
                System.out.println("Enter Employee Name");
                String name = scanner.next();
                System.out.println("Enter Employee Age");
                int age = scanner.nextInt();
                System.out.println("Enter Employee Department");
                String department = scanner.next();
                Employee employee = new Employee(id, name, age, department);
                employeeDAO.addEmployee(employee);
            } else if (choice == 2) {
                System.out.println("Enter Employee ID");
                int id = scanner.nextInt();
                try {
                    Employee employee = employeeDAO.getEmployeeById(id);
                    printEmployeeDetails(employee);
                } catch (EmployeeNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (choice == 3) {
                System.out.println("Enter Employee ID");
                int id = scanner.nextInt();
                System.out.println("Enter Employee Name");
                String name = scanner.next();
                System.out.println("Enter Employee Age");
                int age = scanner.nextInt();
                System.out.println("Enter Employee Department");
                String department = scanner.next();
                Employee employee = new Employee(id, name, age, department);
                employeeDAO.updateEmployee(employee);
            } else if (choice == 4) {
                System.out.println("Enter Employee ID");
                int id = scanner.nextInt();
                employeeDAO.deleteEmployee(id);
            } else if (choice == 5) {
                try {
                    for (Employee employee : employeeDAO.getAllEmployees()) {
                        printEmployeeDetails(employee);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (EmployeeNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void printChoices() {
        System.out.println("Enter What you want to do");
        System.out.println("1. Add Employee");
        System.out.println("2. Get Employee by ID");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Get All Employees");
        System.out.println("6. Exit");
    }
    private void printEmployeeDetails(Employee employee) {
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Age: " + employee.getAge());
        System.out.println("Employee Department: " + employee.getDepartment());
    }
}
