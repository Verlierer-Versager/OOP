package RestaurantMenu.service;

import RestaurantMenu.model.*;

import java.util.*;

public class MainService {
    private DishService dishService = new DishService();
    private MenuService menuService = new MenuService();
    private ClientService clientService = new ClientService();
    private DiscountService discountService = new DiscountService();


    public void menuFormation(String name, int time, double money, EnumSet<Restriction> restrictions) throws Exception {

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

    public Menu getMenu(long id) {
        return clientService.getPersonalMenu(id);
    }

    public String showPersonalMenu(long id) {
        return clientService.getPersonalMenu(id).toString();
    }

    public long getLastClientId() {
        try {
            return clientService.getLastClient().getId();
        }catch (NullPointerException e) {
            throw new NullPointerException("No client has been added");
        }
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}