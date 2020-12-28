package RestaurantMenu.view;

import RestaurantMenu.model.Restriction;
import RestaurantMenu.service.MainService;

import java.util.*;

public class MainView {
    private final static MainService mainService = new MainService();
    private final static Scanner scanner = new Scanner(System.in);

    private void newOrder(long id) {
        String command;
        System.out.println("Are you here for the first time?");
        command = scanner.nextLine();
        if("yes".equals(command.toLowerCase())) {
            System.out.print("Hello!\nPlease fill in the following fields\nYour name: ");
            String name = scanner.nextLine();
            System.out.print("Your free time: ");
            int time = scanner.nextInt();
            System.out.print("Your money: ");
            double money = scanner.nextDouble();
            EnumSet<Restriction> restrictions = EnumSet.noneOf(Restriction.class);
            System.out.print("Your restriction: ");
            command = scanner.next();
            System.out.println("Print 'exit', when you finish!");
            do {
                restrictions.add(Restriction.valueOf(command));
                command = scanner.next();
            } while (!"Exit".equalsIgnoreCase(command));

            try {
                //
                mainService.menuFormation(name, time, money, restrictions);
                id = mainService.getLastClientId();
            } catch (Exception e) {
                System.out.println("You entered incorrect data");
            }
        }
        if("no".equals(command.toLowerCase())){
            System.out.println("Enter your ID");
            id = scanner.nextLong();

        }

        System.out.println(mainService.showPersonalMenu(id));

        System.out.println("Enter the ID of the dishes you want to order. Print 'exit', when you finish!");
        List<Integer> ids = new ArrayList<>();
        String idDish = scanner.next();
        while (!"Exit".equalsIgnoreCase(idDish)) {
            ids.add(Integer.parseInt(idDish));
            idDish = scanner.next();
        }

        mainService.order(ids, id);
        System.out.println(mainService.showOrder(id));
    }

    public void ShowMainService() {
        long id = -1;
        String command;
        try {
            newOrder(id);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No positions available");
        }

        System.out.println("Do you want to start new order? ");
        command = scanner.nextLine().toLowerCase();
        boolean status = false;
        do {
            command = scanner.nextLine();
            switch (command) {
                case "yes":
                    newOrder(id);
                    status = true;
                    break;
                case "no":
                    System.out.println("Bye! We are waiting for you again!");
                    status = true;
                    break;
                default:
                    System.out.println("Wrong input, please try again!");

            }
        }while (!status);

    }
}
