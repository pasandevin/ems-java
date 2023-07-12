import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagementUI {

    private final EmployeeDAO employeeDAO;
    private final Scanner scanner;

    public EmployeeManagementUI(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
        scanner = new Scanner(System.in);
    }
    public void start() {

        int choice;

        do {
            printChoices();
            choice = scanner.nextInt();

            if(choice == 1) {
                Employee employee = getEmployeeDetailsFromUser();
                employeeDAO.addEmployee(employee);

            } else if (choice == 2) {
                int id = getEmployeeIdFromUser();
                try {
                    Employee employee = employeeDAO.getEmployeeById(id);
                    printEmployeeDetails(employee);
                } catch (EmployeeNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } else if (choice == 3) {
                Employee employee = getEmployeeDetailsFromUser();
                employeeDAO.updateEmployee(employee);

            } else if (choice == 4) {
                int id = getEmployeeIdFromUser();
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

        } while (choice != 6);
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

    private Employee getEmployeeDetailsFromUser() {
        int id = getEmployeeIdFromUser();
        System.out.println("Enter Employee Name");
        String name = scanner.next();
        System.out.println("Enter Employee Age");
        int age = scanner.nextInt();
        System.out.println("Enter Employee Department");
        String department = scanner.next();
        return new Employee(id, name, age, department);
    }

    private int getEmployeeIdFromUser() {
        System.out.println("Enter Employee ID");
        int id = scanner.nextInt();
        return id;
    }
}
