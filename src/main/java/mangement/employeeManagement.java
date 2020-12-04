package mangement;

import java.sql.*;

public class employeeManagement {
    /**
     * Connect to the database
     *
     * @return the Connection object
     */
    public Connection getConnection() {
        // SQLite connection string
        String url = "jdbc:sqlite:D:\\IdeaProjects\\inventory_Control_v1.6\\src\\database\\employees";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * select all rows in the item table
     */
    public void selectAll() {
        String sql = "SELECT * FROM employee ";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                rs.getString("employee_first_name");
                rs.getString("employee_last_name");
                rs.getInt("employee_id");
                rs.getBoolean("boolManager");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Insert a new row into the items table
     *
     * @param first_name
     * @param last_name
     * @param boolManager
     */
    public void add(String first_name, String last_name, Boolean boolManager) {
        String sql = "INSERT INTO employee(first_name,last_name,boolManager) VALUES(?,?,?)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setBoolean(3, boolManager);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update data of a item specified by the id
     *
     * @param first_name
     * @param last_name
     * @param employee_id
     */
    public void update(int employee_id, String first_name, String last_name) {
        String sql = "UPDATE employee SET first_name = ? , last_name = ?" +
                " WHERE employee_id = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param

            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setInt(3, employee_id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete a item specified by the id
     *
     * @param employee_id
     */
    public void delete(int employee_id) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, employee_id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
