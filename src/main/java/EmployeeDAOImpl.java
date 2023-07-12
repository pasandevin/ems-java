import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    Connection dbConnection;

    EmployeeDAOImpl() {
        dbConnection = SQLDatabase.getDBConnection();
    }


    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (id, name, age, department) VALUES (?, ?, ?, ?)";

        // Creating a prepared statement with the query
        PreparedStatement statement;
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
                System.out.println("Employee added successfully!");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException, SQLException {

        // SQL query to retrieve an employee
        String sql = "SELECT id, name, age, department FROM employee WHERE id = ?";

        // Creating a prepared statement with the query
        PreparedStatement statement = dbConnection.prepareStatement(sql);

        // Setting the employee ID parameter
        statement.setInt(1, employeeId);

        // Executing the query
        ResultSet resultSet = statement.executeQuery();

        Employee employee;

        // Processing the result set
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String department = resultSet.getString("department");
            employee = new Employee(employeeId, name, age, department);
            return employee;
        } else {
            resultSet.close();
            throw new EmployeeNotFoundException("No employee with the given id found in the database");
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

        // SQL query to update an employee
        String sql = "UPDATE employee SET name = ?, age = ?, department = ? WHERE id = ?";

        try {
            // Creating a prepared statement with the query
            PreparedStatement statement = dbConnection.prepareStatement(sql);

            // Setting the parameters
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setString(3, employee.getDepartment());
            statement.setInt(4, employee.getId());

            // Executing the query
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("No employee found with the specified ID.");
            }

            // Closing the statement and connection
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        // SQL query to delete an employee
        String sql = "DELETE FROM employee WHERE id = ?";

        try {
            // Creating a prepared statement with the query
            PreparedStatement statement = dbConnection.prepareStatement(sql);

            // Setting the employee ID parameter
            int employeeId = id; // Replace with the ID of the employee you want to delete
            statement.setInt(1, employeeId);

            // Executing the query
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("No employee found with the specified ID.");
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException, EmployeeNotFoundException {
        // SQL query to retrieve all employees
        String sql = "SELECT id, name, age, department FROM employee";

        ArrayList<Employee> employees = new ArrayList<Employee>();

        try {
            // Creating a prepared statement with the query
            PreparedStatement statement = dbConnection.prepareStatement(sql);

            // Executing the query
            ResultSet resultSet = statement.executeQuery();

            // Processing the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String department = resultSet.getString("department");
                Employee employee = new Employee(id, name, age, department);
                employees.add(employee);
            }

            // Closing the result set, statement, and connection
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw e;
        }

        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException("No employees found in the database");
        }
        return employees;
    }
}
