import Restaurant.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mangement.employeeManagement;

public class delEmployeeController {
    @FXML
    public TextField employee_id;
    @FXML
    public Label done;

    employeeManagement manager = new employeeManagement();

    @FXML
    public void Ent(ActionEvent event) throws Exception {
        try {
            Employee employee = new Employee();
            Integer q = Integer.parseInt(employee_id.getText().replaceAll(",", "."));
            employee.setEmployeeNum(q);
            manager.delete(q);
            done.setText("Employee Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Ret(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_employee_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }
}
