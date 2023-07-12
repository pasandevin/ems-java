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
        System.out.println(UIConstants.ASK_CHOICE);
        System.out.println(UIConstants.CHOICE_1);
        System.out.println(UIConstants.CHOICE_2);
        System.out.println(UIConstants.CHOICE_3);
        System.out.println(UIConstants.CHOICE_4);
        System.out.println(UIConstants.CHOICE_5);
        System.out.println(UIConstants.CHOICE_6);
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
