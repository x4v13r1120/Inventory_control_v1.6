import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class inventoryOptionsController {

    @FXML
    public void Add(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("add_item.fxml"));
        stage.setScene(new Scene(root, 325, 275));
        stage.show();

    }

    @FXML
    public void Del(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("del_item.fxml"));
        stage.setScene(new Scene(root, 325, 275));
        stage.show();
    }

    @FXML
    public void Edit(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("edit_item.fxml"));
        stage.setScene(new Scene(root, 325, 275));
        stage.show();

    }

    @FXML
    public void View(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("view_item.fxml"));
        stage.setScene(new Scene(root, 500, 400));
        stage.show();


    }

    @FXML
    public void Ret(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }

}

