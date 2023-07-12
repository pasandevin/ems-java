package constants;

public abstract class DataAccessConstants {
    public static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO employee (id, name, age, department) VALUES (?, ?, ?, ?)";
    public static final String GET_EMPLOYEE_BY_ID_QUERY = "SELECT id, name, age, department FROM employee WHERE id = ?";
    public static final String UPDATE_EMPLOYEE_QUERY = "UPDATE employee SET name = ?, age = ?, department = ? WHERE id = ?";
    public static final String DELETE_EMPLOYEE_BY_ID_QUERY = "DELETE FROM employee WHERE id = ?";
    public static final String GET_ALL_EMPLOYEES_QUERY = "SELECT id, name, age, department FROM employee";

    public static final String EMPLOYEE_ID_COLUMN = "id";
    public static final String EMPLOYEE_NAME_COLUMN = "name";
    public static final String EMPLOYEE_AGE_COLUMN = "age";
    public static final String EMPLOYEE_DEPARTMENT_COLUMN = "department";

    public static final String INSERT_EMPLOYEE_SUCCESS_MSG = "Employee added successfully!";
    public static final String DELETE_EMPLOYEE_SUCCESS_MSG = "Employee deleted successfully!";
    public static final String UPDATE_EMPLOYEE_SUCCESS_MSG = "Employee updated successfully!";

    public static final String NO_EMPLOYEE_WITH_ID_ERR_MSG = "No employee with the given id found.";
    public static final String ZERO_EMPLOYEES_ERR_MSG = "No employees found in the database.";
}
