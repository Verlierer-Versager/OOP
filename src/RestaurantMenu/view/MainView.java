package RestaurantMenu.view;

import RestaurantMenu.model.Restriction;
import RestaurantMenu.service.MainService;

import java.util.*;

public class MainView {
    private final static MainService mainService = new MainService();
    private final static Scanner scanner = new Scanner(System.in);

    public void ShowMainService() {
        System.out.print("Hello!\nPlease fill in the following fields\nYour free time: ");
        int time = scanner.nextInt();
        System.out.print("Your money: ");
        double money = scanner.nextDouble();
        Set<Restriction> restrictions = new LinkedHashSet<>();
        System.out.print("Your restriction: ");
        String command = scanner.next();
        System.out.println("Print 'exit', when you finish!");
        do {
            restrictions.add(Restriction.valueOf(command));
            command = scanner.next();
        } while (!"Exit".equalsIgnoreCase(command));

        try {
            mainService.menuFormation(time, money, restrictions);
        } catch (Exception e) {
            System.out.println("You entered incorrect data");
        }

        System.out.println(mainService.showPersonalMenu());

        System.out.println("Enter the ID of the dishes you want to order. Print 'exit', when you finish!");
        List<Integer> ids = new ArrayList<>();
        String id = scanner.next();
        while (!"Exit".equalsIgnoreCase(id)) {
            ids.add(Integer.parseInt(id));
            id = scanner.next();
        }

        mainService.order(ids);
        System.out.println(mainService.showOrder());

    }
}
