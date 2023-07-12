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
        statement.setInt(1, 2); // Employee id
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
        statement.close();
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {

        // SQL query to update an employee
        String sql = "UPDATE employee SET name = ?, age = ?, department = ? WHERE id = ?";

        // Creating a prepared statement with the query
        PreparedStatement statement = dbConnection.prepareStatement(sql);

        // Setting the parameters
        statement.setString(1, "New Name"); // New name for the employee
        statement.setInt(2, 35); // New age for the employee
        statement.setString(3, "New Department"); // New department for the employee
        statement.setInt(4, 1); // ID of the employee to update

        // Executing the query
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("No employee found with the specified ID.");
        }

        // Closing the statement and connection
        statement.close();
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
        statement.close();
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        // SQL query to retrieve all employees
        String sql = "SELECT id, name, age, department FROM employee";

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

            // Print or use the retrieved employee data as needed
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Department: " + department);
            System.out.println("------------------------");
        }

        // Closing the result set, statement, and connection
        resultSet.close();
        statement.close();
        return null;
    }
}
