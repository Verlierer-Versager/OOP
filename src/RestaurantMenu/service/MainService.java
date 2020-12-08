package RestaurantMenu.service;

import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Order;
import RestaurantMenu.model.Restriction;

import java.util.*;

public class MainService {
    private final static DishService dishService = new DishService();
    private final static MenuService menuService = new MenuService();
    private final static ClientService clientService = new ClientService();
    private final static DiscountService discountService = new DiscountService();


    public void menuFormation(long id, int time, double money, EnumSet<Restriction> restrictions) throws Exception {
        clientService.createClient(id, time, money, restrictions);//создание клиента
        menuService.demo(dishService);
        var formattedMenu = menuService.formMenuForCurrentClient(restrictions, dishService); //выстраивание доступных блюд из меню по ограничениям
        clientService.setPersonalMenu(formattedMenu);

    }

    public void order(List<Integer> ids) {
        List<Dish> order = new ArrayList<>();
        Set<Set<Dish>> combos = new LinkedHashSet<>();
        Set<Dish> set = new LinkedHashSet<>();
        set.add(menuService.getMenu().getDishes().get(0));
        set.add(menuService.getMenu().getDishes().get(1));
        combos.add(set);
        discountService.setCombinations(combos);
        for (var element: ids) {
            order.add(clientService.getPersonalMenu().getDishes().get(element));
        }
        var withDiscount = discountService.countDiscount(order, dishService);
        int time = 0;
        double bill = 0.0;
        for (var dish: withDiscount) {
            time += dish.getTime();
            bill += dish.getPrice();
        }
        if(clientService.isAvailable(time, bill)) {
            clientService.order(new Order(time, bill, withDiscount));
        }
    }

    public String showOrder() {
        return clientService.getClient().getOrder().toString();
    }

    public String showMenu() {
        return menuService.getMenu().toString();
    }

    /*public List getMenu() {
        return clientService.getPersonalMenu();
    }*/

    public String showPersonalMenu() {
        return clientService.getPersonalMenu().toString();
    }
}