import Restaurant.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mangement.employeeManagement;

public class editEmployeeController {
    @FXML
    public TextField employee_id;
    @FXML
    public TextField employee_first_name;
    @FXML
    public TextField employee_last_name;
    @FXML
    public CheckBox boolManager;
    @FXML
    public Label done;

    employeeManagement manager = new employeeManagement();

    @FXML
    public void Ret(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_employee_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }

    public void Ent(ActionEvent actionEvent) {
        Employee employee = new Employee();
        Integer q = Integer.parseInt(employee_id.getText().replaceAll(",", "."));
        employee.setEmployee_first_name(employee_first_name.getText());
        employee.setEmployee_last_name(employee_last_name.getText());
        employee.setEmployeeNum(q);
        employee.setManager(boolManager.isSelected());

        manager.update(employee.getEmployeeNum(), employee.getEmployee_first_name(), employee.getEmployee_last_name());
        done.setText("Employee Updated!");
    }
}
