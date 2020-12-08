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


    public void menuFormation(String name, long id, int time, double money, EnumSet<Restriction> restrictions) throws Exception {
        clientService.createClient(name, time, money, restrictions);//создание клиента
        menuService.demo(dishService);
        var formattedMenu = menuService.formMenuForCurrentClient(restrictions, dishService); //выстраивание доступных блюд из меню по ограничениям
        clientService.setPersonalMenu(formattedMenu, clientService.getLastClient().getId());

    }

    public void order(List<Integer> ids, long id) {
        List<Dish> order = new ArrayList<>();
        Set<Set<Dish>> combos = new LinkedHashSet<>();
        Set<Dish> set = new LinkedHashSet<>();
        set.add(menuService.getMenu().getDishes().get(0));
        set.add(menuService.getMenu().getDishes().get(1));
        combos.add(set);
        discountService.setCombinations(combos);
        for (var element: ids) {
            order.add(clientService.getPersonalMenu(id).getDishes().get(element));
        }
        var withDiscount = discountService.countDiscount(order, dishService);
        int time = 0;
        double bill = 0.0;
        for (var dish: withDiscount) {
            time += dish.getTime();
            bill += dish.getPrice();
        }
        if(clientService.isAvailable(id, time, bill)) {
            clientService.order(new Order(time, bill, withDiscount), id);
        }
    }

    public String showOrder(long id) {
        return clientService.getClient(id).getOrder().toString();
    }

    //public List<String>

    public List<String> showMenu() {
        menuService.demo(dishService);
        var menu = menuService.getMenu().getDishes();
        List<String> showMenu = new ArrayList<>();
        showMenu.add("Название                                  Время ожидания                                  Цена");
        for(var dish: menu) {
            showMenu.add(dish.toString());
        }
        return showMenu;
    }

    /*public List getMenu() {
        return clientService.getPersonalMenu();
    }*/

    public String showPersonalMenu(long id) {
        return clientService.getPersonalMenu(id).toString();
    }
}