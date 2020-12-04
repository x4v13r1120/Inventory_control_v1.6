import Restaurant.Employee;
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

import java.sql.Connection;

public class viewEmployeeController {
    private static Connection con;
    protected ObservableList<Employee> data;

    @FXML
    private TableView<Employee> workforce;
    @FXML
    private TableColumn<Employee, String> employee_first_name;
    @FXML
    private TableColumn<Employee, String> employee_last_name;
    @FXML
    private TableColumn<Employee, Integer> employee_id;


    @FXML
    public void Ret(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_employee_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }

    @FXML
    public void initialize() {
        assert workforce != null;

        employee_first_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("Employee_name"));
        employee_last_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("Employee_type"));
        employee_id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Employee_id"));

        inventoryManagement manager = new inventoryManagement();

        try {
            con = manager.getConnection();
            manager.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
