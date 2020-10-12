package RestaurantMenu.service;

import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Ingredient;
import RestaurantMenu.model.Menu;

import java.util.List;

public class MenuService {
    private Menu menu = new Menu();
    private final DishService dishService;

    public MenuService(DishService dishService) {
        this.dishService = dishService;
    }

    public void add(String name, double price, int time, List<Ingredient> ingredients) {
        Dish dish = dishService.createDish(name, price, time, ingredients);
        var newDishes = menu.getDishes();
        newDishes.add(dish);
        menu.setDishes(newDishes);
    }
}
