import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class managerOptionController {

    @FXML
    private void invPressed(ActionEvent event) throws IOException {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_inventory_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }

    @FXML
    private void empPressed(ActionEvent event) throws IOException {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_employee_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }
}
