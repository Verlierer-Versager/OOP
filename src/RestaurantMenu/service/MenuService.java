package RestaurantMenu.service;

import RestaurantMenu.model.*;

import java.lang.reflect.Array;
import java.util.*;

public class MenuService {
    private Menu menu = new Menu();
    //private final DishService dishService;

    /*public MenuService(DishService dishService) {
        this.dishService = dishService;
    }*/

    /*public  getMenu(DishService dishService) {
        return menu.getDishes();
    }
*/
    public void add(String name, double price, int time, List<Ingredient> ingredients, DishService dishService, Category category, long id) {
        Dish dish = dishService.createDish(name, price, time, ingredients, category, id);
        var newDishes = menu.getDishes();
        newDishes.add(dish);
        menu.setDishes(newDishes);
    }

    public Menu formMenuForCurrentClient(EnumSet<Restriction> restrictions, DishService dishService) {
        var fullMenu= menu.getDishes();
        List<Dish> personalMenu = new ArrayList<>();
        for (var dish: fullMenu) {
            if (dishService.isDishCorrect(restrictions, dish)) {
                personalMenu.add(dish);
            }
        }
        Menu newMenu = new Menu();
        newMenu.setDishes(personalMenu);
        return newMenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void demo(DishService dishService) {
       List<Dish> demo = new ArrayList<>();
       var cesar = new ArrayList<Ingredient>();
       cesar.add(new Ingredient("Курица", Restriction.NOT_VEGAN));
        cesar.add(new Ingredient("Салат", Restriction.NONE ));
       demo.add(new Dish("Цезарь", 290.0, 600, cesar, Category.SALAD, demo.size()));

        var tom = new ArrayList<Ingredient>();
        cesar.add(new Ingredient("Креветка", Restriction.STRONG_ALLERGENS));
        cesar.add(new Ingredient("Перец", Restriction.NOT_SPICY ));
       demo.add(new Dish("Том Ям", 300.0, 1200, tom, Category.SOUP, demo.size()));
       /*demo.add(new Dish("Компот", 60.0, 600, Arrays.asList(new Ingredient("Сухофрукты", Restriction.NONE),
                new Ingredient("Вода", Restriction.NONE )), Category.DRINK, demo.size()));
        demo.add(new Dish("Крем брюле", 240.0, 300, Arrays.asList(new Ingredient("Сливки", Restriction.NOT_VEGAN),
                new Ingredient("Сахар", Restriction.NONE )), Category.DESSERTS, demo.size()));*/
        for (var element: demo) {
            dishService.setRestriction(element);
        }
        menu.setDishes(demo);
    }
}
