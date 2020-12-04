import Restaurant.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mangement.inventoryManagement;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;


public class viewItemController {
    private static Connection con;
    protected ObservableList<Item> data;
    @FXML
    private TableView<Item> inventory;
    @FXML
    private TableColumn<Item, String> item_name;
    @FXML
    private TableColumn<Item, Integer> item_id;
    @FXML
    private TableColumn<Item, BigDecimal> price_per_unit;
    @FXML
    private TableColumn<Item, String> item_type;
    @FXML
    private TableColumn<Item, Integer> quantity;

    @FXML
    public void Ret(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_inventory_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }

    public void buildData() {
        data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * from item ";
            ResultSet rs = con.createStatement().executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                Item item = new Item();
                item.setName(rs.getString("item_name"));
                item.setIdNumber(rs.getInt("item_id"));
                item.setItem_type(rs.getString("item_type"));
                item.setPricePerUnit(rs.getBigDecimal("price_per_unit"));
                item.setQuantity(rs.getInt("quantity"));
                data.add(item);

            }
            inventory.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @FXML
    public void initialize() {
        assert inventory != null;

        item_name.setCellValueFactory(new PropertyValueFactory<Item, String>("item_name"));
        item_id.setCellValueFactory(new PropertyValueFactory<Item, Integer>("item_id"));
        price_per_unit.setCellValueFactory(new PropertyValueFactory<Item, BigDecimal>("price_per_unit"));
        item_type.setCellValueFactory(new PropertyValueFactory<Item, String>("item_type"));
        quantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));

        inventoryManagement manager = new inventoryManagement();

        try {
            con = manager.getConnection();
            buildData();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
