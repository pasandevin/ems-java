import java.sql.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    Connection dbConnection;

    EmployeeDAOImpl() throws SQLException {
        SQLDatabase sqlDatabase = new SQLDatabase();
        dbConnection= sqlDatabase.getDBConnection();
    }


    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (id, name, age, department) VALUES (?, ?, ?, ?)";

        // Creating a prepared statement with the query
        PreparedStatement statement = dbConnection.prepareStatement(sql);

        // Setting the values for the parameters
        statement.setInt(1, 1); // Employee id
        statement.setString(2, "John Doe"); // Employee name
        statement.setInt(3, 30); // Employee age
        statement.setString(4, "IT"); // Employee department

        // Executing the query
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Employee added successfully!");
        }
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {

        // SQL query to retrieve an employee
        String sql = "SELECT id, name, age, department FROM employee WHERE id = ?";

        // Creating a prepared statement with the query
        PreparedStatement statement = dbConnection.prepareStatement(sql);

        // Setting the employee ID parameter
        int employeeId = 1; // Replace with the desired employee ID
        statement.setInt(1, employeeId);

        // Executing the query
        ResultSet resultSet = statement.executeQuery();
        //convert resultset to employee object


        // Processing the result set
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String department = resultSet.getString("department");

            // Print or use the retrieved employee data as needed
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Department: " + department);
        } else {
            System.out.println("Employee not found.");

        }
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {


    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        // SQL query to delete an employee
        String sql = "DELETE FROM employee WHERE id = ?";

        // Creating a prepared statement with the query
        PreparedStatement statement = dbConnection.prepareStatement(sql);

        // Setting the employee ID parameter
        int employeeId = 1; // Replace with the ID of the employee you want to delete
        statement.setInt(1, employeeId);

        // Executing the query
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("No employee found with the specified ID.");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }
}
