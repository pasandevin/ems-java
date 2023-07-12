import constants.UIConstants;

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
            System.out.println(UIConstants.WELCOME_MSG);
            choice = scanner.nextInt();
            Employee employee;
            int id;

            switch (choice) {
                case 1:
                    employee = getEmployeeDetailsFromUser();
                    employeeDAO.addEmployee(employee);
                    break;

                case 2:
                    id = getEmployeeIdFromUser();
                    try {
                        employee = employeeDAO.getEmployeeById(id);
                        printEmployeeDetails(employee);
                    } catch (EmployeeNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    employee = getEmployeeDetailsFromUser();
                    employeeDAO.updateEmployee(employee);
                    break;

                case 4:
                    id = getEmployeeIdFromUser();
                    employeeDAO.deleteEmployee(id);
                    break;

                case 5:
                    try {
                        for (Employee employeeIterator : employeeDAO.getAllEmployees()) {
                            printEmployeeDetails(employeeIterator);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (EmployeeNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    System.out.println(UIConstants.EXIT_MSG);
                    scanner.close();
                    break;

                default:
                    System.out.println(UIConstants.INVALID_CHOICE_MSG);
                    break;
            }

        } while (choice != 6);
    }

    private void printEmployeeDetails(Employee employee) {
        System.out.println(UIConstants.PRINT_ID + employee.getId());
        System.out.println(UIConstants.PRINT_NAME + employee.getName());
        System.out.println(UIConstants.PRINT_AGE + employee.getAge());
        System.out.println(UIConstants.PRINT_DEPARTMENT+ employee.getDepartment());
    }

    private Employee getEmployeeDetailsFromUser() {
        int id = getEmployeeIdFromUser();
        System.out.println(UIConstants.ASK_NAME);
        String name = scanner.next();
        System.out.println(UIConstants.ASK_AGE);
        int age = scanner.nextInt();
        System.out.println(UIConstants.ASK_DEPARTMENT);
        String department = scanner.next();
        return new Employee(id, name, age, department);
    }

    private int getEmployeeIdFromUser() {
        System.out.println(UIConstants.ASK_ID);
        int id = scanner.nextInt();
        return id;
    }
}
