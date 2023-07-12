public class Main {
    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.initDBConnection();
    }
}