import Restaurant.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mangement.inventoryManagement;

public class delItemController {

    @FXML
    public TextField item_id;
    @FXML
    public Label done;

    inventoryManagement manager = new inventoryManagement();

    @FXML
    public void Ent(ActionEvent event) throws Exception {
        try {
            Item item = new Item();
            Integer q = Integer.parseInt(item_id.getText().replaceAll(",", "."));
            item.setIdNumber(q);
            manager.delete(q);
            done.setText("Item Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Ret(ActionEvent event) throws Exception {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("manager_inventory_options.fxml"));

        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }
}
