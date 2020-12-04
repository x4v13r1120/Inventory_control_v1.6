import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class employeeOptionController {
    @FXML
    public Button add;
    @FXML
    public Button del;
    @FXML
    public Button edit;
    @FXML
    public Button view;
    @FXML
    public Button ret;

    @FXML
    public void Add(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("add_employee.fxml"));
        stage.setScene(new Scene(root, 325, 275));
        stage.show();

    }

    @FXML
    public void Del(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("del_employee.fxml"));
        stage.setScene(new Scene(root, 325, 275));
        stage.show();

    }

    @FXML
    public void Edit(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("edit_employee.fxml"));
        stage.setScene(new Scene(root, 325, 275));
        stage.show();

    }


    @FXML
    public void Ret(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }

    @FXML
    public void View(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("view_employee.fxml"));

        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }
}
