package RestaurantMenu.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import RestaurantMenu.service.MainService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller {
    private final static MainService mainService = new MainService();
    private final static Scanner scanner = new Scanner(System.in);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane MainPane;

    @FXML
    private MenuBar Menu;

    @FXML
    private Menu ClientMenu;

    @FXML
    private MenuItem CreateClient;

    @FXML
    private MenuItem ChooseClient;

    @FXML
    private ListView<String> MenuList = new ListView<String>(FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python"));


    @FXML
    void initialize() {
        /*var menu = mainService.
        MenuList = mainService.showPersonalMenu()*/
        var a = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
        MenuList.setItems(a);


    }


    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AppView.fxml"));
        primaryStage.setTitle("Меню ресторана");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setMinWidth(300);
        primaryStage.setMinHeight(300);
        primaryStage.show();
    }
}
