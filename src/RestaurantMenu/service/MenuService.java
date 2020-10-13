package RestaurantMenu.service;

import RestaurantMenu.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    public Menu getMenu() {
        return menu;
    }

    public void demo() {
       List<Dish> demo = new ArrayList<>();
       demo.add(new Dish("Цезарь", 290.0, 600, Arrays.asList(new Ingredient("Курица", Restriction.NOT_VEGAN),
               new Ingredient("Салат", Restriction.NONE )), Category.SALAD));
       demo.add(new Dish("Том Ям", 300.0, 600, Arrays.asList(new Ingredient("Креветка", Restriction.STRONG_ALLERGENS),
               new Ingredient("Перец", Restriction.NOT_SPICY )), Category.SOUP));
        menu.setDishes();
    }
}
