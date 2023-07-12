package constants;

public abstract class SQLQueryConstants {
    public static final String INSERT_EMPLOYEE = "INSERT INTO employee (id, name, age, department) VALUES (?, ?, ?, ?)";
    public static final String GET_EMPLOYEE_BY_ID = "SELECT id, name, age, department FROM employee WHERE id = ?";
    public static final String UPDATE_EMPLOYEE = "UPDATE employee SET name = ?, age = ?, department = ? WHERE id = ?";
    public static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employee WHERE id = ?";
    public static final String GET_ALL_EMPLOYEES = "SELECT id, name, age, department FROM employee";
}
