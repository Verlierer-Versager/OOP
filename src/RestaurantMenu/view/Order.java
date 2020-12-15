package RestaurantMenu.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Order {
    private String order;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea OrderArea = new TextArea("HELP");

    @FXML
    void initialize() {
        OrderArea.setText("aaaaaa" +order);
    }

    public void start(String order) {
        Parent root = null;
        this.order = order;
        try {
            root = FXMLLoader.load(getClass().getResource("fxml/Order.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ваш заказ");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OrderArea.setText(OrderArea.getText() +order);
    }
}
