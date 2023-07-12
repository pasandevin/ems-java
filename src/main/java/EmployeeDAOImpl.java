import constants.DataAccessConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final Connection dbConnection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    EmployeeDAOImpl() {
        dbConnection = SQLDatabase.getDBConnection();
    }

    @Override
    public void addEmployee(Employee employee) {

        String sql = DataAccessConstants.INSERT_EMPLOYEE_QUERY;

        try {
            statement = dbConnection.prepareStatement(sql);

            // Setting the values for the parameters
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setInt(3, employee.getAge());
            statement.setString(4, employee.getDepartment());

            // Executing the query
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println(DataAccessConstants.INSERT_EMPLOYEE_SUCCESS_MSG);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException, SQLException {

        // SQL query to retrieve an employee
        String sql = DataAccessConstants.GET_EMPLOYEE_BY_ID_QUERY;

        // Creating a prepared statement with the query
        statement = dbConnection.prepareStatement(sql);

        // Setting the employee ID parameter
        statement.setInt(1, employeeId);

        // Executing the query
        resultSet = statement.executeQuery();

        Employee employee;

        // Processing the result set
        if (resultSet.next()) {
            String name = resultSet.getString(DataAccessConstants.EMPLOYEE_NAME_COLUMN);
            int age = resultSet.getInt(DataAccessConstants.EMPLOYEE_AGE_COLUMN);
            String department = resultSet.getString(DataAccessConstants.EMPLOYEE_DEPARTMENT_COLUMN);
            employee = new Employee(employeeId, name, age, department);

            // Closing the result set, and statement
            statement.close();
            resultSet.close();
        } else {

            // Throwing an exception if no employee with the given ID is found
            throw new EmployeeNotFoundException(DataAccessConstants.NO_EMPLOYEE_WITH_ID_ERR_MSG);
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {

        // SQL query to update an employee
        String sql = DataAccessConstants.UPDATE_EMPLOYEE_QUERY;

        try {

            // Creating a prepared statement with the query
            statement = dbConnection.prepareStatement(sql);

            // Setting the parameters
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setString(3, employee.getDepartment());
            statement.setInt(4, employee.getId());

            // Executing the query
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println(DataAccessConstants.UPDATE_EMPLOYEE_SUCCESS_MSG);
            } else {
                System.out.println(DataAccessConstants.NO_EMPLOYEE_WITH_ID_ERR_MSG);
            }

            // Closing the result set, and statement
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        // SQL query to delete an employee
        String sql = DataAccessConstants.DELETE_EMPLOYEE_BY_ID_QUERY;

        try {
            // Creating a prepared statement with the query
            statement = dbConnection.prepareStatement(sql);

            // Setting the employee ID parameter
            int employeeId = id; // Replace with the ID of the employee you want to delete
            statement.setInt(1, employeeId);

            // Executing the query
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(DataAccessConstants.DELETE_EMPLOYEE_SUCCESS_MSG);
            } else {
                System.out.println(DataAccessConstants.NO_EMPLOYEE_WITH_ID_ERR_MSG);
            }

            // Closing the result set, and statement
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException, EmployeeNotFoundException {
        // SQL query to retrieve all employees
        String sql = DataAccessConstants.GET_ALL_EMPLOYEES_QUERY;

        ArrayList<Employee> employees = new ArrayList<Employee>();

        try {
            // Creating a prepared statement with the query
            statement = dbConnection.prepareStatement(sql);

            // Executing the query
            resultSet = statement.executeQuery();

            // Processing the result set
            while (resultSet.next()) {
                int id = resultSet.getInt(DataAccessConstants.EMPLOYEE_ID_COLUMN);
                String name = resultSet.getString(DataAccessConstants.EMPLOYEE_NAME_COLUMN);
                int age = resultSet.getInt(DataAccessConstants.EMPLOYEE_AGE_COLUMN);
                String department = resultSet.getString(DataAccessConstants.EMPLOYEE_DEPARTMENT_COLUMN);
                Employee employee = new Employee(id, name, age, department);
                employees.add(employee);
            }

            // Closing the result set, and statement
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw e;
        }

        // Throwing an exception if no employees were found
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException(DataAccessConstants.ZERO_EMPLOYEES_ERR_MSG);
        }

        return employees;
    }
}
