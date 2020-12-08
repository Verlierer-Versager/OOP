package RestaurantMenu.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAppView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private StackPane stackPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller ctr = new Controller();
        ctr.start(primaryStage);
    }

    /*@Override
    public void init() {
        stackPane = new StackPane();
    }*/


}
