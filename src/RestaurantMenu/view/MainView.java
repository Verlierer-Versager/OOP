package RestaurantMenu.view;

import RestaurantMenu.service.MainService;

import java.util.Scanner;

public class MainView {
    private final static MainService mainService = new MainService();
    private final static Scanner scanner = new Scanner(System.in);

    public void ShowMainService() {
        System.out.println("Hello!\n");
    }
}
