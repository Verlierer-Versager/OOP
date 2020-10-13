package RestaurantMenu.service;

import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Ingredient;
import RestaurantMenu.model.Menu;
import RestaurantMenu.model.Restriction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MenuService {
    private Menu menu = new Menu();
    //private final DishService dishService;

    /*public MenuService(DishService dishService) {
        this.dishService = dishService;
    }*/

    public void add(String name, double price, int time, List<Ingredient> ingredients, DishService dishService) {
        Dish dish = dishService.createDish(name, price, time, ingredients);
        var newDishes = menu.getDishes();
        newDishes.add(dish);
        menu.setDishes(newDishes);
    }

    public List<Dish> formMenuForCurrentClient(Set<Restriction> restrictions, DishService dishService) {
        var fullMenu= menu.getDishes();
        List<Dish> personalMenu = new ArrayList<>();
        for (var dish: fullMenu) {
            if (dishService.isDishCorrect(restrictions, dish)) {
                personalMenu.add(dish);
            }
        }
        return personalMenu;
    }
}
