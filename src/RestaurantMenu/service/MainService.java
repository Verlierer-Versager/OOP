package RestaurantMenu.service;

import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Order;
import RestaurantMenu.model.Restriction;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class MainService {
    private final static DishService dishService = new DishService();
    private final static MenuService menuService = new MenuService();
    private final static ClientService clientService = new ClientService();
    private final static DiscountService discountService = new DiscountService();


    public void menuFormation(int time, double money, Set<Restriction> restrictions) throws Exception {
        clientService.createClient(time, money, restrictions);//создание клиента
        menuService.demo(dishService);
        var formattedMenu = menuService.formMenuForCurrentClient(restrictions, dishService); //выстраивание доступных блюд из меню по ограничениям
        clientService.setPersonalMenu(formattedMenu);

    }

    public void order(List<Integer> ids) {
        List<Dish> order = new ArrayList<>();
        for (var element: ids) {
            order.add(clientService.getPersonalMenu().getDishes().get(element));
        }
        var withDiscount = discountService.countDiscount(order);
        int time = 0;
        double bill = 0.0;
        for (var dish: order) {
            if(withDiscount.contains(dish)) {
                bill += dish.getPrice() * (1 - discountService.getDiscount().getDiscount()/100.0);
            } else {
                bill += dish.getPrice();
            }

            time += dish.getTime();
        }
        if(clientService.isAvailable(time, bill)) {
            clientService.order(new Order(time, bill, order));
        }
    }

    public String showOrder() {
        return clientService.getClient().getOrder().toString();
    }

    public String showMenu() {
        return menuService.getMenu().toString();
    }

    public String showPersonalMenu() {
        return clientService.getPersonalMenu().toString();
    }
}