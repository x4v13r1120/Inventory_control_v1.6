package Restaurant;

public class Employee {
    //attributes
    private int employeeNum;
    private String employee_first_name;
    private String employee_last_name;
    private String password;
    private boolean boolManager;

    //this is to check is the user is a manger or not
    public boolean checkPermission() {
        return false;
    }

    //getters and setters
    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getManager() {
        return boolManager;
    }

    public void setManager(boolean manager) {
        this.boolManager = manager;
    }

    public String getEmployee_last_name() {
        return employee_last_name;
    }

    public void setEmployee_last_name(String employee_last_name) {
        this.employee_last_name = employee_last_name;
    }

    public String getEmployee_first_name() {
        return employee_first_name;
    }

    public void setEmployee_first_name(String employee_first_name) {
        this.employee_first_name = employee_first_name;
    }
}