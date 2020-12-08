package RestaurantMenu.view;

import java.net.URL;
import java.util.EnumSet;
import java.util.ResourceBundle;

import RestaurantMenu.model.Restriction;
import RestaurantMenu.service.ClientService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateClientView {
    private final static ClientService clientService = new ClientService();


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
            if (restrictions.isEmpty()) {
                restrictions.add(Restriction.NONE);
            }
            try {
                clientService.createClient(name, time, money, restrictions);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) CreateBtn.getScene().getWindow();
            stage.close();
        });

    }

    public void start() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("fxml/CreateClientView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Меню ресторана");
            stage.setScene(new Scene(root, 600, 600));
            stage.setMinWidth(300);
            stage.setMinHeight(300);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
