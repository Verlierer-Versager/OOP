package RestaurantMenu.view;

import java.net.URL;
import java.util.EnumSet;
import java.util.ResourceBundle;

import RestaurantMenu.model.Restriction;
import RestaurantMenu.service.ClientService;
import RestaurantMenu.service.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CreateClient {
    private static ClientService clientService  = new ClientService();
    private static MainService mainService = new MainService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label NameLbl;

    @FXML
    private Label TimeLbl;

    @FXML
    private Label MoneyLbl;

    @FXML
    private TextField TimeField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField MoneyField;

    @FXML
    private RadioButton AdultRadioBtn;

    @FXML
    private RadioButton AllergenRadioBtn;

    @FXML
    private RadioButton VegetarianRadioBtn;

    @FXML
    private RadioButton VeganRadioBtn;

    @FXML
    private RadioButton SpicyRadioBtn;

    @FXML
    private Button CreateBtn;

    @FXML
    void initialize() {
        CreateBtn.setOnAction(event -> {
            try {
                String name = NameField.getText();
                int time = Integer.parseInt(TimeField.getText());
                double money = Double.parseDouble(MoneyField.getText());

                EnumSet<Restriction> restrictions = EnumSet.noneOf(Restriction.class);

                AdultRadioBtn.setOnAction(event1 -> {
                    restrictions.add(Restriction.FOR_ADULTS_ONLY);
                });
                AllergenRadioBtn.setOnAction(event1 -> {
                    restrictions.add(Restriction.STRONG_ALLERGENS);
                });
                VegetarianRadioBtn.setOnAction(event1 -> {
                    restrictions.add(Restriction.NOT_VEGETARIAN);
                });
                VeganRadioBtn.setOnAction(event1 -> {
                    restrictions.add(Restriction.NOT_VEGAN);
                });
                SpicyRadioBtn.setOnAction(event1 -> {
                    restrictions.add(Restriction.NOT_SPICY);
                });
                if(restrictions.isEmpty()) {
                    restrictions.add(Restriction.NONE);
                }
                try {
                    mainService.menuFormation(name, time, money, restrictions);
                    //clientService.createClient(name, time, money, restrictions);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ошибка создания клиента");
                alert.setHeaderText("При созздании клиента были введены некорректные данные.");
                alert.setContentText("Пожалуйста, повторите попытку");

                alert.showAndWait();
            }

            Stage stage = (Stage) CreateBtn.getScene().getWindow();
            stage.close();
        });

    }

    public MainService start(MainService mainService) {
        Parent root;
        this.mainService = mainService;
        try {
            root = FXMLLoader.load(getClass().getResource("fxml/CreateClient.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Создание клиента");
            stage.setScene(new Scene(root, 600, 400));
            stage.setMinWidth(300);
            stage.setMinHeight(300);
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainService;
    }
}
