import Restaurant.Item;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mangement.inventoryManagement;

import java.math.BigDecimal;


public class addItemController {

    @FXML
    public TextField item_name;
    @FXML
    public TextField item_type;
    @FXML
    public TextField price_per_unit;
    @FXML
    public TextField quantity;
    @FXML
    public Label done;


    inventoryManagement manager = new inventoryManagement();
    ObjectProperty<BigDecimal> money = new SimpleObjectProperty<BigDecimal>();


    @FXML
    public void Ent(ActionEvent event) throws Exception {
        try {
            Item item = new Item();
            Double d = Double.parseDouble(price_per_unit.getText().replaceAll(",", "."));
            BigDecimal b = BigDecimal.valueOf(d);
            Integer q = Integer.parseInt(quantity.getText().replaceAll(",", "."));
            item.setName(item_name.getText());
            item.setItem_type(item_type.getText());
            item.setPricePerUnit(b);
            item.setQuantity(q);

            manager.add(item.getName(), item.getPricePerUnit(), item.getItem_type(), item.getQuantity());
            done.setText("Item Added!");

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
