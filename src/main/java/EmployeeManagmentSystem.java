import java.sql.SQLException;
import java.util.List;

public class EmployeeManagmentSystem {
    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        EmployeeManagementUI employeeManagementUI = new EmployeeManagementUI(employeeDAO);
        employeeManagementUI.start();
    }
}