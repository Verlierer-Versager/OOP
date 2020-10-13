package RestaurantMenu.service;

import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Restriction;

import java.util.List;
import java.util.Set;

public class MainService {
    private final static DishService dishService = new DishService();
    private final static MenuService menuService = new MenuService();
    private final static ClientService clientService = new ClientService();


    public void menuFormation(int time, double money, Set<Restriction> restrictions) throws Exception {
        clientService.createClient(time, money, restrictions); //создание клиента
        var formattedMenu = menuService.formMenuForCurrentClient(restrictions, dishService); //выстраивание доступных блюд из меню по ограничениям
    }

    public void order(List<Dish> order) {
        clientService.order(order);
    }

    public void checkForDiscount() {

    }
}
