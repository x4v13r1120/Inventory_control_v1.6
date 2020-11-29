package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class managerOptionController implements Initializable {

    @FXML
    public Button inv,emp;

    @FXML
    public void clickButton(ActionEvent event) throws IOException{
        if (event.getSource()==inv) {
            Stage stage = Main.getPrimaryStage();

            Parent root = FXMLLoader.load(getClass().getResource("manager_inventory_options.fxml"));

            stage.setScene(new Scene(root, 300, 275));
            stage.show();
        }
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert inv != null;
        assert emp != null;
    }

}
