import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class employeeOptionController {
    @FXML
    public void Add(ActionEvent event) throws Exception {


    }

    @FXML
    public void Del(ActionEvent event) throws Exception {


    }

    @FXML
    public void Edit(ActionEvent event) throws Exception {


    }

    @FXML
    public void View(ActionEvent event) throws Exception {


    }

    @FXML
    public void Ret(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }
}
