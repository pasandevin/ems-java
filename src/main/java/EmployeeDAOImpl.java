import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }
}
