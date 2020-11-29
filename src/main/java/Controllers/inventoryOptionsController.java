package Controllers;

import Restaurant.Inventory;
import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mangement.inventoryManagement;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class inventoryOptionsController  implements Initializable {

    @FXML
    public Button add,del,edit,view,ret;

    @FXML
    public void Add(ActionEvent event) throws Exception{

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO


    }
}

