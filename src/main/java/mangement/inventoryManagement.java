package mangement;

import java.math.BigDecimal;
import java.sql.*;


/**
 * Code is from SQLite tutorials
 * Update, Delete, Search, and Add
 * As well as a connection setup to the Database
 */

public class inventoryManagement {

    /**
     * Connect to the database
     *
     * @return the Connection object
     */
    public Connection getConnection() {
        // SQLite connection string
        String url = "jdbc:sqlite:D:\\IdeaProjects\\inventory_Control_v1.6\\src\\database\\inventory";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String sql = "SELECT * FROM item";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                rs.getString("item_name");
                rs.getInt("item_id");
                rs.getDouble("price_per_unit");
                rs.getString("item_type");
                rs.getInt("quantity");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Insert a new row into the items table
     *
     * @param item_name
     * @param price_per_unit
     * @param item_type
     * @param quantity
     */
    public void add(String item_name, BigDecimal price_per_unit, String item_type, Integer quantity) {
        String sql = "INSERT INTO item(item_name, item_Id,price_per_unit,item_type,quantity) VALUES(?,?,?,?,?)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item_name);
            pstmt.setBigDecimal(3, price_per_unit);
            pstmt.setString(4, String.valueOf(item_type));
            pstmt.setInt(5, quantity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update data of a item specified by the id
     *
     * @param item_name
     * @param price_per_unit
     * @param item_type
     * @param quantity
     */
    public void update(Integer item_Id, String item_name, BigDecimal price_per_unit, String item_type, Integer quantity) {
        String sql = "UPDATE item SET item_name = ? , price_per_unit = ?, item_type = ?, quantity = ?" +
                " WHERE item_Id = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param

            pstmt.setString(1, item_name);
            pstmt.setBigDecimal(2, price_per_unit);
            pstmt.setString(3, item_type);
            pstmt.setInt(4, quantity);
            pstmt.setInt(5, item_Id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete a item specified by the id
     *
     * @param item_Id
     */
    public void delete(Integer item_Id) {
        String sql = "DELETE FROM item WHERE item_Id = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, item_Id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
