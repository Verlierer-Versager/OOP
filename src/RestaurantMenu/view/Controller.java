package RestaurantMenu.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import RestaurantMenu.service.MainService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller {
    private static MainService mainService = new MainService();
    private Stage primaryStage;
    private long currentId;
    //private final static Scanner scanner = new Scanner(System.in);

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
    private ListView<String> MenuList;

    @FXML
    private Label MenuPositionLbl;

    @FXML
    private TextField PositionsField;

    @FXML
    private Button CheckoutBtn;


    @FXML
    void initialize() {
        var a = FXCollections.observableArrayList(mainService.showMenu());
        MenuList.setItems(a);

        CreateClient.setOnAction(event -> {
            CreateClient createClient = new CreateClient();
            mainService = createClient.start(mainService);
            while (mainService.getClientService() == null) {
                try {
                    primaryStage.wait();
                } catch (InterruptedException e) {
                    System.out.println("облажалась");
                    e.printStackTrace();
                }
            }
            try {
                var personalMenu = FXCollections.observableArrayList(mainService.showPersonalMenu(mainService.getLastClientId()));
                MenuList.setItems(personalMenu);
                currentId = mainService.getLastClientId();
            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ошибка добавления клиента");
                alert.setHeaderText("Произошла ошибка при создании клиента!");
                alert.setContentText("Пожалуйста, повторите попытку для дальнейшей работы!");

                alert.showAndWait();
            }

        });

        CheckoutBtn.setOnAction(event -> {
            try {
                var order = readOrder(PositionsField.getText());
                mainService.order(order, currentId);
                //Order showOrder = new Order();
                //showOrder.start(mainService.showOrder(currentId));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Оформление заказа");
                alert.setHeaderText("Ваш заказ:");
                alert.setContentText(mainService.showOrder(currentId));
                alert.showAndWait();
            } catch (Exception e) {
                //e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка ввода");
                alert.setHeaderText("При заказе были введены некорректные данные!");
                alert.setContentText("Пожалуйста, повторите попытку, разделите номера позиций запятыми.");

                alert.showAndWait();
            }

        });
    }

    private List<Integer> readOrder(String orderString) throws Exception {
        orderString = orderString.replaceAll("\\s+", "");
        var order = orderString.split(",");
        //int[] result = new int[order.length];
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < order.length; i++) {
            result.add(Integer.parseInt(order[i]));
        }
        return result;
    }

    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/AppView2.fxml"));
        this.primaryStage.setTitle("Меню ресторана");
        this.primaryStage.setScene(new Scene(root, 600, 600));
        this.primaryStage.setMinWidth(300);
        this.primaryStage.setMinHeight(300);
        this.primaryStage.show();
    }
}
